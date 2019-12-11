package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;

import org.optaplanner.examples.pool.DayOffDate;

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

public class DayOffController implements Initializable {

	@FXML
	private TableView<DayOffDate> dayoffTable;

	@FXML
	private TableColumn<DayOffDate, String> dayoff;
	@FXML
	private TableColumn<DayOffDate, String> name;

	@FXML
	private Label dayweight;

	@FXML
	private Label namefield;

	@FXML
	private Label requesteddayfield;

	

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<DayOffDate> DayOffDateList = FXCollections
			.observableArrayList();

	public ObservableList<DayOffDate> getDayOffDateList() {
		if (!DayOffDateList.isEmpty())
			DayOffDateList.clear();
		DayOffDateList = FXCollections.observableList(
				(List<DayOffDate>) rosterService.listDayOffDate());
		return DayOffDateList;
	}

	private ObservableList<Employee> employeeList = FXCollections
			.observableArrayList();

	public ObservableList<Employee> getEmployeenamelist() {
		if (!employeeList.isEmpty())
			employeeList.clear();
		employeeList = FXCollections
				.observableList((List<Employee>) rosterService.listEmployee());
		return employeeList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadDayoff();

	}
	public void loadDayoff() {
		dayoffTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		dayoffTable.getItems().clear();
		dayoffTable.setItems(getDayOffDateList());
		dayoff.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getDate().toString()));
		name.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getEmployee().getName()));
		showDayOffDetails(null);
		dayoffTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue,
						newValue) -> showDayOffDetails(newValue));

	}

	private void showDayOffDetails(DayOffDate dayoffdata) {
		if (dayoffdata != null) {
			namefield.setText(dayoffdata.getEmployee().getName());
			requesteddayfield.setText(dayoffdata.getDate().toString());
			dayweight.setText(Integer.toString(dayoffdata.getWeight()));

		} else {

			namefield.setText("");
			requesteddayfield.setText("");
			dayweight.setText("");

		}
	}

	@FXML
	private void handleDeleteDayOff() {
		int selectedItem = dayoffTable.getSelectionModel().getSelectedIndex();
		if (selectedItem >= 0) {
			ObservableList<DayOffDate> itemsSelected;
			 itemsSelected = dayoffTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeDayOffDate(itemsSelected);
				loadDayoff();
			} else

			{
				loadDayoff();
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
	private void handleNewDayOffDate() {
		DayOffDate temprequest = new DayOffDate();
		boolean okClicked = showDayOffNewEditDialog(temprequest);

		if (okClicked) {
			showDayOffDetails(temprequest);
			loadDayoff();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditDayOffDate() {
		DayOffDate selectedrequest = dayoffTable.getSelectionModel()
				.getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showDayOffEditDialog(selectedrequest);
			if (okClicked) {
				showDayOffDetails(selectedrequest);

			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Shift Selected");
			alert.setContentText("Please select a date in the table.");

			alert.showAndWait();
		}
		loadDayoff();
		showDayOffDetails(selectedrequest);
	}

	public boolean showDayOffEditDialog(DayOffDate dayoffdata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/DayOffEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit DayOff Request");
			
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			DayOffEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDayOff(dayoffdata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showDayOffNewEditDialog(DayOffDate dayoffdata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/fxml/DayOffNewDialog.fxml"));
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
			DayOffNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDayOff(dayoffdata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
