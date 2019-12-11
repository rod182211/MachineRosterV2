package org.optaplanner.examples.view;

import java.net.URL;
import java.time.LocalDate;

import java.util.List;

import java.util.ResourceBundle;


import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;

import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.optaplanner.examples.pool.ShiftOffDate;

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

public class ShiftOffEditController implements Initializable {

	@FXML
	private TextField shiftoffId;

	@FXML
	private ComboBox<Employee> namefield;

	@FXML
	private DatePicker requesteddayfield;
	@FXML
	private TextField shiftoffweight;
	@FXML
	private ComboBox<ShiftType> shiftrequested;

	private Stage dialogStage;

	private ShiftOffDate shiftoffdata;
	

	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	
	
	private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

	public ObservableList<Employee> getEmployeenamelist() {
		if (!employeeList.isEmpty())
			employeeList.clear();
		employeeList = FXCollections.observableList((List<Employee>) rosterService.listEmployee());
		return employeeList;
	}

	private ObservableList<ShiftType> shiftList = FXCollections.observableArrayList();

	public ObservableList<ShiftType> getShiftTypeList() {
		if (!shiftList.isEmpty())
			shiftList.clear();
		shiftList = FXCollections.observableList((List<ShiftType>) rosterService.listShiftType());
		return shiftList;
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

	
	public void setShiftOff(ShiftOffDate shiftoffdata) {
		this.shiftoffdata = shiftoffdata;
		getEmployeenamelist();
		getShiftTypeList();
		namefield.setItems(employeeList);
		shiftrequested.setItems(shiftList);
		requesteddayfield.setValue(shiftoffdata.getDate());

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

			/*String shiftoffIdtemp = shiftoffId.getText();
			long shiftoffIdnew = Long.parseLong(shiftoffIdtemp);
            shiftoffdata.setId(shiftoffIdnew);		*/	
			String weightval = shiftoffweight.getText();
			int weightnew = Integer.parseInt(weightval);
			shiftoffdata.setWeight(weightnew);
			LocalDate shiftoffdate = requesteddayfield.getValue();
			shiftoffdata.setDate(shiftoffdate);
			Employee employee = namefield.getSelectionModel().getSelectedItem();
			shiftoffdata.setEmployee(employee);
			ShiftType shift = shiftrequested.getSelectionModel().getSelectedItem();
			shiftoffdata.setShiftType(shift);		
			okClicked = true;
			rosterService.updateShiftOffDate(shiftoffdata);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Request added Succesfully!");
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
		if (shiftoffweight.getText() == null || shiftoffweight.getText().length() == 0) {
			errorMessage += "No valid Id Field!\n";
		}
		if (shiftoffweight.getText() == null || shiftoffweight.getText().length() == 0) {
			errorMessage += "No valid weight!\n";
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
