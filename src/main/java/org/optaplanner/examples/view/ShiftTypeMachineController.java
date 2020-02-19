package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.ShiftTypeMachineRequirement;
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

public class ShiftTypeMachineController implements Initializable {
	@FXML
	private AnchorPane employeedepTab;

	@FXML
	private TableView<ShiftTypeMachineRequirement> ShiftTypeMachineRequirementTable;
	@FXML
	private TableColumn<ShiftTypeMachineRequirement, String> machine;

	@FXML
	private TableColumn<ShiftTypeMachineRequirement, String> Shifttype;
	@FXML
	private Label shiftType;
	@FXML
	private Label machines;
	



	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<ShiftTypeMachineRequirement> skillprofList = FXCollections.observableArrayList();

	public ObservableList<ShiftTypeMachineRequirement> getShiftTypeMachineRequirementsList() {
		if (!skillprofList.isEmpty())
			skillprofList.clear();
		skillprofList = FXCollections.observableList((List<ShiftTypeMachineRequirement>) rosterService.listShiftTypeMachineRequirement());
		return skillprofList;
	}

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadShiftTypeMachineRequirement();
	}

	public void loadShiftTypeMachineRequirement() {
		ShiftTypeMachineRequirementTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ShiftTypeMachineRequirementTable.getItems().clear();
		ShiftTypeMachineRequirementTable.setItems(getShiftTypeMachineRequirementsList());
		
		machine.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMachine().getCode()));
		Shifttype.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftType().getCode()));
		showShiftTypeMachineRequirementsDetails(null);
		ShiftTypeMachineRequirementTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftTypeMachineRequirementsDetails(newValue));

	}

	private void showShiftTypeMachineRequirementsDetails(ShiftTypeMachineRequirement machine) {
		if (machine != null) {
			
			shiftType.setText(machine.getShiftType().getCode());
			machines.setText(machine.getMachine().getCode());
		} else {
			// ShiftTypeMachineRequirement is null, remove all the text.
			
		
		}
	}

	@FXML
	private void handleDeleteShiftTypeMachineRequirements() {
		int selectItem = ShiftTypeMachineRequirementTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<ShiftTypeMachineRequirement> itemsSelected;
			 itemsSelected = ShiftTypeMachineRequirementTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeShiftTypeMachineRequirement(itemsSelected);
				loadShiftTypeMachineRequirement();
			} else

			{
				loadShiftTypeMachineRequirement();
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No ShiftTypeMachineRequirement Selected");
			alert.setContentText("Please select a ShiftTypeMachineRequirement.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleNewShiftTypeMachineRequirements() {
		ShiftTypeMachineRequirement tempmachine = new ShiftTypeMachineRequirement();
		boolean okClicked = showShiftTypeMachineRequirementsNewEditDialog(tempmachine);

		if (okClicked) {
//    recall the screen
			loadShiftTypeMachineRequirement();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditShiftTypeMachineRequirements() {
		ShiftTypeMachineRequirement selectedShiftTypeMachineRequirements = ShiftTypeMachineRequirementTable.getSelectionModel().getSelectedItem();

		if (selectedShiftTypeMachineRequirements != null) {
			boolean okClicked = showShiftTypeMachineRequirementsEditDialog(selectedShiftTypeMachineRequirements);
			if (okClicked) {
				showShiftTypeMachineRequirementsDetails(selectedShiftTypeMachineRequirements);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No ShiftTypeMachineRequirement Selected");
			alert.setContentText("Please select a skill in the table.");

			alert.showAndWait();
		}
		loadShiftTypeMachineRequirement();
	}

	public boolean showShiftTypeMachineRequirementsEditDialog(ShiftTypeMachineRequirement machines) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/ShiftTypeMachineEdit.fxml"));
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
			ShiftTypeMachineRequirementEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftTypeMachineRequirements(machines);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showShiftTypeMachineRequirementsNewEditDialog(ShiftTypeMachineRequirement machines) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShiftTypeMachineNew.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New ShiftTypeMachineRequirement");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftTypeMachineRequirementNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftTypeMachineRequirements(machines);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
