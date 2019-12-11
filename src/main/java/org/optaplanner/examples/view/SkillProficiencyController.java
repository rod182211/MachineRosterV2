package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.SkillProficiency;

import javafx.beans.property.SimpleStringProperty;
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

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SkillProficiencyController implements Initializable {
	@FXML
	private AnchorPane skillprofTab;

	@FXML
	private TableView<SkillProficiency> skillprofTable;
	@FXML
	private TableColumn<SkillProficiency, String> skillprofCol;

	@FXML
	private TableColumn<SkillProficiency, String> employeename;
	@FXML
	private Label nameemployee;

	@FXML
	private Label skillfield;

	

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<SkillProficiency> skillprofList = FXCollections.observableArrayList();

	public ObservableList<SkillProficiency> getSkillProficiencysList() {
		if (!skillprofList.isEmpty())
			skillprofList.clear();
		skillprofList = FXCollections.observableList((List<SkillProficiency>) rosterService.listSkillProficiency());
		return skillprofList;
	}

	
		private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

		public ObservableList<Employee> getEmployeeList() {
			if (!employeeList.isEmpty())
				employeeList.clear();
			employeeList = FXCollections.observableList((List<Employee>) rosterService.listEmployee());
			return employeeList;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadSkillProficiency();
	}

	public void loadSkillProficiency() {
		skillprofTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		skillprofTable.getItems().clear();
		skillprofTable.setItems(getSkillProficiencysList());
		
		skillprofCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSkill().getCode()));
		employeename.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployee().getName()));
		showSkillProficiencysDetails(null);
		skillprofTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showSkillProficiencysDetails(newValue));

	}

	private void showSkillProficiencysDetails(SkillProficiency skillprof) {
		if (skillprof != null) {
			skillfield.setText(skillprof.getSkill().getCode());
			nameemployee.setText(skillprof.getEmployee().getName());

		} else {
			// SkillProficiency is null, remove all the text.
		
			skillfield.setText("");
			nameemployee.setText("");

		}
	}

	@FXML
	private void handleDeleteSkillProficiencys() {
		int selectItem = skillprofTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<SkillProficiency> itemsSelected;
			 itemsSelected = skillprofTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeSkillProficiency(itemsSelected);
				loadSkillProficiency();
			} else

			{
				loadSkillProficiency();
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No SkillProficiency Selected");
			alert.setContentText("Please select a SkillProficiency.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleNewSkillProficiencys() {
		SkillProficiency tempskillprof = new SkillProficiency();
		boolean okClicked = showSkillProficiencysNewEditDialog(tempskillprof);

		if (okClicked) {
//    recall the screen
			loadSkillProficiency();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditSkillProficiencys() {
		SkillProficiency selectedSkillProficiencys = skillprofTable.getSelectionModel().getSelectedItem();

		if (selectedSkillProficiencys != null) {
			boolean okClicked = showSkillProficiencysEditDialog(selectedSkillProficiencys);
			if (okClicked) {
				showSkillProficiencysDetails(selectedSkillProficiencys);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No SkillProficiency Selected");
			alert.setContentText("Please select a skill in the table.");

			alert.showAndWait();
		}
		loadSkillProficiency();
	}

	public boolean showSkillProficiencysEditDialog(SkillProficiency skillprof) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/SkillProficiencysEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit SkillProficiencys");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			SkillProficiencyEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSkillProficiencys(skillprof);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showSkillProficiencysNewEditDialog(SkillProficiency skillprof) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SkillProficiencysNewEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New SkillProficiency");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			SkillProficiencyNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSkillProficiencys(skillprof);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
