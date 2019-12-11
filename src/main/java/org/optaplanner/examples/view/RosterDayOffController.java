package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.pool.RosterDayOff;
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
import org.optaplanner.examples.view.RosterDayOffEditDialog;

public class RosterDayOffController implements Initializable {
	
	@FXML
	private TableView<RosterDayOff> rosterdayTable;
	@FXML
	private TableColumn<RosterDayOff, String> requestedday;
	@FXML
	private TableColumn<RosterDayOff, String> name;
	@FXML
	private Label namefield;
	@FXML
	private Label requestedshiftdatefield;
	


	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<RosterDayOff> RosterDayOffList = FXCollections.observableArrayList();

	public ObservableList<RosterDayOff> getRosterDayOffOffOffList() {
		if (!RosterDayOffList.isEmpty())
			RosterDayOffList.clear();
		RosterDayOffList = FXCollections.observableList((List<RosterDayOff>) rosterService.listRosterDayOff());
		return RosterDayOffList;
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
		loadRosterDayOff();
		
	}
	public void loadRosterDayOff() {
		rosterdayTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		rosterdayTable.getItems().clear();
		rosterdayTable.setItems(getRosterDayOffOffOffList());
		requestedday.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
		name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmployee().getName()));
		showRosterDayOffDetails(null);
		rosterdayTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showRosterDayOffDetails(newValue));

	}

	private void showRosterDayOffDetails(RosterDayOff rdodata) {
		if (rdodata != null) {
			namefield.setText(rdodata.getEmployee().getName());
			requestedshiftdatefield.setText(rdodata.getDate().toString());
			

		} else {
			

			namefield.setText("");
			requestedshiftdatefield.setText("");
		
		}
	}

	@FXML
	private void handleDeleteRosterDayOff() {
		int selectItem = rosterdayTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<RosterDayOff> itemsSelected;
			 itemsSelected = rosterdayTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeRosterDayOff(itemsSelected);
				loadRosterDayOff();
			} else

			{
				loadRosterDayOff();
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
	private void handleNewRosterDayOff() {
		RosterDayOff temprequest = new RosterDayOff();
		boolean okClicked = showRosterDayOffNewEditDialog(temprequest);

		if (okClicked) {

			showRosterDayOffDetails(temprequest);

		}
		loadRosterDayOff();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditRosterDayOff() {
		RosterDayOff selectedrequest = rosterdayTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showRosterDayOffEditDialog(selectedrequest);
			if (okClicked) {
				showRosterDayOffDetails(selectedrequest);
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
		loadRosterDayOff();
	}

	public boolean showRosterDayOffEditDialog(RosterDayOff rdodata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/RosterDayOffEditDialog.fxml"));
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
			RosterDayOffEditDialog controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setRosterDayOff(rdodata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showRosterDayOffNewEditDialog(RosterDayOff rdodata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RosterDayNewDialog.fxml"));
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
			RosterDayOffNewDialog controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setRosterDayOff(rdodata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
