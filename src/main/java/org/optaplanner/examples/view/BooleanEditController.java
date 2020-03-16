package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.contract.BooleanContractLine;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class BooleanEditController implements Initializable {

	@FXML
	private ComboBox<Contract> contract;

	@FXML
	private TextField weight;

	@FXML
	private CheckBox contractline;

	private Stage dialogStage;

	private BooleanContractLine booleandata;

	private boolean okClicked = false;
	private RosterService rosterService = new RosterServiceImpl();

	private ObservableList<BooleanContractLine> booleandataList = FXCollections.observableArrayList();

	public ObservableList<BooleanContractLine> getBooleanDataList() {
		if (!booleandataList.isEmpty())
			booleandataList.clear();
		booleandataList = FXCollections
				.observableList((List<BooleanContractLine>) rosterService.listBooleanContractLine());
		return booleandataList;
	}

	private ObservableList<Contract> contractList = FXCollections.observableArrayList();

	public ObservableList<Contract> getContractList() {
		if (!contractList.isEmpty())
			contractList.clear();
		contractList = FXCollections.observableList((List<Contract>) rosterService.listContract());
		return contractList;
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	
	 */

	public void setBoolean(BooleanContractLine booleandata) {
		this.booleandata = booleandata;
		weight.setText(Integer.toString(booleandata.getWeight()));
		contract.setValue(booleandata.getContract());
		getContractList();
		contract.setItems(contractList);
		contractline.setText(booleandata.getContractLineType().toString());
		contractline.setSelected(booleandata.isEnabled());

	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {

			String weightpas = weight.getText();
			int weightinint = Integer.parseInt(weightpas);
			booleandata.setWeight(weightinint);
			Contract contractId = contract.getSelectionModel().getSelectedItem();
			booleandata.setContract(contractId);
			if (contractline.isSelected()) {
				boolean selected = true;
				booleandata.setEnabled(selected);
			} else {

				boolean notselected = false;
				booleandata.setEnabled(notselected);
			}

			okClicked = true;
			rosterService.updateBooleanContractLine(booleandata);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Update Succesfulll!");
			alert.showAndWait();
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (weight.getText() == null || weight.getText().length() == 0) {
			errorMessage += "No valid Request!\n";
		}
		if (contract.getSelectionModel().getSelectedItem() == null) {
			errorMessage += "No valid Contract!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}
