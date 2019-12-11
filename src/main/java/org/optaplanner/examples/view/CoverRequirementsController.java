package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.CoverRequirements;
import org.optaplanner.examples.nurserostering.domain.Skill;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.stage.Stage;

public class CoverRequirementsController implements Initializable {

	@FXML
	private TableView<CoverRequirements> shiftAssignmentable;

	@FXML
	private TableColumn<CoverRequirements, String> shifttype;

	@FXML
	private TableColumn<CoverRequirements, Integer> empsize;
		
	@FXML
	private TableColumn<CoverRequirements, Integer> day;

	
	@FXML
	private Label shift;
	@FXML
	private Label size;
	@FXML
	private Label dayfield;
	
	




	public CoverRequirementsController() {

	}

	private RosterService rosterService = new RosterServiceImpl();

	


	private ObservableList<CoverRequirements> shiftAssignmentList = FXCollections.observableArrayList();

	public ObservableList<CoverRequirements> getCoverRequirementsList() {
		if (!shiftAssignmentList.isEmpty())
			shiftAssignmentList.clear();
		shiftAssignmentList = FXCollections
				.observableList((List<CoverRequirements>) rosterService.listCoverRequirements());
		return shiftAssignmentList;
	}

	private ObservableList<Skill> skillsList = FXCollections.observableArrayList();

	public ObservableList<Skill> getSkillsList() {
		if (!skillsList.isEmpty())
			skillsList.clear();
		skillsList = FXCollections.observableList((List<Skill>) rosterService.listSkill());
		return skillsList;
	}

	// -----------------------------------------------------------------------------------------------------------------------

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loadTable();
	}

	private void loadTable() {
		shiftAssignmentable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		shiftAssignmentable.getItems().clear();

		shiftAssignmentable.setItems(getCoverRequirementsList());
		shiftAssignmentable.setEditable(true);
		shifttype.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftType().getCode()));
		day.setCellValueFactory(new PropertyValueFactory<CoverRequirements, Integer>("dayOfWeek"));
		empsize.setCellValueFactory(new PropertyValueFactory<CoverRequirements, Integer>("requiredEmployeesize"));
	
		
		
		shiftAssignmentable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftAssignmentDetails(newValue));
	}

	
	private void showShiftAssignmentDetails(CoverRequirements cover) {
		if (cover != null) {

			shift.setText(cover.getShiftType().getCode());
			dayfield.setText(cover.getDayOfWeek().toString());
			size.setText(Integer.toString(cover.getRequiredEmployeesize()));
			
			

		} else { 

		
			shift.setText("");
			dayfield.setText("");
			size.setText("");
			
			
		}
	}

	@FXML
	private void handleDeleteShiftAssignment() {
		int selectValue = shiftAssignmentable.getSelectionModel().getFocusedIndex();
		if (selectValue >= 0) {
			ObservableList<CoverRequirements> itemsSelected;
			 itemsSelected = shiftAssignmentable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeCoverRequirements(itemsSelected);
				loadTable();
			} else

			{
				loadTable();
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Line Selected");
			alert.setContentText("Please select a Shift in the table.");

			alert.showAndWait();
		}
		loadTable();
	}

	
	@FXML
	private void handleNewShiftAssignment() {
		CoverRequirements tempassignment = new CoverRequirements();
		boolean okClicked = showShiftAssignmentNewEditDialog(tempassignment);

		if (okClicked) {
//    recall the screen
			loadTable();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditShiftAssignment() {
		CoverRequirements selectedAssignment = shiftAssignmentable.getSelectionModel().getSelectedItem();

		if (selectedAssignment != null) {
			boolean okClicked = showShiftAssignmentEditDialog(selectedAssignment);
			if (okClicked) {
				showShiftAssignmentDetails(selectedAssignment);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Contract Selected");
			alert.setContentText("Please select a Contract in the table.");

			alert.showAndWait();
		}
		loadTable();
	}

	public boolean showShiftAssignmentEditDialog(CoverRequirements cover) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/CoverRequirementsEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Contract");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			CoverRequirementsEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setCoverRequirements(cover);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean  showShiftAssignmentNewEditDialog(CoverRequirements cover) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CoverRequirementsNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Assignment");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			 CoverRequirementsNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller. setCoverRequirementsNewData(cover);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}

