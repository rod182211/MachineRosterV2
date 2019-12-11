package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.pool.TrainingData;

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

public class TrainingController implements Initializable {
	
	@FXML
	private TableView<TrainingData> trainingTable;
	@FXML
	private TableColumn<TrainingData, String> requestedday;
	@FXML
	private TableColumn<TrainingData, String> name;
	@FXML
	private Label namefield;
	@FXML
	private Label requestedshiftdatefield;
	@FXML
	private Label trainingshift;
	


	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<TrainingData> TrainingDataList = FXCollections.observableArrayList();

	public ObservableList<TrainingData> getTrainingDataOffOffList() {
		if (!TrainingDataList.isEmpty())
			TrainingDataList.clear();
		TrainingDataList = FXCollections.observableList((List<TrainingData>) rosterService.listTrainingData());
		return TrainingDataList;
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
		loadTrainingData();
		
	}
	public void loadTrainingData() {
		trainingTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		trainingTable.getItems().clear();
		trainingTable.setItems(getTrainingDataOffOffList());
		requestedday.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
		name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployee().getName()));
		showTrainingDataDetails(null);
		trainingTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showTrainingDataDetails(newValue));

	}

	private void showTrainingDataDetails(TrainingData trainingdata) {
		if (trainingdata != null) {
			namefield.setText(trainingdata.getEmployee().getName());
			requestedshiftdatefield.setText(trainingdata.getDate().toString());
			trainingshift.setText(trainingdata.getShiftType());

		} else {
			

			namefield.setText("");
			requestedshiftdatefield.setText("");
			trainingshift.setText("");
		}
	}

	@FXML
	private void handleDeleteTrainingData() {
		int selectItem = trainingTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<TrainingData> itemsSelected;
			 itemsSelected = trainingTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeTrainingData(itemsSelected);
				loadTrainingData();
			} else

			{
				loadTrainingData();
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
	private void handleNewTrainingData() {
		TrainingData temprequest = new TrainingData();
		boolean okClicked = showTrainingDataNewEditDialog(temprequest);

		if (okClicked) {

			showTrainingDataDetails(temprequest);

		}
		loadTrainingData();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditTrainingData() {
		TrainingData selectedrequest = trainingTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showTrainingDataEditDialog(selectedrequest);
			if (okClicked) {
				showTrainingDataDetails(selectedrequest);
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
		loadTrainingData();
	}

	public boolean showTrainingDataEditDialog(TrainingData trainingdata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/TrainingEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit ADO");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			TrainingDataEditDialog controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setTrainingData(trainingdata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showTrainingDataNewEditDialog(TrainingData trainingdata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TrainingNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New ADO");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage)
			 */;
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			TrainingDataNewDialog controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setTrainingData(trainingdata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
