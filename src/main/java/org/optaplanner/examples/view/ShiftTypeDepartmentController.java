package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.ShiftTypeDepartmentRequirement;
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

public class ShiftTypeDepartmentController implements Initializable {
	@FXML
	private AnchorPane employeedepTab;

	@FXML
	private TableView<ShiftTypeDepartmentRequirement> ShiftTypeDepartmentRequirementTable;
	@FXML
	private TableColumn<ShiftTypeDepartmentRequirement, String> Department;

	@FXML
	private TableColumn<ShiftTypeDepartmentRequirement, String> Shifttype;
	@FXML
	private Label shiftType;
	@FXML
	private Label department;
	



	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<ShiftTypeDepartmentRequirement> skillprofList = FXCollections.observableArrayList();

	public ObservableList<ShiftTypeDepartmentRequirement> getShiftTypeDepartmentRequirementsList() {
		if (!skillprofList.isEmpty())
			skillprofList.clear();
		skillprofList = FXCollections.observableList((List<ShiftTypeDepartmentRequirement>) rosterService.listShiftTypeDepartmentRequirement());
		return skillprofList;
	}

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadShiftTypeDepartmentRequirement();
	}

	public void loadShiftTypeDepartmentRequirement() {
		ShiftTypeDepartmentRequirementTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ShiftTypeDepartmentRequirementTable.getItems().clear();
		ShiftTypeDepartmentRequirementTable.setItems(getShiftTypeDepartmentRequirementsList());
		
		Department.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDepartment().getCode()));
		Shifttype.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftType().getCode()));
		showShiftTypeDepartmentRequirementsDetails(null);
		ShiftTypeDepartmentRequirementTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftTypeDepartmentRequirementsDetails(newValue));

	}

	private void showShiftTypeDepartmentRequirementsDetails(ShiftTypeDepartmentRequirement departments) {
		if (departments != null) {
			
			shiftType.setText(departments.getShiftType().getCode());
			department.setText(departments.getDepartment().getCode());
		} else {
			// ShiftTypeDepartmentRequirement is null, remove all the text.
			
		
		}
	}

	@FXML
	private void handleDeleteShiftTypeDepartmentRequirements() {
		int selectItem = ShiftTypeDepartmentRequirementTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<ShiftTypeDepartmentRequirement> itemsSelected;
			 itemsSelected = ShiftTypeDepartmentRequirementTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeShiftTypeDepartmentRequirement(itemsSelected);
				loadShiftTypeDepartmentRequirement();
			} else

			{
				loadShiftTypeDepartmentRequirement();
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No ShiftTypeDepartmentRequirement Selected");
			alert.setContentText("Please select a ShiftTypeDepartmentRequirement.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleNewShiftTypeDepartmentRequirements() {
		ShiftTypeDepartmentRequirement tempdepartment = new ShiftTypeDepartmentRequirement();
		boolean okClicked = showShiftTypeDepartmentRequirementsNewEditDialog(tempdepartment);

		if (okClicked) {
//    recall the screen
			loadShiftTypeDepartmentRequirement();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditShiftTypeDepartmentRequirements() {
		ShiftTypeDepartmentRequirement selectedShiftTypeDepartmentRequirements = ShiftTypeDepartmentRequirementTable.getSelectionModel().getSelectedItem();

		if (selectedShiftTypeDepartmentRequirements != null) {
			boolean okClicked = showShiftTypeDepartmentRequirementsEditDialog(selectedShiftTypeDepartmentRequirements);
			if (okClicked) {
				showShiftTypeDepartmentRequirementsDetails(selectedShiftTypeDepartmentRequirements);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No ShiftTypeDepartmentRequirement Selected");
			alert.setContentText("Please select a skill in the table.");

			alert.showAndWait();
		}
		loadShiftTypeDepartmentRequirement();
	}

	public boolean showShiftTypeDepartmentRequirementsEditDialog(ShiftTypeDepartmentRequirement departments) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/ShiftTypeDepartmentEdit.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Shift Type");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftTypeDepartmentRequirementEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftTypeDepartmentRequirements(departments);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showShiftTypeDepartmentRequirementsNewEditDialog(ShiftTypeDepartmentRequirement departments) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShiftTypeDepartmentNew.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New ShiftTypeDepartmentRequirement");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftTypeDepartmentRequirementNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftTypeDepartmentRequirements(departments);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
