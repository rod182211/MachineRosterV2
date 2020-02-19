package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;

import org.optaplanner.examples.nurserostering.domain.Machine;

import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.optaplanner.examples.nurserostering.domain.ShiftTypeMachineRequirement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ShiftTypeMachineRequirementEditController implements Initializable {
	
	

	@FXML
	private ComboBox<ShiftType> shiftType;
	@FXML
	private ComboBox<Machine> machine;
	
	private Stage dialogStage;



	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	
	private ObservableList<ShiftType> shiftListId = FXCollections.observableArrayList();

	public ObservableList<ShiftType> getShiftListId() {
		if (!shiftListId.isEmpty())
			shiftListId.clear();
		shiftListId = FXCollections.observableList((List<ShiftType>) rosterService.listShiftType());
		return shiftListId;
	}
	private ObservableList<Machine> machineList = FXCollections.observableArrayList();
	private ShiftTypeMachineRequirement machines;

	public ObservableList<Machine> getMachineList() {
		if (!machineList.isEmpty())
			machineList.clear();
		machineList = FXCollections.observableList((List<Machine>) rosterService.listMachine());
		return machineList;
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
	 * @param employee 
	 * 
	 * @param employee
	 */
	
	public void setShiftTypeMachineRequirements(ShiftTypeMachineRequirement machines) {
		this.machines = machines;
		 getShiftListId();
		 getMachineList();
		 machine.setItems(machineList);
		 machine.setValue(machines.getMachine());
		 shiftType.setItems(shiftListId);
		 shiftType.setValue(machines.getShiftType());
		
	
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
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
		ShiftType type = shiftType.getSelectionModel().getSelectedItem();
		machines.setShiftType(type);
		Machine deptype = machine.getSelectionModel().getSelectedItem();
		machines.setMachine(deptype);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Update Succesful!");
		alert.showAndWait();
		dialogStage.close();
		okClicked = true;
		rosterService.updateShiftTypeMachineRequirement(machines);

	}
	
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	private boolean isInputValid() {
		String errorMessage = "";

		
		  if (shiftType.getSelectionModel().getSelectedItem() == null) {
			  errorMessage += "No valid  Shift Type!\n"; }
		  if (machine.getSelectionModel().getSelectedItem() == null) {
			  errorMessage += "No valid Machine!\n"; }
		 
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
