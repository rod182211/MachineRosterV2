package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class ShiftEditController implements Initializable {

	
	@FXML
	private TextField Shift;

	@FXML
	private TextField startTime;

	@FXML
	private TextField finishTime;
	
	@FXML
	private TextField shiftdescription;

	@FXML
	private CheckBox isNight;

	private Stage dialogStage;

	private ShiftType shift;
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<ShiftType> shiftList = FXCollections.observableArrayList();

	public ObservableList<ShiftType> getSkillsList() {
		if (!shiftList.isEmpty())
			shiftList.clear();
		shiftList = FXCollections.observableList((List<ShiftType>) rosterService.listShiftType());
		return shiftList;
	}

	private ObservableList<ShiftType> shiftListId = FXCollections.observableArrayList();

	public ObservableList<ShiftType> getShiftListId() {
		if (!shiftListId.isEmpty())
			shiftListId.clear();
		shiftListId = FXCollections.observableList((List<ShiftType>) rosterService.listShiftType());
		return shiftListId;
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

	public void setShift(ShiftType shift) {
		this.shift = shift;
		Shift.setText(shift.getCode());
		startTime.setText(shift.getStartTimeString());
		finishTime.setText(shift.getEndTimeString());
		shiftdescription.setText(shift.getDescription());
		isNight.setText(Boolean.toString(shift.isNight()));
		
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

			
			String shift1 = Shift.getText();
			shift.setCode(shift1);
			if (isNight.isSelected()) {
				boolean selected = true;
		    	shift.setNight(selected);
				}else {
					
				boolean notselected = false;
				shift.setNight(notselected);
				}
			String endtime = finishTime.getText();
			shift.setEndTimeString(endtime);
			String starttime = startTime.getText();
			shift.setStartTimeString(starttime);
			String shiftDescription = shiftdescription.getText();
			shift.setDescription(shiftDescription);
			okClicked = true;
			rosterService.updateShiftType(shift);
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
	private boolean isInputValid() {
		String errorMessage = "";

		if (Shift.getText() == null || Shift.getText().length() == 0) {
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
