package org.optaplanner.examples.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Department;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.Skill;

import org.optaplanner.examples.nurserostering.domain.contract.Contract;




/**
 * Dialog to edit details of a person.
 * 
 *
 */
public class EmployeeNewEditDialogController implements Initializable {

	
	@FXML
	private TextField employeeIdField;
	@FXML
	private TextField employeename;
	

	@FXML
	private ComboBox<Contract> contract;
	@FXML
	private ComboBox<Skill> skill;
	@FXML
	private ComboBox<Department> department;
	
	@FXML
	private TextField streetnum;
	@FXML
	private TextField address;
	@FXML
	private TextField suburb;
	@FXML
	private TextField postcode;
	@FXML
	private TextField contactdetails;


	private Stage dialogStage;
	private Employee employee;
	
	
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	

	
	private ObservableList<Contract> contractList = FXCollections.observableArrayList();

	public ObservableList<Contract> getContractList() {
		if (!contractList.isEmpty())
			contractList.clear();
		contractList = FXCollections.observableList((List<Contract>) rosterService.listContract());
		return contractList;
	}
	
	
	private ObservableList<Skill> skillsList = FXCollections.observableArrayList();

	public ObservableList<Skill> getSkillsList() {
		if (!skillsList.isEmpty())
			skillsList.clear();
		skillsList = FXCollections.observableList((List<Skill>) rosterService.listSkill());
		return skillsList;
	}
	private ObservableList<Department> departmentList = FXCollections.observableArrayList();

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
	@Override
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
	
	public void setEmployee(Employee employee ) {
		this.employee = employee;
		getContractList();	
		getSkillsList();
		getDepartmentList();
		contract.setItems(contractList);
		skill.setItems(skillsList);
		department.setItems(departmentList);
	 
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
		
		int x = 1;
		do {
			try {
			String employeeId = employeeIdField.getText();
	    	String stnum = streetnum.getText();
	    	employee.setStreetnum(stnum);
			String addr = address.getText();
			employee.setAddress(addr);
			String sub = suburb.getText();
			employee.setSuburb(sub);
			String pcode = postcode.getText();
			employee.setPostcode(pcode);
			String contdetail = contactdetails.getText();
			employee.setContactdetails(contdetail);
			employee.setCode(employeeId);
			String name = employeename.getText();
			employee.setEmployeeId(employeeId);
			employee.setName(name);
			Department departmentcode = department.getSelectionModel().getSelectedItem();
			Skill skillcode = skill.getSelectionModel().getSelectedItem();
			Contract contractcode = contract.getSelectionModel().getSelectedItem();
			employee.setSkill(skillcode);
			employee.setDepartment(departmentcode);
			employee.setContract(contractcode);
			okClicked = true;
			rosterService.addEmployee(employee);
			x=2;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Update Succesfull!");
			alert.showAndWait();
			dialogStage.close();
		}
		
		catch(Exception e) {
			Alert alertpattern = new Alert(AlertType.CONFIRMATION);
			alertpattern.setTitle("Missed Field");
			alertpattern.setHeaderText("You missed an Input Try Again");
			alertpattern.setContentText("missing field");
			
		}
		}
		while(x==1);
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

		if (employeename.getText() == null || employeename.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (skill.getSelectionModel().getSelectedItem()  == null)  {
			errorMessage += "No valid Skill!\n";
		}
		if (department.getSelectionModel().getSelectedItem()  == null)  {
			errorMessage += "No valid Department!\n";
		}
		if (contract.getSelectionModel().getSelectedItem()  == null)  {
			errorMessage += "No valid contract!\n";
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