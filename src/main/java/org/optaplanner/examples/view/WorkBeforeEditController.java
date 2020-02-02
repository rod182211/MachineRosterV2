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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class WorkBeforeEditController implements Initializable {
	

	@FXML
	private Label eapplicatonname;
	
	@FXML
	private TextField ebeforeCode;

	@FXML
	private TextField ebeforeWeight;

	@FXML
	private TextField ebeforeFreeDay;

	@FXML
	private ComboBox<ShiftType> ebeforeShiftType;

	@FXML
	private ComboBox<String> ebeforeDayOfWeek;

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

	
	private ObservableList<ShiftType> shiftcodeList = FXCollections.observableArrayList();
	public ObservableList<ShiftType> getshiftcodeList() {
		if (!shiftcodeList.isEmpty())
			shiftcodeList.clear();
		shiftcodeList = FXCollections.observableList((List<ShiftType>) rosterService.listShiftType());
		return shiftcodeList;
	}
	private ObservableList<String> dayList =  FXCollections.observableArrayList("null","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY");

	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	//@SuppressWarnings("unchecked")
	public void setWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern workbeforedata) {
		
		this.workbeforedata = workbeforedata;
		getshiftcodeList();
		ebeforeCode.setText(workbeforedata.getCode());
		ebeforeWeight.setText(Integer.toString(workbeforedata.getWeight()));
		ebeforeFreeDay.setText(Integer.toString(workbeforedata.getFreeDayLength()));
		ebeforeShiftType.setItems(shiftcodeList);
		ebeforeShiftType.setValue(workbeforedata.getWorkShiftType());
		ebeforeDayOfWeek.setItems(dayList);
		
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

		    String bweight = ebeforeWeight.getText();
		    int weight1 = Integer.parseInt(bweight);
		    String freelength = ebeforeFreeDay.getText();
		    int freedays = Integer.parseInt(freelength);
		    workbeforedata.setFreeDayLength(freedays);
		    workbeforedata.setWeight(weight1);
			String beforecode = ebeforeCode.getText();
		    workbeforedata.setCode(beforecode);
			ShiftType beforeshift = ebeforeShiftType.getSelectionModel().getSelectedItem();
			workbeforedata.setWorkShiftType(beforeshift);
		//	String dow = ebeforeDayOfWeek.getSelectionModel().getSelectedItem();
			//DayOfWeek newdow = DayOfWeek.valueOf(dow);
			//workbeforedata.setWorkDayOfWeek(newdow);
    		okClicked = true;
			rosterService.updateWorkBeforeFreeSequencePattern(workbeforedata);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Update Succesfull!");
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
		if (ebeforeCode.getText() == null || ebeforeCode.getText().length() == 0) {
			errorMessage += "No valid Code!\n";
		}
		if (ebeforeWeight.getText() == null || ebeforeWeight.getText().length() == 0) {
			errorMessage += "No valid Weight!\n";
		}
		if (ebeforeFreeDay.getText() == null || ebeforeFreeDay.getText().length() == 0) {
			errorMessage += "No valid Free Day Length!\n";
		}
		if (ebeforeShiftType.getSelectionModel().getSelectedItem() == null ) {
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
