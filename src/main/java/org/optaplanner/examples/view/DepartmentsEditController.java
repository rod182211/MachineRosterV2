package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Department;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DepartmentsEditController implements Initializable {

	
	@FXML
	private TextField department;;

	private Stage dialogStage;

	
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	

	private ObservableList<Department> departmentsList = FXCollections.observableArrayList();

	private Department departments;

	public ObservableList<Department> getDepartmentsList() {
		if (!departmentsList.isEmpty())
			departmentsList.clear();
		departmentsList = FXCollections.observableList((List<Department>) rosterService.listDepartment());
		return departmentsList;
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
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

	public void setDepartments(Department departments) {
		this.departments = departments;
		department.setText(departments.getCode());
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
			String depart = department.getText();
			departments.setCode(depart);
			okClicked = true;
			rosterService.updateDepartment(departments);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Update Succesful!");
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

		if (department.getText() == null || department.getText().length() == 0) {
			errorMessage += "No valid Department Code!\n";
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
