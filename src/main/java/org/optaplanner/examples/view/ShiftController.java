package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

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

public class ShiftController implements Initializable {



	@FXML
	private TableView<ShiftType> shiftTable;

	@FXML
	private TableColumn<ShiftType, String> startTime;
	@FXML
	private TableColumn<ShiftType, String> finishTime;
	@FXML
	private TableColumn<ShiftType, String> shifttype;
	@FXML
	private TableColumn<ShiftType, String> shiftdescription;

	@FXML
	private TableColumn<ShiftType, Boolean> isnight;

	
	@FXML
	private Label shiftfield;

	@FXML
	private Label start;
	@FXML
	private Label finish;

	@FXML
	private Label descriptionfield;

	@FXML
	private Label isNight;



	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<ShiftType> shiftList = FXCollections.observableArrayList();

	public ObservableList<ShiftType> getSkillsList() {
		if (!shiftList.isEmpty())
			shiftList.clear();
		shiftList = FXCollections.observableList((List<ShiftType>) rosterService.listShiftType());
		return shiftList;
	}

	private ObservableList<ShiftType> shiftListId = FXCollections.observableArrayList();

	public ObservableList<ShiftType> getShiftListId() {
		if (!shiftListId.isEmpty())
			shiftListId.clear();
		shiftListId = FXCollections.observableList((List<ShiftType>) rosterService.listShiftTypeId());
		return shiftListId;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		loadShift();
		
	}
	public void loadShift() {
		shiftTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		shiftTable.getItems().clear();
		shiftTable.setItems(getSkillsList());
		shifttype.setCellValueFactory(new PropertyValueFactory<ShiftType, String>("code"));
		startTime.setCellValueFactory(new PropertyValueFactory<ShiftType, String>("startTimeString"));
		finishTime.setCellValueFactory(new PropertyValueFactory<ShiftType, String>("endTimeString"));
		shiftdescription.setCellValueFactory(new PropertyValueFactory<ShiftType, String>("description"));
		isnight.setCellValueFactory(new PropertyValueFactory<ShiftType, Boolean>("night"));
		showShiftDetails(null);
		shiftTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftDetails(newValue));

	}

	private void showShiftDetails(ShiftType shift) {
		if (shift != null) {
			// Fill the labels with info from the skill object.

			shiftfield.setText(shift.getCode());
		
			start.setText(shift.getStartTimeString());
			finish.setText(shift.getEndTimeString());
			descriptionfield.setText(shift.getDescription());
			isNight.setText(Boolean.toString(shift.isNight()));

		} else {
			// Skill is null, remove all the text.

			
			shiftfield.setText("");
			start.setText("");
			finish.setText("");
			descriptionfield.setText("");
			isNight.setText("");

		}
	}

	@FXML
	private void handleDeleteShift() {
		int selectItem = shiftTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<ShiftType> itemsSelected;
			 itemsSelected = shiftTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeShiftType(itemsSelected);
				loadShift();
			} else

			{
				loadShift();
			}
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Shift Type Selected");
			alert.setContentText("Please select a Shift Type.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleNewShift() {
		ShiftType tempshift = new ShiftType();
		boolean okClicked = showShiftNewEditDialog(tempshift);

		if (okClicked) {

			showShiftDetails(tempshift);

		}
		loadShift();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditShift() {
		ShiftType selectedShift = shiftTable.getSelectionModel().getSelectedItem();

		if (selectedShift != null) {
			boolean okClicked = showShiftEditDialog(selectedShift);
			if (okClicked) {
				showShiftDetails(selectedShift);
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
		loadShift();
	}

	public boolean showShiftEditDialog(ShiftType shift) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/ShiftEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Shift");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShift(shift);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showShiftNewEditDialog(ShiftType shift) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShiftTypeNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Shift");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage)
			 */;
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftNewEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShift(shift);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
