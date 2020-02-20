package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.MachineTypeSkillsRequirement;
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

public class MachineTypeSkillsRequirementController implements Initializable {

	@FXML
	private TableView<MachineTypeSkillsRequirement> shiftAssignmentable;

	@FXML
	private TableColumn<MachineTypeSkillsRequirement, String> machinetype;

	@FXML
	private TableColumn<MachineTypeSkillsRequirement, String> skills;
	@FXML
	private TableColumn<MachineTypeSkillsRequirement, String> shiftType;
	

	@FXML
	private Label Id;
	@FXML
	private Label machine;
	@FXML
	private Label skill;
	@FXML
	private Label shift;
	
	
	private RosterService rosterService = new RosterServiceImpl();

	private ObservableList<MachineTypeSkillsRequirement> shiftAssignmentList = FXCollections.observableArrayList();

	public ObservableList<MachineTypeSkillsRequirement> getMachineTypeSkillsRequirementList() {
		if (!shiftAssignmentList.isEmpty())
			shiftAssignmentList.clear();
		shiftAssignmentList = FXCollections
				.observableList((List<MachineTypeSkillsRequirement>) rosterService.listMachineTypeSkillsRequirement());
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
		shiftAssignmentable.setItems(getMachineTypeSkillsRequirementList());
		shiftAssignmentable.setEditable(true);
		shiftType.setCellValueFactory(new PropertyValueFactory<MachineTypeSkillsRequirement, String>("shiftType"));
		machinetype.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMachine().getCode()));
		skills.setCellValueFactory(new PropertyValueFactory<MachineTypeSkillsRequirement, String>("skill"));
		
	
		
		
		shiftAssignmentable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftAssignmentDetails(newValue));
	}

	
	private void showShiftAssignmentDetails(MachineTypeSkillsRequirement skillrequirement) {
		if (skillrequirement != null) {

			shift.setText(skillrequirement.getShiftType().getCode());
			machine.setText(skillrequirement.getMachine().getCode());
			skill.setText(skillrequirement.getSkill().getCode());
			
			

		} else { 

			shift.setText("");
			machine.setText("");
			skill.setText("");
			
			
		}
	}

	@FXML
	private void handleDeleteShiftAssignment() {
		int selectItem = shiftAssignmentable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			ObservableList<MachineTypeSkillsRequirement> itemsSelected;
			 itemsSelected = shiftAssignmentable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeMachineTypeSkillsRequirement(itemsSelected);
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
		MachineTypeSkillsRequirement tempassignment = new MachineTypeSkillsRequirement();
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
		MachineTypeSkillsRequirement selectedAssignment = shiftAssignmentable.getSelectionModel().getSelectedItem();

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

	public boolean showShiftAssignmentEditDialog(MachineTypeSkillsRequirement skillrequirement) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/MachineSkillsAssignmentEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Assignment");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MachineTypeSkillsRequiremenEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMachineTypeSkillsRequirement (skillrequirement);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean  showShiftAssignmentNewEditDialog(MachineTypeSkillsRequirement skillrequirement) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MachineSkillsAssignmentNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Assignment");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MachineTypeSkillsRequiremenNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller. setMachineTypeSkillsRequirement(skillrequirement);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}

