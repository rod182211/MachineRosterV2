package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.pool.LeaveData;

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

public class LeaveController implements Initializable {
	
	@FXML
	private TableView<LeaveData> leaveTable;
	@FXML
	private TableColumn<LeaveData, String> startdate;
	@FXML
	private TableColumn<LeaveData, String> enddate;
	@FXML
	private TableColumn<LeaveData, String> name;
	@FXML
	private Label namefield;
	@FXML
	private Label requestedstartdatefield;
	@FXML
	private Label requestedenddatefield;
	


	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<LeaveData> LeaveDataList = FXCollections.observableArrayList();

	public ObservableList<LeaveData> getLeaveDataOffOffList() {
		if (!LeaveDataList.isEmpty())
			LeaveDataList.clear();
		LeaveDataList = FXCollections.observableList((List<LeaveData>) rosterService.listLeaveData());
		return LeaveDataList;
	}

	
	private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

	public ObservableList<Employee> getEmployeenamelist() {
		if (!employeeList.isEmpty())
			employeeList.clear();
		employeeList = FXCollections.observableList((List<Employee>) rosterService.listEmployee());
		return employeeList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadLeaveData();
		
	}
	public void loadLeaveData() {
		leaveTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		leaveTable.getItems().clear();
		leaveTable.setItems(getLeaveDataOffOffList());
		startdate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartdate().toString()));
		enddate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEnddate().toString()));
		name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployee().getName()));
		showLeaveDataDetails(null);
		leaveTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showLeaveDataDetails(newValue));

	}

	private void showLeaveDataDetails(LeaveData leavedata) {
		if (leavedata != null) {
			namefield.setText(leavedata.getEmployee().getName());
			requestedstartdatefield.setText(leavedata.getStartdate().toString());
			requestedenddatefield.setText(leavedata.getEnddate().toString());
			

		} else {
			

			namefield.setText("");
			requestedstartdatefield.setText("");
			requestedenddatefield.setText("");
		
		}
	}

	@FXML
	private void handleDeleteLeaveData() {
		int selectItem = leaveTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<LeaveData> itemsSelected;
			 itemsSelected = leaveTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeLeaveData(itemsSelected);
				loadLeaveData();
			} else

			{
				loadLeaveData();
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
	private void handleNewLeaveData() {
		LeaveData temprequest = new LeaveData();
		boolean okClicked = showLeaveDataNewEditDialog(temprequest);

		if (okClicked) {

			showLeaveDataDetails(temprequest);

		}
		loadLeaveData();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditLeaveData() {
		LeaveData selectedrequest = leaveTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showLeaveDataEditDialog(selectedrequest);
			if (okClicked) {
				showLeaveDataDetails(selectedrequest);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Shift Selected");
			alert.setContentText("Please select a Shift in the table.");

			alert.showAndWait();
		}
		loadLeaveData();
	}

	public boolean showLeaveDataEditDialog(LeaveData leavedata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/LeaveEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Leave");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			LeaveDataEditDialog controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setLeaveData(leavedata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showLeaveDataNewEditDialog(LeaveData leavedata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LeaveNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Leave");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage)
			 */;
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			// Set the person into the controller.
			LeaveDataNewDialog controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setLeaveData(leavedata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
