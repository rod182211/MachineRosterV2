package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.examples.nurserostering.domain.contract.PatternContractLine;
import org.optaplanner.examples.nurserostering.domain.pattern.WorkBeforeFreeSequencePattern;
import org.hibernate.Session;
import org.optaplanner.database.HibernateUtil;
import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WorkBeforeController implements Initializable {

	@FXML
	private Label applicatonname;

	@FXML
	private TableView<WorkBeforeFreeSequencePattern> workBeforeTable;

	@FXML
	private TableColumn<WorkBeforeFreeSequencePattern, String> workBeforeCode;

	@FXML
	private TableColumn<WorkBeforeFreeSequencePattern, Integer> workBeforeWeight;

	@FXML
	private TableColumn<WorkBeforeFreeSequencePattern, Integer> workBeforeDayLength;

	@FXML
	private TableColumn<WorkBeforeFreeSequencePattern,Integer> dayOfWeek;

	@FXML
	private TableColumn<WorkBeforeFreeSequencePattern, String> shiftType;

	
	@FXML
	private Label beforeCode;

	@FXML
	private Label beforeWeight;

	@FXML
	private Label beforeFreeDay;

	@FXML
	private Label beforeShiftType;

	@FXML
	private Label beforeDayOfWeek;
	private static Session session;
	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<WorkBeforeFreeSequencePattern> workbeforeList = FXCollections.observableArrayList();

	public ObservableList<WorkBeforeFreeSequencePattern> getWorkBeforeFreeSequencePatternList() {
		if (!workbeforeList.isEmpty())
			workbeforeList.clear();
		workbeforeList = FXCollections.observableList(
				(List<WorkBeforeFreeSequencePattern>) rosterService.listWorkBeforeFreeSequencePattern());
		return workbeforeList;
	}
	private ObservableList<PatternContractLine> patterndataList = FXCollections.observableArrayList();

	public ObservableList<PatternContractLine> getPatternContractLineList() {
		if (!patterndataList.isEmpty())
			patterndataList.clear();
		patterndataList = FXCollections
				.observableList((List<PatternContractLine>) rosterService.listPatternContractLine());
		return patterndataList;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadWorkBefore();

	}

	public void loadWorkBefore() {
		workBeforeTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		workBeforeTable.getItems().clear();
		workBeforeTable.setItems(getWorkBeforeFreeSequencePatternList());
		workBeforeWeight.setCellValueFactory(new PropertyValueFactory<WorkBeforeFreeSequencePattern, Integer>("weight"));
		workBeforeCode.setCellValueFactory(new PropertyValueFactory<WorkBeforeFreeSequencePattern, String>("code"));
		workBeforeDayLength.setCellValueFactory(new PropertyValueFactory<WorkBeforeFreeSequencePattern, Integer>("freeDayLength"));
		dayOfWeek.setCellValueFactory(new PropertyValueFactory<WorkBeforeFreeSequencePattern, Integer>("dayofWeek"));
		shiftType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWorkShiftType().getCode()));
		showWorkBeforeDetails(null);
		workBeforeTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showWorkBeforeDetails(newValue));

	}

	private void showWorkBeforeDetails(WorkBeforeFreeSequencePattern workbeforedata) {
		if (workbeforedata != null) {
			// Fill the labels with info from the skill object.
			beforeCode.setText(workbeforedata.getCode());
			beforeWeight.setText(Integer.toString(workbeforedata.getWeight()));
			beforeFreeDay.setText(Integer.toString(workbeforedata.getFreeDayLength()));
			beforeShiftType.setText(workbeforedata.getWorkShiftType().getCode());
		//	beforeDayOfWeek.setText(Integer.toString(workbeforedata.getWorkDayOfWeek().getValue()));
			

		} else {
			
			beforeCode.setText("");
			beforeWeight.setText("");
			beforeFreeDay.setText("");
			beforeDayOfWeek.setText("");
			beforeShiftType.setText("");

		}
	}

	@FXML
	private void handleDeleteWorkBefore() {
		int selectItem = workBeforeTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			WorkBeforeFreeSequencePattern itemsSelected = workBeforeTable.getSelectionModel().getSelectedItem();
			long id = itemsSelected.getId();
			getPatternContractLineList();
			Alert alertpattern = new Alert(AlertType.CONFIRMATION);
			alertpattern.setTitle("STOP");
			alertpattern.setHeaderText("Are you sure");
			alertpattern.setContentText("Click OK if continued or Cancel ");
			Optional<ButtonType> resultpattern = alertpattern.showAndWait();
		    
			if (resultpattern.get() == ButtonType.OK) {

				for (PatternContractLine element : patterndataList) {
					long checkedvalue = element.getId();
					long patid = element.getPattern().getId();
                  
					if (patid == id) {
						
						
						session = HibernateUtil.getSessionFactory().getCurrentSession();
						session.beginTransaction();

						PatternContractLine p = (PatternContractLine) session.get(PatternContractLine.class,
								checkedvalue);
						session.close();
						rosterService.deletePatternContractLine(p);

					}
				}
				rosterService.removeWorkBeforeFreeSequencePattern(itemsSelected);
				loadWorkBefore();
				
			}
			
			else {
				  loadStage("Pattern.fxml");
			}

			} else {
				// Nothing selected.
				Alert alert = new Alert(AlertType.WARNING);
				// alert.initOwner(getPrimaryStage());
				alert.setTitle("No Selection");
				alert.setHeaderText("No item Selected");
				alert.setContentText("Please select a row.");

				alert.showAndWait();
			}
		}

	@FXML
	private void handleNewWorkBefore() {
		WorkBeforeFreeSequencePattern tempworkbefore = new WorkBeforeFreeSequencePattern();
		boolean okClicked = showWorkBeforeNewEditDialog(tempworkbefore);

		if (okClicked) {
//    recall the screen
			loadWorkBefore();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected row
	 */
	@FXML
	private void handleEditWorkBefore() {
		WorkBeforeFreeSequencePattern selectedWorkBefore = workBeforeTable.getSelectionModel().getSelectedItem();

		if (selectedWorkBefore != null) {
			boolean okClicked = showWorkBeforeEditDialog(selectedWorkBefore);
			if (okClicked) {
				showWorkBeforeDetails(selectedWorkBefore);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Row Selected");
			alert.setContentText("Please select a row in the table.");

			alert.showAndWait();
		}
		loadWorkBefore();
	}

	public boolean showWorkBeforeEditDialog(WorkBeforeFreeSequencePattern workbeforedata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/WorkBeforeEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit WorkBefore");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			WorkBeforeEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setWorkBeforeFreeSequencePattern(workbeforedata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showWorkBeforeNewEditDialog(WorkBeforeFreeSequencePattern workbeforedata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/WorkBeforeNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New WorkBefore");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			WorkBeforeNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setWorkBeforeFreeSequencePattern(workbeforedata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	 private void loadStage(String fxml) {
	        try {
	            Parent root = FXMLLoader.load(getClass().getResource(fxml));
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	         //   stage.getIcons().add(new Image("/icons/icon.png"));
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
