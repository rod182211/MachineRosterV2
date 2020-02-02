package org.optaplanner.examples.view;

import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.pool.HolidaysData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class HolidayNewController implements Initializable {
	
	@FXML
	private TextField holidayId;

	@FXML
	private ComboBox <Employee> namefield;


	@FXML
	private DatePicker startdate;
	@FXML
	private DatePicker enddate;
	@FXML
	private TextField dayweight;
	
   
    
  
	private Stage dialogStage;

	private HolidaysData holidaydata;
	
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<HolidaysData> HolidaysDataList = FXCollections.observableArrayList();

	public ObservableList<HolidaysData> getHolidaysDataList() {
		  
		if (!HolidaysDataList.isEmpty())
			HolidaysDataList.clear();
		HolidaysDataList = FXCollections.observableList((List<HolidaysData>) rosterService.listHolidaysData());
		return HolidaysDataList;
	}


	private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

	public ObservableList<Employee> getEmployeenamelist() {
		if (!employeeList.isEmpty())
			employeeList.clear();
		employeeList = FXCollections.observableList((List<Employee>) rosterService.listEmployee());
		return employeeList;
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
	
	public void setHoliday(HolidaysData holidaydata) {
		
		this.holidaydata = holidaydata;
		getEmployeenamelist();
		namefield.setItems(getEmployeenamelist());
		namefield.setValue(holidaydata.getEmployee());
		
		
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
		if (isDateInputValid()) {
			LocalDate date = startdate.getValue();
			LocalDate findate = enddate.getValue();
			Employee employee = namefield.getSelectionModel().getSelectedItem();
			holidaydata.setEmployee(employee);
			String weightpas = dayweight.getText();
			int weightinint = Integer.parseInt(weightpas);
			holidaydata.setWeight(weightinint);
			holidaydata.setStartdate(date);
			holidaydata.setEnddate(findate);
			okClicked = true;
			rosterService.addHolidaysData(holidaydata);
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

	

	private boolean isDateInputValid() {
		String errorMessage = "";

		if (((ChronoLocalDate) startdate.getValue()).isAfter((ChronoLocalDate) enddate.getValue())) {
			errorMessage += "Invalid Dates!\n";
		}
		if ( namefield.getSelectionModel().getSelectedItem() == null) {
			errorMessage += "Invalid Employee!\n";
		}
		if (dayweight.getText()== null || dayweight.getText().length() == 0) {
			errorMessage += "No valid Weight!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Dates");
			alert.setHeaderText("Ensure the Last Date is correct");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}


