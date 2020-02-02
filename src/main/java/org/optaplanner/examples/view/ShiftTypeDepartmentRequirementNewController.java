package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.optaplanner.database.HibernateUtil;
import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Department;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.optaplanner.examples.nurserostering.domain.ShiftTypeDepartmentRequirement;
import org.optaplanner.examples.nurserostering.domain.Skill;
import org.optaplanner.examples.nurserostering.domain.SkillProficiency;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ShiftTypeDepartmentRequirementNewController implements Initializable {


	@FXML
	private ComboBox<ShiftType> shiftType;
	@FXML
	private ComboBox<Department> department;
	
	private Stage dialogStage;

	private SkillProficiency skillprof;

	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	
	private ObservableList<ShiftType> shiftListId = FXCollections.observableArrayList();

	public ObservableList<ShiftType> getShiftListId() {
		if (!shiftListId.isEmpty())
			shiftListId.clear();
		shiftListId = FXCollections.observableList((List<ShiftType>) rosterService.listShiftType());
		return shiftListId;
	}
	private ObservableList<Department> departmentList = FXCollections.observableArrayList();
	private ShiftTypeDepartmentRequirement departments;

	public ObservableList<Department> getDepartmentList() {
		if (!departmentList.isEmpty())
			departmentList.clear();
		departmentList = FXCollections.observableList((List<Department>) rosterService.listDepartment());
		return departmentList;
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
	
	public void setShiftTypeDepartmentRequirements(ShiftTypeDepartmentRequirement departments) {
		this.departments = departments;
		 getShiftListId();
		 getDepartmentList();
		 department.setItems(departmentList);
		 department.setValue(departments.getDepartment());
		 shiftType.setItems(shiftListId);
		 shiftType.setValue(departments.getShiftType());
		
	
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
		departments.setShiftType(type);
		Department deptype = department.getSelectionModel().getSelectedItem();
		departments.setDepartment(deptype);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Update Succesful!");
		alert.showAndWait();
		dialogStage.close();
		okClicked = true;
		rosterService.addShiftTypeDepartmentRequirement(departments);

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
		  if (department.getSelectionModel().getSelectedItem() == null) {
			  errorMessage += "No valid Department!\n"; }
		 
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
