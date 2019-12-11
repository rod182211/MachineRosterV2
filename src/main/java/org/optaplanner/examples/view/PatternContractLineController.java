package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.optaplanner.examples.nurserostering.domain.contract.PatternContractLine;
import org.optaplanner.examples.nurserostering.domain.pattern.Pattern;

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

public class PatternContractLineController implements Initializable {

	@FXML
	private TableView<PatternContractLine> patternTable;

	@FXML
	private TableColumn<PatternContractLine, String> contract;
	@FXML
	private TableColumn<PatternContractLine, String> patterntype;

	@FXML
	private Label contractfield;

	@FXML
	private Label patternfield;

	private RosterService rosterService = new RosterServiceImpl();

	private ObservableList<PatternContractLine> patterndataList = FXCollections.observableArrayList();

	public ObservableList<PatternContractLine> getPatternContractLineList() {
		if (!patterndataList.isEmpty())
			patterndataList.clear();
		patterndataList = FXCollections
				.observableList((List<PatternContractLine>) rosterService.listPatternContractLine());
		return patterndataList;
	}

	private ObservableList<Contract> contractList = FXCollections.observableArrayList();

	public ObservableList<Contract> getContractList() {
		if (!contractList.isEmpty())
			contractList.clear();
		contractList = FXCollections.observableList((List<Contract>) rosterService.listContract());
		return contractList;
	}

	private ObservableList<Pattern> patternList = FXCollections.observableArrayList();

	public ObservableList<Pattern> getPatternList() {
		if (!patternList.isEmpty())
			patternList.clear();
		patternList = FXCollections.observableList((List<Pattern>) rosterService.listPattern());
		return patternList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadPatternContractLine();

	}

	public void loadPatternContractLine() {
		// initialize the employee table
		patternTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		patternTable.getItems().clear();
		patternTable.setItems(getPatternContractLineList());
		contract.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContract().getCode()));
		patterntype
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPattern().getCode()));
		// is set to allow for editing of the table
		patternTable.setEditable(true);
		// sets the name field of the table
		// contractcol.setCellFactory(TextFieldTableCell.forTableColumn());
		showPatternContractLineDetails(null);
		patternTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPatternContractLineDetails(newValue));
		// getContractListId();

	}

	private void showPatternContractLineDetails(PatternContractLine patterndata) {
		if (patterndata != null) {
			contractfield.setText(patterndata.getContract().getCode());
			patternfield.setText(patterndata.getPattern().getCode());

		} else {

			contractfield.setText("");
			patternfield.setText("");

		}
	}

	@FXML
	private void handleDeletePatternContractLine() {
		int selectedIndex = patternTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			ObservableList<PatternContractLine> itemsSelected;
			itemsSelected = patternTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("WARNING Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removePatternContractLine(itemsSelected);
				loadPatternContractLine();
			} else

			{
				loadPatternContractLine();
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
	private void handleNewPatternContractLine() {
		PatternContractLine temprequest = new PatternContractLine();
		boolean okClicked = showPatternContractLineNewEditDialog(temprequest);

		if (okClicked) {
			showPatternContractLineDetails(temprequest);
			loadPatternContractLine();
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditPatternContractLine() {
		PatternContractLine selectedrequest = patternTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showPatternContractLineEditDialog(selectedrequest);
			if (okClicked) {
				showPatternContractLineDetails(selectedrequest);
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
	}

	public boolean showPatternContractLineEditDialog(PatternContractLine patterndata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/PatternEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit PatternContractLine Contract Line");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			PatternEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPatternContractLineEdit(patterndata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showPatternContractLineNewEditDialog(PatternContractLine patterndata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PatternNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New PatternContractLine Contract Line");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage)
			 */;
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			PatternNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPatternContractLineNew(patterndata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
