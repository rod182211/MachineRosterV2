package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class ContractController implements Initializable {
	@FXML
	private StackPane contractTab;

	@FXML
	private TableView<Contract> contractTable;
	
	@FXML
	private TableColumn<Contract, String> contractCol;

	@FXML
	private TableColumn<Contract, String> descriptionCol;

	@FXML
	private TableColumn<Contract, String> weekenddefCol;

	@FXML
	private Label title;

	@FXML
	private Label contractId;

	@FXML
	private Label descriptionfield;
	@FXML
	private Label codefield;
	@FXML
	private Label weekenddef;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<Contract> contractList = FXCollections
			.observableArrayList();

	public ObservableList<Contract> getContractList() {
		if (!contractList.isEmpty())
			contractList.clear();
		contractList = FXCollections
				.observableList((List<Contract>) rosterService.listContract());
		return contractList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadContract();
	}
	public void loadContract() {
		contractTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		contractTable.getItems().clear();
		contractTable.setItems(getContractList());
		contractCol.setCellValueFactory(
				new PropertyValueFactory<Contract, String>("code"));
		showContractDetails(null);
		contractTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue,
						newValue) -> showContractDetails(newValue));

	}

	private void showContractDetails(Contract contract) {
		if (contract != null) {
			codefield.setText(contract.getCode());
			descriptionfield.setText(contract.getDescription());
			weekenddef.setText(contract.getWeekendDefinition().toString());

		} else {
			// Contract is null, remove all the text.

			codefield.setText("");
			descriptionfield.setText("");
			weekenddef.setText("");
		}
	}

	@FXML
	private void handleDeleteContract() {
		int selectIndex = contractTable.getSelectionModel().getSelectedIndex();
		if (selectIndex >= 0) {

			 ObservableList<Contract> itemsSelected;
			 itemsSelected = contractTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeContract(itemsSelected);
				loadContract();
			} else

			{
				loadContract();
			}
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Contract Selected");
			alert.setContentText("Please select a Contract.");

			alert.showAndWait();
		}
	}
	@FXML
	private void handleNewContract() {
		Contract tempcontract = new Contract();
		boolean okClicked = showContractNewEditDialog(tempcontract);

		if (okClicked) {

			loadContract();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditContract() {
		Contract selectedContract = contractTable.getSelectionModel()
				.getSelectedItem();

		if (selectedContract != null) {
			boolean okClicked = showContractEditDialog(selectedContract);
			if (okClicked) {
				showContractDetails(selectedContract);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Contract Selected");
			alert.setContentText("Please select a Contract in the table.");

			alert.showAndWait();
		}
	}

	public boolean showContractEditDialog(Contract contract) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					getClass().getResource("/fxml/ContractEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Contract");
			
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ContractEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setContract(contract);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showContractNewEditDialog(Contract contract) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/fxml/ContractNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Contract");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ContractNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setContract(contract);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
