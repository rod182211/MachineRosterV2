package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.ShiftTypeSkillRequirement;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ShiftAssignmentController implements Initializable {

	@FXML
	private TableView<ShiftTypeSkillRequirement> shiftAssignmentable;

	@FXML
	private TableColumn<ShiftTypeSkillRequirement, String> shifttype;

		@FXML
	private TableColumn<ShiftTypeSkillRequirement, String> skills;
	

	@FXML
	private Label Id;
	@FXML
	private Label shift;
	@FXML
	private Label skill;
	
	



	public ShiftAssignmentController() {

	}

	private RosterService rosterService = new RosterServiceImpl();

	


	private ObservableList<ShiftTypeSkillRequirement> shiftAssignmentList = FXCollections.observableArrayList();

	public ObservableList<ShiftTypeSkillRequirement> getShiftTypeSkillRequirementList() {
		if (!shiftAssignmentList.isEmpty())
			shiftAssignmentList.clear();
		shiftAssignmentList = FXCollections
				.observableList((List<ShiftTypeSkillRequirement>) rosterService.listShiftTypeSkillRequirement());
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
		shiftAssignmentable.setItems(getShiftTypeSkillRequirementList());
		shiftAssignmentable.setEditable(true);
		shifttype.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftType().getCode()));
		skills.setCellValueFactory(new PropertyValueFactory<ShiftTypeSkillRequirement, String>("skill"));
		
	
		
		
		shiftAssignmentable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftAssignmentDetails(newValue));
	}

	
	private void showShiftAssignmentDetails(ShiftTypeSkillRequirement skillrequirement) {
		if (skillrequirement != null) {

		
			shift.setText(skillrequirement.getShiftType().getCode());
			skill.setText(skillrequirement.getSkill().getCode());
			
			

		} else { 

			
			shift.setText("");
			skill.setText("");
			
			
		}
	}

	@FXML
	private void handleDeleteShiftAssignment() {
		int selectItem = shiftAssignmentable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			ObservableList<ShiftTypeSkillRequirement> itemsSelected;
			 itemsSelected = shiftAssignmentable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeShiftTypeSkillRequirement(itemsSelected);
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
			alert.setHeaderText("No Item Selected");
			alert.setContentText("Please select a Row.");

			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleNewShiftAssignment() {
		ShiftTypeSkillRequirement tempassignment = new ShiftTypeSkillRequirement();
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
		ShiftTypeSkillRequirement selectedAssignment = shiftAssignmentable.getSelectionModel().getSelectedItem();

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
			alert.setHeaderText("No Assignment Selected");
			alert.setContentText("Please select a Assignment in the table.");

			alert.showAndWait();
		}
		loadTable();
	}

	public boolean showShiftAssignmentEditDialog(ShiftTypeSkillRequirement skillrequirement) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/ShiftAssignmentEditDialog.fxml"));
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
			ShiftAssignmentEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftTypeSkillRequirement (skillrequirement);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean  showShiftAssignmentNewEditDialog(ShiftTypeSkillRequirement skillrequirement) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShiftAssignmentNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Assignment");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftAssignmentNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller. setShiftAssignmentNewData(skillrequirement);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}

