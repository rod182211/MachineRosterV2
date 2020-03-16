package org.optaplanner.examples.view;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.contract.BooleanContractLine;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BooleanController {

	@FXML
	private TableView<BooleanContractLine> booleanContractLineTable;

	@FXML
	private TableColumn<BooleanContractLine, String> contractcol;

	@FXML
	private TableColumn<BooleanContractLine, String> contractline;
	@FXML
	private TableColumn<BooleanContractLine, Integer> weight;

	@FXML
	private TableColumn<BooleanContractLine, Boolean> enabled;

	@FXML
	private Label contractlineenable;
	@FXML
	private Label contractlinetype;
	@FXML
	private Label bcontract;
	@FXML
	private Label bweight;

	@FXML
	private Label bolId;

	private RosterService rosterService = new RosterServiceImpl();

	private ObservableList<BooleanContractLine> booleandataList = FXCollections.observableArrayList();

	public ObservableList<BooleanContractLine> getBooleanDataList() {
		if (!booleandataList.isEmpty())
			booleandataList.clear();
		booleandataList = FXCollections
				.observableList((List<BooleanContractLine>) rosterService.listBooleanContractLine());
		return booleandataList;
	}

	@FXML
	public void initialize() {

		loadBoolean();

	}

	private void loadBoolean() {
		booleanContractLineTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		booleanContractLineTable.getItems().clear();
		booleanContractLineTable.setItems(getBooleanDataList());

		contractcol
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContract().getCode()));
		weight.setCellValueFactory(new PropertyValueFactory<BooleanContractLine, Integer>("weight"));
		enabled.setCellValueFactory(new PropertyValueFactory<BooleanContractLine, Boolean>("enabled"));
		contractline.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getContractLineType().toString()));

		// is set to allow for editing of the table
		booleanContractLineTable.setEditable(true);
		// converts the string to an integer for the table
		// sets the name field of the table
		contractcol.setCellFactory(TextFieldTableCell.forTableColumn());
		// getContractListId();
		showBooleanDetails(null);
		booleanContractLineTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showBooleanDetails(newValue));

	}

	private void showBooleanDetails(BooleanContractLine booleandata) {
		if (booleandata != null) {

			bweight.setText(Integer.toString(booleandata.getWeight()));
			bcontract.setText(booleandata.getContract().getCode());
			contractlineenable.setText(booleandata.getContractLineType().toString());
			contractlineenable.setText(Boolean.toString(booleandata.isEnabled()));
			contractlinetype.setText(booleandata.getContractLineType().name());
		} else {

			bweight.setText("");
			bcontract.setText("");
			contractlinetype.setText("");
			contractlineenable.setText("");
		}
	}

	@FXML
	private void handleDeleteBoolean() {
		int selectedIndex = booleanContractLineTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			ObservableList<BooleanContractLine> itemsSelected;
			itemsSelected = booleanContractLineTable.getSelectionModel().getSelectedItems();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeBooleanContractLine(itemsSelected);
				loadBoolean();
			} else

			{
				loadBoolean();
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
	private void handleNewBoolean() {
		BooleanContractLine tempboolean = new BooleanContractLine();
		boolean okClicked = showBooleanNewEditDialog(tempboolean);

		if (okClicked) {
			loadBoolean();
			showBooleanDetails(tempboolean);

		}

	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * 
	 */
	@FXML
	private void handleEditBoolean() {
		BooleanContractLine selectedBoolean = booleanContractLineTable.getSelectionModel().getSelectedItem();

		if (selectedBoolean != null) {

			boolean okClicked = showBooleanEditDialog(selectedBoolean);

			if (okClicked) {
				showBooleanDetails(selectedBoolean);
			}
			loadBoolean();

		}

		// }
		else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Item Selected");
			alert.setContentText("Please select an item in the table.");

			alert.showAndWait();
		}
	}

	public boolean showBooleanEditDialog(BooleanContractLine booleandata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/BooleanEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Boolean");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			BooleanEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setBoolean(booleandata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showBooleanNewEditDialog(BooleanContractLine booleandata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BooleanNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Boolean");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage)
			 */;
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			BooleanNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setBoolean(booleandata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
