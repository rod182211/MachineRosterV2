package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;

import org.optaplanner.examples.pool.ShiftOnDate;

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

public class ShiftOnController implements Initializable {
	
	@FXML
	private TableView<ShiftOnDate> shiftonTable;
	
	@FXML
	private TableColumn<ShiftOnDate, String> requestedshift;
	@FXML
	private TableColumn<ShiftOnDate, String> requestedday;
	@FXML
	private TableColumn<ShiftOnDate, String> name;
	
	@FXML
	private Label shiftonId;
	
	@FXML
	private Label shiftweight;
	

	@FXML
	private Label namefield;

	@FXML
	private Label requestedshiftfield;
	
	@FXML
	
	private Label requestedshiftdatefield;
	
	

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<ShiftOnDate> ShiftOnDateList = FXCollections.observableArrayList();

	public ObservableList<ShiftOnDate> getShiftOnDateList() {
		if (!ShiftOnDateList.isEmpty())
			ShiftOnDateList.clear();
		ShiftOnDateList = FXCollections.observableList((List<ShiftOnDate>) rosterService.listShiftOnDate());
		return ShiftOnDateList;
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
		loadShiftOn();
		
	}
	public void loadShiftOn() {
		shiftonTable.getItems().clear();
		shiftonTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		shiftonTable.setItems(getShiftOnDateList());
		
		requestedshift.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftType().getCode()));
		requestedday.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
		name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployee().getName()));
		
		
		
		showShiftOnDetails(null);
		shiftonTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftOnDetails(newValue));

	}

	private void showShiftOnDetails(ShiftOnDate shiftondata) {
		if (shiftondata != null) {
			// Fill the labels with info from the skill object.

			namefield.setText(shiftondata.getEmployee().getName());
			shiftonId.setText(Long.toString(shiftondata.getId()));
			requestedshiftfield.setText(shiftondata.getShiftType().getCode());
			requestedshiftdatefield.setText(shiftondata.getDate().toString());
			shiftweight.setText(Integer.toString(shiftondata.getWeight()));

		} else {
			

			namefield.setText("");
			shiftonId.setText("");
			requestedshiftfield.setText("");
			shiftweight.setText("");
			requestedshiftdatefield.setText("");
		

		}
	}

	@FXML
	private void handleDeleteShiftOn() {
		int selectItem = shiftonTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			
			 ObservableList<ShiftOnDate> itemsSelected;
			 itemsSelected = shiftonTable.getSelectionModel().getSelectedItems();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeShiftOnDate(itemsSelected);
				loadShiftOn();
			} else

			{
				loadShiftOn();
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
	private void handleNewShiftOnDate() {
		ShiftOnDate temprequest = new ShiftOnDate();
		boolean okClicked = showShiftOnNewEditDialog(temprequest);

		if (okClicked) {

			showShiftOnDetails(temprequest);

		}
		loadShiftOn();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditShiftOnDate() {
		ShiftOnDate selectedrequest = shiftonTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showShiftOnEditDialog(selectedrequest);
			if (okClicked) {
				showShiftOnDetails(selectedrequest);
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
		loadShiftOn();
	}

	public boolean showShiftOnEditDialog(ShiftOnDate shiftondata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/ShiftOnEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Shift On Request");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftOnEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftOn(shiftondata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showShiftOnNewEditDialog(ShiftOnDate shiftondata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShiftOnNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Request");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage)
			 */;
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftOnNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftOn(shiftondata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
