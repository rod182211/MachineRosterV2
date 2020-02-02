package org.optaplanner.examples.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.pool.TrainingData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TrainingDataNewDialog implements Initializable {

	

	@FXML
	private ComboBox<Employee> namefield;

	
	@FXML
	private ComboBox<String> trainingshift;
	@FXML
	private DatePicker shiftdaterequested;
	

	private Stage dialogStage;

	private TrainingData trainingdata;

	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	
	
	private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

	public ObservableList<Employee> getEmployeenamelist() {
		if (!employeeList.isEmpty())
			employeeList.clear();
		employeeList = FXCollections.observableList((List<Employee>) rosterService.listEmployee());
		return employeeList;
	}
	private ObservableList<String> shiftList =  FXCollections.observableArrayList("Training", "WLC");
	
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

	public void setTrainingData(TrainingData trainingdata) {
		this.trainingdata = trainingdata;
		getEmployeenamelist();
		namefield.setItems(employeeList);
		namefield.setValue(trainingdata.getEmployee());
		shiftdaterequested.setValue(trainingdata.getDate());
		trainingshift.setItems(shiftList);
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
		
			LocalDate shiftdate = shiftdaterequested.getValue();
			trainingdata.setDate(shiftdate);
			Employee employee = namefield.getSelectionModel().getSelectedItem();
			trainingdata.setEmployee(employee);
			String shiftType = trainingshift.getSelectionModel().getSelectedItem();
			trainingdata.setShiftType(shiftType);
			okClicked = true;
			rosterService.addTrainingData(trainingdata);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Training added Succesfully!");
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
	private boolean isInputValid() {
		String errorMessage = "";
		
		if (shiftdaterequested.getValue() == null ) {
			errorMessage += "No valid Date!\n";
		}
		if (namefield.getSelectionModel().getSelectedItem() == null ) {
			errorMessage += "No valid Employee!\n";
		}
		if (trainingshift.getSelectionModel().getSelectedItem() == null ) {
			errorMessage += "No valid Shift Type!\n";
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

