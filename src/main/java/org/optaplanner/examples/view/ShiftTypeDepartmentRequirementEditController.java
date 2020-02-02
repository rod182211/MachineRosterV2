package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;

import org.optaplanner.examples.nurserostering.domain.Department;

import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.optaplanner.examples.nurserostering.domain.ShiftTypeDepartmentRequirement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ShiftTypeDepartmentRequirementEditController implements Initializable {
	
	

	@FXML
	private ComboBox<ShiftType> shiftType;
	@FXML
	private ComboBox<Department> department;
	
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
		rosterService.updateShiftTypeDepartmentRequirement(departments);

	}
	
	

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}


}
