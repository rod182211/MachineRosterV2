package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;

import org.optaplanner.examples.nurserostering.domain.Department;
import org.optaplanner.examples.nurserostering.domain.Skill;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DepartmentController implements Initializable {
	@FXML
	private AnchorPane DepartmentsTab;

	@FXML
	private TableView<Department> DepartmentsTable;

	
	@FXML
	private TableColumn<Department, String> DepartmentsCol;

	
	@FXML
	private Label Departmentfield;



	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<Department> departmentsList = FXCollections.observableArrayList();

	public ObservableList<Department> getDepartmentsList() {
		if (!departmentsList.isEmpty())
			departmentsList.clear();
		departmentsList = FXCollections.observableList((List<Department>) rosterService.listDepartment());
		return departmentsList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadDepartment();
	}

	public void loadDepartment() {
		DepartmentsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		DepartmentsTable.getItems().clear();
		DepartmentsTable.setItems(getDepartmentsList());
		DepartmentsCol.setCellValueFactory(new PropertyValueFactory<Department, String>("code"));
		showDepartmentsDetails(null);
		DepartmentsTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showDepartmentsDetails(newValue));

	}

	private void showDepartmentsDetails(Department departments) {
		if (departments != null) {
			// Fill the labels with info from the Department object.

			Departmentfield.setText(departments.getCode());
		

		} else {
			// Department is null, remove all the text.
			
			Departmentfield.setText("");

		}
	}

	@FXML
	private void handleDeleteDepartments() {
		int selectItem = DepartmentsTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<Department> itemsSelected;
			 itemsSelected = DepartmentsTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeDepartment(itemsSelected);
				loadDepartment();
			} else

			{
				loadDepartment();
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Skill Selected");
			alert.setContentText("Please select a Skill.");

			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleEditDepartments() {
		Department selectedSkills = DepartmentsTable.getSelectionModel().getSelectedItem();

		if (selectedSkills != null) {
			boolean okClicked = showDepartmentsEditDialog(selectedSkills);
			if (okClicked) {
				showDepartmentsDetails(selectedSkills);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Skill Selected");
			alert.setContentText("Please select a skill in the table.");

			alert.showAndWait();
		}
		loadDepartment();
	}

	@FXML
	private void handleNewDepartments() {
		Department tempDepartments = new Department();
		boolean okClicked = showDepartmentsNewEditDialog(tempDepartments);

		if (okClicked) {

			loadDepartment();

		}
	}

	


	public boolean showDepartmentsEditDialog(Department departments) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/DepartmentEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Departments");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			DepartmentsEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDepartments(departments);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showDepartmentsNewEditDialog(Department departments) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DepartmentNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Department");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			DepartmentsNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDepartments(departments);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
