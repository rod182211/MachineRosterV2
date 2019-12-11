package org.optaplanner.examples.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;

import org.optaplanner.examples.pool.DayOnDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class DayOnEditController implements Initializable {

	@FXML
	private TextField dayonId;

	@FXML
	private ComboBox <Employee> namefield;

	@FXML
	private DatePicker dayondate;
	@FXML
	private TextField dayweight;
	
    protected Map<LocalDate, ShiftDate> shiftDateMap;
    
  
	private Stage dialogStage;

	private DayOnDate dayondata;
	
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<DayOnDate> DayOnDateList = FXCollections.observableArrayList();

	public ObservableList<DayOnDate> getDayOnDateList() {
		  
		if (!DayOnDateList.isEmpty())
			DayOnDateList.clear();
		DayOnDateList = FXCollections.observableList((List<DayOnDate>) rosterService.listDayOnDate());
		return DayOnDateList;
	}

	
	private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

	public ObservableList<Employee> getEmployeenamelist() {
		if (!employeeList.isEmpty())
			employeeList.clear();
		employeeList = FXCollections.observableList((List<Employee>) rosterService.listEmployee());
		return employeeList;
	}
	private ObservableList<ShiftDate> shiftDateList = FXCollections.observableArrayList();

	public ObservableList<ShiftDate> getshiftDatelist() {
		if (!shiftDateList.isEmpty())
			shiftDateList.clear();
		shiftDateList = FXCollections.observableList((List<ShiftDate>) rosterService.listShiftDate());
		return shiftDateList;
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
	
	public void setDayOn(DayOnDate dayondata) {
		
		this.dayondata = dayondata;
		getshiftDatelist();
		getEmployeenamelist();
		namefield.setItems(employeeList);
		namefield.setValue(dayondata.getEmployee());
		dayweight.setText(Integer.toString(dayondata.getWeight()));
		dayondate.setValue(dayondata.getDate());
	//	requesteddayfield.setItems(shiftDateList);
	//	requesteddayfield.setValue(date1);
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
			LocalDate date = dayondate.getValue();
			String weightpas = dayweight.getText();
			Employee employee = namefield.getSelectionModel().getSelectedItem();
			dayondata.setEmployee(employee);
			int weightinint = Integer.parseInt(weightpas);
			dayondata.setWeight(weightinint);
			dayondata.setDate(date);
			okClicked = true;
			rosterService.updateDayOnDate(dayondata);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Update Succesfull");
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

		if (dayweight.getText() == null || dayweight.getText().length() == 0) {
			errorMessage += "No valid Request!\n";
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


