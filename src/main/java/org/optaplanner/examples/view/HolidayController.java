package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;

import org.optaplanner.examples.pool.HolidaysData;

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

public class HolidayController implements Initializable {
	
	@FXML
	private TableView<HolidaysData> holidayTable;

	@FXML
	private TableColumn<HolidaysData, String> startdate;
	@FXML
	private TableColumn<HolidaysData, String> enddate;
	@FXML
	private TableColumn<HolidaysData, String> name;
	
	@FXML
	private Label holidayId;
	
	@FXML
	private Label dayweight;
	

	@FXML
	private Label namefield;

	@FXML
	private Label firstdayfield;
	
	@FXML
	private Label lastdayfield;
	
	


	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<HolidaysData> HolidaysDataList = FXCollections.observableArrayList();

	public ObservableList<HolidaysData> getHolidaysDataList() {
		if (!HolidaysDataList.isEmpty())
			HolidaysDataList.clear();
		HolidaysDataList = FXCollections.observableList((List<HolidaysData>) rosterService.listHolidaysData());
		return HolidaysDataList;
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
		loadHoliday();
		
	}
	public void loadHoliday() {
		holidayTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		holidayTable.getItems().clear();
		holidayTable.setItems(getHolidaysDataList());
		startdate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartdate().toString()));
		enddate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEnddate().toString()));
		name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployee().getName()));
		showHolidayDetails(null);
		holidayTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showHolidayDetails(newValue));

	}

	private void showHolidayDetails(HolidaysData holidaydata) {
		if (holidaydata != null) {
			namefield.setText(holidaydata.getEmployee().getName());
			holidayId.setText(Long.toString(holidaydata.getId()));
			firstdayfield.setText(holidaydata.getStartdate().toString());
			lastdayfield.setText(holidaydata.getEnddate().toString());
			dayweight.setText(Integer.toString(holidaydata.getWeight()));

		} else {
			

			namefield.setText("");
			holidayId.setText("");
			firstdayfield.setText("");
			lastdayfield.setText("");
			dayweight.setText("");
		

		}
	}

	@FXML
	private void handleDeleteHoliday() {
		int selectItem = holidayTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<HolidaysData> itemsSelected;
			 itemsSelected = holidayTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeHolidaysData(itemsSelected);
				loadHoliday();
			} else

			{
				loadHoliday();
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
	private void handleNewHolidaysData() {
		HolidaysData temprequest = new HolidaysData();
		boolean okClicked = showHolidayNewEditDialog(temprequest);

		if (okClicked) {
			showHolidayDetails(temprequest);
			loadHoliday();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditHolidaysData() {
		HolidaysData selectedrequest = holidayTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showHolidayEditDialog(selectedrequest);
			if (okClicked) {
				showHolidayDetails(selectedrequest);
				
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
		loadHoliday();
		showHolidayDetails(selectedrequest);
	}

	public boolean showHolidayEditDialog(HolidaysData holidaydata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/HolidayEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Leave Request");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			HolidayEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setHoliday(holidaydata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showHolidayNewEditDialog(HolidaysData holidaydata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HolidayNewDialog.fxml"));
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
			HolidayNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setHoliday(holidaydata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
