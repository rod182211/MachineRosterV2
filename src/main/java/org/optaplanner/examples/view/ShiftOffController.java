package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.pool.ShiftOffDate;

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

public class ShiftOffController implements Initializable {
	
	@FXML
	private TableView<ShiftOffDate> shiftoffTable;

	@FXML
	private TableColumn<ShiftOffDate, String> requestedshift;
	@FXML
	private TableColumn<ShiftOffDate, String> requestedday;
	@FXML
	private TableColumn<ShiftOffDate, String> name;
	
	@FXML
	private Label shiftoffId;
	
	@FXML
	private Label shiftweight;
	

	@FXML
	private Label namefield;

	@FXML
	private Label requestedshiftfield;
	
	@FXML
	
	private Label requestedshiftdatefield;
	
	

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<ShiftOffDate> ShiftOffDateList = FXCollections.observableArrayList();

	public ObservableList<ShiftOffDate> getShiftOffDateList() {
		if (!ShiftOffDateList.isEmpty())
			ShiftOffDateList.clear();
		ShiftOffDateList = FXCollections.observableList((List<ShiftOffDate>) rosterService.listShiftOffDate());
		return ShiftOffDateList;
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
		loadShiftOff();
		
	}
	public void loadShiftOff() {
		shiftoffTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		shiftoffTable.getItems().clear();
		shiftoffTable.setItems(getShiftOffDateList());
		
		requestedshift.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getShiftType().getCode()));
		requestedday.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
		name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployee().getName()));
		
		showShiftOffDetails(null);
		shiftoffTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftOffDetails(newValue));

	}

	private void showShiftOffDetails(ShiftOffDate shiftoffdata) {
		if (shiftoffdata != null) {
			namefield.setText(shiftoffdata.getEmployee().getName());
			shiftoffId.setText(Long.toString(shiftoffdata.getId()));
			requestedshiftfield.setText(shiftoffdata.getShiftType().getCode());
			requestedshiftdatefield.setText(shiftoffdata.getDate().toString());
			shiftweight.setText(Integer.toString(shiftoffdata.getWeight()));

		} else {
			

			namefield.setText("");
			shiftoffId.setText("");
			requestedshiftfield.setText("");
			shiftweight.setText("");
			requestedshiftdatefield.setText("");
		

		}
	}

	@FXML
	private void handleDeleteShiftOff() {
		int selectItem = shiftoffTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<ShiftOffDate> itemsSelected;
			 itemsSelected = shiftoffTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeShiftOffDate(itemsSelected);
				loadShiftOff();
			} else

			{
				loadShiftOff();
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
	private void handleNewShiftOffDate() {
		ShiftOffDate temprequest = new ShiftOffDate();
		boolean okClicked = showShiftOffNewEditDialog(temprequest);

		if (okClicked) {

			showShiftOffDetails(temprequest);

		}
		loadShiftOff();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditShiftOffDate() {
		ShiftOffDate selectedrequest = shiftoffTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showShiftOffEditDialog(selectedrequest);
			if (okClicked) {
				showShiftOffDetails(selectedrequest);
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
		loadShiftOff();
	}

	public boolean showShiftOffEditDialog(ShiftOffDate shiftoffdata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/ShiftOffEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Shift Off Request");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftOffEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftOff(shiftoffdata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showShiftOffNewEditDialog(ShiftOffDate shiftoffdata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShiftOffNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Request");
			
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftOffNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftOff(shiftoffdata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
