package org.optaplanner.examples.view;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.ComboBox;



import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.IndexedCheckModel;
import org.hibernate.Session;
import org.optaplanner.database.HibernateUtil;
import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;

import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.EmployeeMachine;
import org.optaplanner.examples.nurserostering.domain.Machine;
import org.optaplanner.examples.nurserostering.domain.Skill;
import org.optaplanner.examples.nurserostering.domain.SkillProficiency;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;







/**
 * Dialog to edit details of a person.
 * 
 *
 */
public class EmployeeEditDialogController implements Initializable {

	@FXML
	private TextField employeeIdField;
	@FXML
	private TextField employeename;
	

	@FXML
	private ComboBox<Contract> contract;
	@FXML
	private CheckComboBox<Skill> skill;
	@FXML
	private CheckComboBox<Machine> machine;

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
	private static Session session;

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
	private ObservableList<Machine> machineList = FXCollections.observableArrayList();

	public ObservableList<Machine> getMachineList() {
		if (!machineList.isEmpty())
			machineList.clear();
		machineList = FXCollections.observableList((List<Machine>) rosterService.listMachine());
		return machineList;
	}
	private ObservableList<SkillProficiency> skillprofList = FXCollections.observableArrayList();

	public ObservableList<SkillProficiency> getSkillprofList() {
		if (!skillprofList.isEmpty())
			skillprofList.clear();
		skillprofList = FXCollections.observableList((List<SkillProficiency>) rosterService.listSkillProficiency());
		return skillprofList;
	}
	private ObservableList<SkillProficiency> skillprofempList = FXCollections.observableArrayList();

	public ObservableList<SkillProficiency> getSkillemployeeList() {
		if (!skillprofempList.isEmpty())
			skillprofempList.clear();
		skillprofempList = FXCollections.observableList((List<SkillProficiency>) rosterService.listSkillProficiencyempId());
		return skillprofempList;
	}
	private ObservableList<EmployeeMachine> employeeMachineList = FXCollections.observableArrayList();

	public ObservableList<EmployeeMachine> getEmployeeMachineList() {
		if (!employeeMachineList.isEmpty())
			employeeMachineList.clear();
		employeeMachineList = FXCollections.observableList((List<EmployeeMachine>) rosterService.listEmployeeMachine());
		return employeeMachineList;
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
		employeeIdField.setText(employee.getEmployeeId());
		employeename.setText(employee.getName());
		getContractList();	
		getSkillsList();
		getMachineList();
		getSkillprofList();
	 	skill.getItems().addAll(skillsList);
		skill.getCheckModel().getCheckedItems();
	 	contract.setItems(contractList);
	 	machine.getItems().addAll(machineList);
		streetnum.setText(employee.getStreetnum());
		address.setText(employee.getAddress());
		suburb.setText(employee.getSuburb());		
		postcode.setText(employee.getPostcode());
	  	contactdetails.setText(employee.getContactdetails());
		contract.setValue(employee.getContract());
	
	
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
			getSkillprofList();
			getEmployeeMachineList();
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
			Contract contractcode = contract.getSelectionModel().getSelectedItem();
			employee.setContract(contractcode);
			okClicked = true;
			rosterService.updateEmployee(employee);
			String empname = employee.getName();
			ObservableList<Skill> skillcode = skill.getCheckModel().getCheckedItems();
			ObservableList<Machine> machineCode = machine.getCheckModel().getCheckedItems();
			for (SkillProficiency element : skillprofList) {
				String checkedemployee = element.getEmployee().getName();
				long checkedvalue = element.getId();

				if (checkedemployee.contentEquals(empname)) {

					session = HibernateUtil.getSessionFactory().getCurrentSession();
					session.beginTransaction();
					SkillProficiency p = (SkillProficiency) session.get(SkillProficiency.class, checkedvalue);
					session.close();
					rosterService.removeSkillProficiency(p);

				}
			}
			SkillProficiency prof = new SkillProficiency();
			prof.setEmployee(employee);
			for (Skill obj : skillcode) {
				prof.setSkill(obj);
				rosterService.mergeSkillProficiency(prof);

			}
			
		

			for (EmployeeMachine element1 : employeeMachineList) {
				String checkedemployee1 = element1.getEmployee().getName();
				long checkedvalue1 = element1.getId();

				if (checkedemployee1.contentEquals(empname)) {

					session = HibernateUtil.getSessionFactory().getCurrentSession();
					session.beginTransaction();
					EmployeeMachine p = (EmployeeMachine) session.get(EmployeeMachine.class, checkedvalue1);
					session.close();
					rosterService.removeEmployeeMachine(p);

				}
			}
			EmployeeMachine empmachine = new EmployeeMachine();
			 empmachine .setEmployee(employee);
			for (Machine mach : machineCode) {
				empmachine.setMachine(mach);
				rosterService.mergeEmployeeMachine(empmachine);

			}
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

		if (employeename.getText() == null || employeename.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		
	/*	if (department.getSelectionModel().getSelectedItem()  == null)  {
			errorMessage += "No valid Department!\n";
		}*/
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