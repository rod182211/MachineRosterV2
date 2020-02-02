package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.WeekendDefinition;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ContractEditController implements Initializable {

	@FXML
	private TextField contractId;
	@FXML
	private TextField contractcode;
	@FXML
	private TextField contractDescription;
	@FXML
	private TextField weekenddefinition;

	private Stage dialogStage;

	private Contract contract;
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<Contract> contractList = FXCollections.observableArrayList();

	public ObservableList<Contract> getContractList() {
		if (!contractList.isEmpty())
			contractList.clear();
		contractList = FXCollections.observableList((List<Contract>) rosterService.listContract());
		return contractList;
	}

	private ObservableList<Contract> contractListId = FXCollections.observableArrayList();

	public ObservableList<Contract> getContractListId() {
		if (!contractListId.isEmpty())
			contractListId.clear();
		contractListId = FXCollections.observableList((List<Contract>) rosterService.listContract());
		return contractListId;
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@Override
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
	
	public void setContract(Contract contract) {
		this.contract = contract;
		contractcode.setText(contract.getCode());
		contractDescription.setText(contract.getDescription());
		weekenddefinition.setText(contract.getWeekendDefinition().toString());
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
					
			String Contract = contractcode.getText();
			String contractdescription = contractDescription.getText();
			String weekendDefinition1 = weekenddefinition.getText();
			WeekendDefinition weekendDefinition = Enum.valueOf(WeekendDefinition.class, weekendDefinition1);
			contract.setCode(Contract);
			contract.setDescription(contractdescription);
			contract.setWeekendDefinition(weekendDefinition);
			okClicked = true;
			rosterService.updateContract(contract);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Update Succesfull!");
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

		if (contractcode.getText() == null || contractcode.getText().length() == 0) {
			errorMessage += "No valid Code!\n";
		}
		if (contractDescription.getText() == null ||contractDescription.getText().length() == 0) {
			errorMessage += "No valid Decription!\n";
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
