package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.optaplanner.database.HibernateUtil;
import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.contract.PatternContractLine;
import org.optaplanner.examples.nurserostering.domain.pattern.FreeBefore2DaysWithAWorkDayPattern;
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

public class FreeBefore2DaysController implements Initializable {

	@FXML
	private TableView<FreeBefore2DaysWithAWorkDayPattern> freedayTable;

	@FXML
	private TableColumn<FreeBefore2DaysWithAWorkDayPattern, Integer> freedayweight;
	@FXML
	private TableColumn<FreeBefore2DaysWithAWorkDayPattern, DayOfWeek> freedayweek;
	@FXML
	private TableColumn<FreeBefore2DaysWithAWorkDayPattern, String> freedaycode;



	@FXML
	private Label freecode;

	@FXML
	private Label freeweight;

	@FXML
	private Label freedayofweek;

	private static Session session;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<FreeBefore2DaysWithAWorkDayPattern> freedayList = FXCollections.observableArrayList();

	public ObservableList<FreeBefore2DaysWithAWorkDayPattern> getFreeBefore2DaysWithAWorkDayPatternList() {
		if (!freedayList.isEmpty())
			freedayList.clear();
		freedayList = FXCollections.observableList((List<FreeBefore2DaysWithAWorkDayPattern>) rosterService
				.listFreeBefore2DaysWithAWorkDayPattern());
		return freedayList;
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
		loadFreeDay();
	}

	public void loadFreeDay() {
		freedayTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		freedayTable.getItems().clear();
		freedayTable.setItems(getFreeBefore2DaysWithAWorkDayPatternList());
		freedayweight.setCellValueFactory(
				new PropertyValueFactory<FreeBefore2DaysWithAWorkDayPattern, Integer>("weight"));
		freedaycode
				.setCellValueFactory(new PropertyValueFactory<FreeBefore2DaysWithAWorkDayPattern, String>("code"));
		freedayweek.setCellValueFactory(
				new PropertyValueFactory<FreeBefore2DaysWithAWorkDayPattern, DayOfWeek>("freeDayOfWeek"));

		showFreedayDetails(null);
		freedayTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showFreedayDetails(newValue));

	}

	private void showFreedayDetails(FreeBefore2DaysWithAWorkDayPattern freeday) {
		if (freeday != null) {
			// Fill the labels with info from the skill object.

			freecode.setText(freeday.getCode());
			freeweight.setText(Integer.toString(freeday.getWeight()));
			freedayofweek.setText(freeday.getFreeDayOfWeek().toString());

		} else {

			freecode.setText("");
			freeweight.setText("");
			freedayofweek.setText("");

		}
	}

	@FXML
	private void handleDeletefreeday() {
		int selectItem = freedayTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			FreeBefore2DaysWithAWorkDayPattern itemsSelected = freedayTable.getSelectionModel().getSelectedItem();
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
				rosterService.removeFreeBefore2DaysWithAWorkDayPattern(itemsSelected);
				loadFreeDay();
				
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
	private void handleNewFreeday() {
		FreeBefore2DaysWithAWorkDayPattern tempfreeday = new FreeBefore2DaysWithAWorkDayPattern();
		boolean okClicked = showFreedayNewEditDialog(tempfreeday);

		if (okClicked) {
			showFreedayDetails(tempfreeday);

		}
		loadFreeDay();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * 
	 */
	@FXML
	private void handleEditFreeday() {
		FreeBefore2DaysWithAWorkDayPattern selectedfreeday = freedayTable.getSelectionModel().getSelectedItem();

		if (selectedfreeday != null) {
			boolean okClicked = showFreedayEditDialog(selectedfreeday);
			if (okClicked) {
				showFreedayDetails(selectedfreeday);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No freeday Selected");
			alert.setContentText("Please select a freeday in the table.");

			alert.showAndWait();
		}
		loadFreeDay();
	}

	public boolean showFreedayEditDialog(FreeBefore2DaysWithAWorkDayPattern freeday) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/FreedayEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Freeday");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			FreedayEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setFreeDay(freeday);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showFreedayNewEditDialog(FreeBefore2DaysWithAWorkDayPattern freeday) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FreedayNewEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Skill");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage)
			 */;
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			FreeDayNewEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setFreeDay(freeday);

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
