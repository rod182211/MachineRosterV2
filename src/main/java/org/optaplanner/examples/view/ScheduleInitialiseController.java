package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.pool.RosterParametrizationData;


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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class ScheduleInitialiseController implements Initializable {
	

	@FXML
	private TableView<RosterParametrizationData> rosterParametrizationDataTable;

	@FXML
	private TableColumn<RosterParametrizationData, String> scheduleName;

	@FXML
	private TableColumn<RosterParametrizationData, String> startdate;
	@FXML
	private TableColumn<RosterParametrizationData, String> enddate;

	


	@FXML
	private Label schedname;
	
	@FXML
	private Label start;

	@FXML
	private Label end;
	

	

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<RosterParametrizationData> scheddatesList = FXCollections.observableArrayList();

	public ObservableList<RosterParametrizationData> getRosterParametrizationDataList() {
		if (!scheddatesList.isEmpty())
			scheddatesList.clear();
		scheddatesList = FXCollections.observableList((List<RosterParametrizationData>) rosterService.listRosterParametrizationData());
		return scheddatesList;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadRosterParametrizationData();
	}
	public void loadRosterParametrizationData() {
		rosterParametrizationDataTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		rosterParametrizationDataTable.getItems().clear();
		rosterParametrizationDataTable.setItems(getRosterParametrizationDataList());
		scheduleName.setCellValueFactory(new PropertyValueFactory<RosterParametrizationData, String>("code"));
		startdate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate().toString()));
		enddate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartDate().plusDays(13).toString()));
		showRosterParametrizationDataDetails(null);
		rosterParametrizationDataTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showRosterParametrizationDataDetails(newValue));

	}

	private void showRosterParametrizationDataDetails(RosterParametrizationData scheddate) {
		if (scheddate != null) {
			

			schedname.setText(scheddate.getCode());
			start.setText(scheddate.getStartDate().toString());
			end.setText(scheddate.getEndDate().toString());
			
		} else {
			// RosterParametrizationData is null, remove all the text.

			schedname.setText("");
			start.setText("");
			end.setText("");
			
		}
	}

	@FXML
	private void handleDeleteRosterParametrizationData() {
		int selectItem = rosterParametrizationDataTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<RosterParametrizationData> itemsSelected;
			 itemsSelected = rosterParametrizationDataTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeRosterParametrizationData(itemsSelected);
				loadRosterParametrizationData();
			} else

			{
				loadRosterParametrizationData();
			}
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No RosterParametrizationData Selected");
			alert.setContentText("Please select a RosterParametrizationData.");

			alert.showAndWait();
		}
	}
	@FXML
	private void handleNewRosterParametrizationData() {
		RosterParametrizationData tempcontract = new RosterParametrizationData();
		boolean okClicked = showRosterParametrizationDataNewEditDialog(tempcontract);

		if (okClicked) {
//    recall the screen
			loadRosterParametrizationData();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditRosterParametrizationData() {
		RosterParametrizationData selectedRosterParametrizationData = rosterParametrizationDataTable.getSelectionModel().getSelectedItem();

		if (selectedRosterParametrizationData != null) {
			boolean okClicked = showRosterParametrizationDataEditDialog(selectedRosterParametrizationData);
			if (okClicked) {
				showRosterParametrizationDataDetails(selectedRosterParametrizationData);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No RosterParametrizationData Selected");
			alert.setContentText("Please select a RosterParametrizationData in the table.");

			alert.showAndWait();
		}
		loadRosterParametrizationData();
	}

	public boolean showRosterParametrizationDataEditDialog(RosterParametrizationData scheddate) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/RosterParametrizationDataEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit RosterParametrizationData");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ScheduleInitialiseEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setRosterParametrizationData(scheddate);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showRosterParametrizationDataNewEditDialog(RosterParametrizationData scheddate) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RosterParametrizationDataNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New RosterParametrizationData");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			RosterParametrizationDataNewEditDialog controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setRosterParametrizationData(scheddate);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}

