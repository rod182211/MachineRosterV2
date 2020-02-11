package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.optaplanner.database.HibernateUtil;
import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.SkillProficiency;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EmployeeController implements Initializable {

	@FXML
	private TableView<Employee> employeeTable;

	@FXML
	private TableColumn<Employee, String> column1;

	@FXML
	private TableColumn<Employee, String> column2;

	@FXML
	private Label name;

	@FXML
	private Label contractfield;
	@FXML
	private Label skillfield;
	@FXML
	private Label streetnum;
	@FXML
	private Label department;
	@FXML
	private Label address;
	@FXML
	private Label suburb;
	@FXML
	private Label postcode;
	@FXML
	private Label contactdetails;

	@FXML
	private Label employeeId;
	private static Session session;
	private RosterService rosterService = new RosterServiceImpl();

	private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

	public ObservableList<Employee> getEmployeeList() {
		if (!employeeList.isEmpty())
			employeeList.clear();
		employeeList = FXCollections.observableList((List<Employee>) rosterService.listEmployee());
		return employeeList;
	}

//-----------------------------------------------------------------------------------------------------------------------
	// Contract Inputs
	private ObservableList<Contract> contractList = FXCollections.observableArrayList();

	public ObservableList<Contract> getContractList() {
		if (!contractList.isEmpty())
			contractList.clear();
		contractList = FXCollections.observableList((List<Contract>) rosterService.listContract());
		return contractList;
	}

	// -----------------------------------------------------------------------------------------------------------------------
	private ObservableList<SkillProficiency> skillprofList = FXCollections.observableArrayList();

	public ObservableList<SkillProficiency> getSkillprofList() {
		if (!skillprofList.isEmpty())
			skillprofList.clear();
		skillprofList = FXCollections.observableList((List<SkillProficiency>) rosterService.listSkillProficiency());
		return skillprofList;
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadEmployee();

	}

	public void loadEmployee() {
		// initialize the employee table
		employeeTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		employeeTable.getItems().clear();
		employeeTable.setItems(getEmployeeList());

		column1.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeId"));
		column2.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));

		showEmployeeDetails(null);

		employeeTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showEmployeeDetails(newValue));
	}

	private void showEmployeeDetails(Employee employee) {
		if (employee != null) {

			
			employeeId.setText(employee.getEmployeeId());
			name.setText(employee.getName());
			contractfield.setText(employee.getContract().getCode());
			streetnum.setText(employee.getStreetnum());
			address.setText(employee.getAddress());
			suburb.setText(employee.getSuburb());
		    department.setText(employee.getDepartment().getCode());
			postcode.setText(employee.getPostcode());
			contactdetails.setText(employee.getContactdetails());
			
			  for (SkillProficiency element: skillprofList) { if
			  (element.getEmployee().getName().equals(employee.getName())) {
			  skillfield.setText(element.getSkill().getCode()); }
			 
		}

		} else { // Employee is null, remove all the text. name.setText("");

			employeeId.setText("");
			name.setText("");
			contractfield.setText("");
			streetnum.setText("");
			skillfield.setText("");
			address.setText("");
			suburb.setText("");
			postcode.setText("");
            skillfield.setText("");
            department.setText("");
			contactdetails.setText("");
		}
		
	}
	
	
	@FXML
	private void handleDeleteEmployee() {
		int selectedIndex = employeeTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Employee itemsSelected = employeeTable.getSelectionModel().getSelectedItem();
			String empname = itemsSelected.getName();
			getSkillprofList();
			Alert alertpattern = new Alert(AlertType.CONFIRMATION);
			alertpattern.setTitle("Request Confirmation");
			alertpattern.setHeaderText("YOU MUST DELETE the Employee's Skill Proficency First");
			alertpattern.setContentText("Click OK or Cancel ");
			Optional<ButtonType> resultpattern = alertpattern.showAndWait();

			if (resultpattern.get() == ButtonType.OK) {
				for (SkillProficiency element : skillprofList) {
					String checkedemployee = element.getEmployee().getName();
					long checkedvalue = element.getId();

					if (checkedemployee.contentEquals(empname) ) {
						System.out.println(empname);
						session = HibernateUtil.getSessionFactory().getCurrentSession();
						session.beginTransaction();
						SkillProficiency p = (SkillProficiency) session.get(SkillProficiency.class, checkedvalue);
						session.close();
						rosterService.removeSkillProficiency(p);

					}
				}
				
				rosterService.removeEmployee(itemsSelected);
				loadEmployee();
		}

			

			else {
				loadStage("/fxml/Employee.fxml");
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No item Selected");
			alert.setContentText("Please select a row.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleNewEmployee() {
		Employee temprequest = new Employee();
		boolean okClicked = showEmployeeNewEditDialog(temprequest);

		if (okClicked) {

			showEmployeeDetails(temprequest);

		}
		loadEmployee();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditEmployee() {
		Employee selectedrequest = employeeTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showEmployeeEditDialog(selectedrequest);
			if (okClicked) {
				showEmployeeDetails(selectedrequest);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Shift Selected");
			alert.setContentText("Please select an Employee in the table.");

			alert.showAndWait();
		}
		loadEmployee();
	}

	public boolean showEmployeeEditDialog(Employee employee) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/EmployeeEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Employee");

			 dialogStage.initModality(Modality.WINDOW_MODAL);
			 //dialogStage.initOwner(primaryStage);

			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			EmployeeEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setEmployee(employee);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showEmployeeNewEditDialog(Employee employee) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EmployeeNewEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Employee");
			
			  dialogStage.initModality(Modality.WINDOW_MODAL);
			 //* dialogStage.initOwner(primaryStage)
			 
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			EmployeeNewEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setEmployee(employee);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void loadStage(String fxml) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}