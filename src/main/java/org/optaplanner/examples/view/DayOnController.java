package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;

import org.optaplanner.examples.pool.DayOnDate;

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

public class DayOnController implements Initializable {
	@FXML
	private TableView<DayOnDate> dayonTable;

	@FXML
	private TableColumn<DayOnDate, String> dayon;
	@FXML
	private TableColumn<DayOnDate, String> name;


	@FXML
	private Label dayweight;

	@FXML
	private Label namefield;

	@FXML
	private Label requesteddayfield;



	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<DayOnDate> DayOnDateList = FXCollections
			.observableArrayList();

	public ObservableList<DayOnDate> getDayOnDateList() {
		if (!DayOnDateList.isEmpty())
			DayOnDateList.clear();
		DayOnDateList = FXCollections.observableList(
				(List<DayOnDate>) rosterService.listDayOnDate());
		return DayOnDateList;
	}

	private ObservableList<Employee> employeeList = FXCollections
			.observableArrayList();

	public ObservableList<Employee> getEmployeenamelist() {
		if (!employeeList.isEmpty())
			employeeList.clear();
		employeeList = FXCollections.observableList(
				(List<Employee>) rosterService.listEmployeename());
		return employeeList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadDayon();

	}
	public void loadDayon() {
		dayonTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		dayonTable.getItems().clear();
		dayonTable.setItems(getDayOnDateList());
		dayon.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getDate().toString()));
		name.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getEmployee().getName()));
		showDayOnDetails(null);
		dayonTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showDayOnDetails(newValue));

	}

	private void showDayOnDetails(DayOnDate dayondata) {
		if (dayondata != null) {
			namefield.setText(dayondata.getEmployee().getName());
			requesteddayfield.setText(dayondata.getDate().toString());
			dayweight.setText(Integer.toString(dayondata.getWeight()));

		} else {

			namefield.setText("");
			requesteddayfield.setText("");
			dayweight.setText("");

		}
	}

	@FXML
	private void handleDeleteDayOn() {
	int	selectItem = dayonTable.getSelectionModel().getSelectedIndex();
			if (selectItem >= 0) {
				ObservableList<DayOnDate> itemsSelected;
				 itemsSelected = dayonTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {

				rosterService.removeDayOnDate(itemsSelected);
				loadDayon();
			} else

			{
				loadDayon();
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
	private void handleNewDayOnDate() {
		DayOnDate temprequest = new DayOnDate();
		boolean okClicked = showDayOnNewEditDialog(temprequest);

		if (okClicked) {
			showDayOnDetails(temprequest);
			loadDayon();

		}
		loadDayon();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditDayOnDate() {
		DayOnDate selectedrequest = dayonTable.getSelectionModel()
				.getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showDayOnEditDialog(selectedrequest);
			if (okClicked) {
				showDayOnDetails(selectedrequest);

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
		loadDayon();
		showDayOnDetails(selectedrequest);
	}

	public boolean showDayOnEditDialog(DayOnDate dayondata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/DayOnEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit DayOn Request");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			DayOnEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDayOn(dayondata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showDayOnNewEditDialog(DayOnDate dayondata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/fxml/DayOnNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Request");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			DayOnNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setDayOn(dayondata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
