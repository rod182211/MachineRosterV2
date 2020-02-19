package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;

import org.optaplanner.examples.nurserostering.domain.Machine;
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

public class MachineController implements Initializable {
	@FXML
	private AnchorPane machinesTab;

	@FXML
	private TableView<Machine> machineTable;

	
	@FXML
	private TableColumn<Machine, String> machinesCol;

	
	@FXML
	private Label machinefield;



	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<Machine> departmentsList = FXCollections.observableArrayList();

	public ObservableList<Machine> getMachinesList() {
		if (!departmentsList.isEmpty())
			departmentsList.clear();
		departmentsList = FXCollections.observableList((List<Machine>) rosterService.listMachine());
		return departmentsList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadMachine();
	}

	public void loadMachine() {
		machineTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		machineTable.getItems().clear();
		machineTable.setItems(getMachinesList());
		machinesCol.setCellValueFactory(new PropertyValueFactory<Machine, String>("code"));
		showMachinesDetails(null);
		machineTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showMachinesDetails(newValue));

	}

	private void showMachinesDetails(Machine departments) {
		if (departments != null) {
			// Fill the labels with info from the Machine object.

			machinefield.setText(departments.getCode());
		

		} else {
			// Machine is null, remove all the text.
			
			machinefield.setText("");

		}
	}

	@FXML
	private void handleDeleteMachine() {
		int selectItem = machineTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<Machine> itemsSelected;
			 itemsSelected = machineTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeMachine(itemsSelected);
				loadMachine();
			} else

			{
				loadMachine();
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
	private void handleEditMachine() {
		Machine selectedSkills = machineTable.getSelectionModel().getSelectedItem();

		if (selectedSkills != null) {
			boolean okClicked = showMachinesEditDialog(selectedSkills);
			if (okClicked) {
				showMachinesDetails(selectedSkills);
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
		loadMachine();
	}

	@FXML
	private void handleNewMachine() {
		Machine tempMachines = new Machine();
		boolean okClicked = showMachinesNewEditDialog(tempMachines);

		if (okClicked) {

			loadMachine();

		}
	}

	


	public boolean showMachinesEditDialog(Machine machine) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/MachineEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Machines");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MachineEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMachines(machine);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showMachinesNewEditDialog(Machine machine) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MachineNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Machine");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MachineNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMachines(machine);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
