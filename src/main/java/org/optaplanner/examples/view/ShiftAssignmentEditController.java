package org.optaplanner.examples.view;

import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;


import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.ShiftTypeSkillRequirement;

import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.optaplanner.examples.nurserostering.domain.Skill;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.TextField;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ShiftAssignmentEditController implements Initializable {


	
	@FXML
	private ComboBox<ShiftType> shift;
	@FXML
	private ComboBox<Skill> skills;

	@FXML
	private TextField size;


	private Stage dialogStage;

	private ShiftTypeSkillRequirement skillrequirement;
	
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();

	

	private ObservableList<ShiftTypeSkillRequirement> shiftAssignmentList = FXCollections.observableArrayList();

	public ObservableList<ShiftTypeSkillRequirement> getShiftTypeSkillRequirementList() {
		if (!shiftAssignmentList.isEmpty())
			shiftAssignmentList.clear();
		shiftAssignmentList = FXCollections
				.observableList((List<ShiftTypeSkillRequirement>) rosterService.listShiftTypeSkillRequirement());
		return shiftAssignmentList;
	}


	private ObservableList<Shift> shiftList = FXCollections.observableArrayList();
	

	public ObservableList<Shift> getShiftList() {
		if (!shiftList.isEmpty())
			shiftList.clear();
		shiftList = FXCollections.observableList((List<Shift>) rosterService.listShiftcode());
		return shiftList;
	}
	
private ObservableList<ShiftType> shifttypeList = FXCollections.observableArrayList();
	

	public ObservableList<ShiftType> getShiftTypeList() {
		if (!shifttypeList.isEmpty())
			shifttypeList.clear();
		shifttypeList = FXCollections.observableList((List<ShiftType>) rosterService.listShiftType());
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


	
	public void setShiftTypeSkillRequirement(ShiftTypeSkillRequirement skillrequirement) {
		this.skillrequirement = skillrequirement;
		getSkillsList();
		getShiftTypeList();
		shift.setItems(shifttypeList);
		shift.setValue(skillrequirement.getShiftType());
		skills.setItems(skillsList);
		skills.setValue(skillrequirement.getSkill());
		
		
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
			ShiftType shiftype = shift.getSelectionModel().getSelectedItem();
			skillrequirement.setShiftType(shiftype);
			okClicked = true;
			rosterService.updateShiftTypeSkillRequirement(skillrequirement);
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
		if (shift.getSelectionModel().getSelectedItem() == null ) {
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


