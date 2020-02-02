package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.examples.nurserostering.domain.pattern.WorkBeforeFreeSequencePattern;

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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class WorkBeforeNewController implements Initializable {
	@FXML
	private TextField beforeId;

	@FXML
	private TextField  beforeCode;

	@FXML
	private TextField  beforeWeight;
	
	@FXML
	private TextField  freedaylength;

	@FXML
	private TextField  beforeFreeDay;

	@FXML
	private ComboBox<ShiftType> beforeShiftType;

	@FXML
	private TextField  beforeDayOfWeek;

	private Stage dialogStage;
	private WorkBeforeFreeSequencePattern workbeforedata;
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<WorkBeforeFreeSequencePattern> workbeforeList = FXCollections.observableArrayList();

	public ObservableList<WorkBeforeFreeSequencePattern> getWorkBeforeFreeSequencePatternList() {
		if (!workbeforeList.isEmpty())
			workbeforeList.clear();
		workbeforeList = FXCollections.observableList(
				(List<WorkBeforeFreeSequencePattern>) rosterService.listWorkBeforeFreeSequencePattern());
		return workbeforeList;
	}
	
	private ObservableList<ShiftType> shiftList = FXCollections.observableArrayList();

	public ObservableList<ShiftType> getShiftTypeList() {
		if (!shiftList.isEmpty())
			shiftList.clear();
		shiftList = FXCollections.observableList((List<ShiftType>) rosterService.listShiftType());
		return shiftList;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the employee to be edited in the dialog.
	 * 
	 * @param employee
	 */

	public void setWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern workbeforedata) {
		this.workbeforedata = workbeforedata;
		beforeCode.setText(workbeforedata.getCode());
		beforeWeight.setText(Integer.toString(workbeforedata.getWeight()));
		freedaylength.setText(Integer.toString(workbeforedata.getFreeDayLength()));
		getShiftTypeList();
		beforeShiftType.setItems(shiftList);
		
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

			String bweight = beforeWeight.getText();
			int weight = Integer.parseInt(bweight);
			String freelength = freedaylength.getText();
			int daylength = Integer.parseInt(freelength);
			ShiftType shiftType = beforeShiftType.getSelectionModel().getSelectedItem();
			String beforecode = beforeCode.getText();
			workbeforedata.setCode(beforecode);
			workbeforedata.setFreeDayLength(daylength);
			workbeforedata.setWeight(weight);
			workbeforedata.setWorkShiftType(shiftType);
			okClicked = true;
			rosterService.addWorkBeforeFreeSequencePattern(workbeforedata);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Add Succesfull!");
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
		if (beforeCode.getText() == null || beforeCode.getText().length() == 0) {
			errorMessage += "No valid Code!\n";
		}
		if (beforeWeight.getText() == null || beforeWeight.getText().length() == 0) {
			errorMessage += "No valid Weight!\n";
		}
		if (beforeFreeDay.getText() == null || beforeFreeDay.getText().length() == 0) {
			errorMessage += "No valid Free Day Length!\n";
		}
		if (beforeShiftType.getSelectionModel().getSelectedItem() == null ) {
			errorMessage += "No valid Shift Type\n";
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
