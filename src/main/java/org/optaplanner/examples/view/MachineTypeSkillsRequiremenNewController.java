package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Machine;
import org.optaplanner.examples.nurserostering.domain.MachineTypeSkillsRequirement;
import org.optaplanner.examples.nurserostering.domain.Skill;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MachineTypeSkillsRequiremenNewController implements Initializable {


	
	@FXML
	private ComboBox<Machine> machine;
	@FXML
	private ComboBox<Skill> skills;

	@FXML
	private TextField size;


	private Stage dialogStage;

	private MachineTypeSkillsRequirement skillrequirement;
	
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();

	

	private ObservableList<MachineTypeSkillsRequirement> shiftAssignmentList = FXCollections.observableArrayList();

	public ObservableList<MachineTypeSkillsRequirement> getShiftTypeSkillRequirementList() {
		if (!shiftAssignmentList.isEmpty())
			shiftAssignmentList.clear();
		shiftAssignmentList = FXCollections
				.observableList((List<MachineTypeSkillsRequirement>) rosterService.listMachineTypeSkillsRequirement());
		return shiftAssignmentList;
	}

	
private ObservableList<Machine> shifttypeList = FXCollections.observableArrayList();
	

	public ObservableList<Machine> getMachineList() {
		if (!shifttypeList.isEmpty())
			shifttypeList.clear();
		shifttypeList = FXCollections.observableList((List<Machine>) rosterService.listMachine());
		return shifttypeList;
	}
	
	private ObservableList<Skill> skillsList = FXCollections.observableArrayList();

	public ObservableList<Skill> getSkillsList() {
		if (!skillsList.isEmpty())
			skillsList.clear();
		skillsList = FXCollections.observableList((List<Skill>) rosterService.listSkill());
		return skillsList;
	}


	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the employee to be edited in the dialog.
	 * 
	 * @param employee
	 */


	
	public void setMachineTypeSkillsRequirement(MachineTypeSkillsRequirement skillrequirement) {
		this.skillrequirement = skillrequirement;
		getSkillsList();
		getMachineList();
		machine.setItems(shifttypeList);
		skills.setItems(skillsList);
	
		
		
	}

	/**
	 * Returns true if the user licked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			
			Skill skill = skills.getSelectionModel().getSelectedItem();
			skillrequirement.setSkill(skill);
			Machine machinetype = machine.getSelectionModel().getSelectedItem();
			skillrequirement.setMachine(machinetype);
			okClicked = true;
			rosterService.addMachineTypeSkillsRequirement(skillrequirement);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Update Succesfulll!");
			alert.showAndWait();
			dialogStage.close();
		}
	
	}
	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	@SuppressWarnings("unused")
	private boolean isInputValid() {
		String errorMessage = "";

		if (skills.getSelectionModel().getSelectedItem() == null ) {
			errorMessage += "No valid Skill!\n";
		}
		if (machine.getSelectionModel().getSelectedItem() == null ) {
			errorMessage += "No valid Shift!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}


