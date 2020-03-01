package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.contract.BooleanContractLine;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.optaplanner.examples.nurserostering.domain.contract.ContractLine;
import org.optaplanner.examples.nurserostering.domain.contract.ContractLineType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BooleanNewController implements Initializable {

	@FXML
	private TextField idfield;
	@FXML
	private ComboBox<Contract> contract;
	@FXML
	private ComboBox<String> contractLine;

	@FXML
	private TextField weight;

	@FXML
	private CheckBox contractline;

	private Stage dialogStage;

	private BooleanContractLine booleandata;

	private boolean okClicked = false;
	private RosterService rosterService = new RosterServiceImpl();

	private ObservableList<BooleanContractLine> booleandataList = FXCollections
			.observableArrayList();

	public ObservableList<BooleanContractLine> getBooleanDataList() {
		if (!booleandataList.isEmpty())
			booleandataList.clear();
		booleandataList = FXCollections
				.observableList((List<BooleanContractLine>) rosterService
						.listBooleanContractLine());
		return booleandataList;
	}

	private ObservableList<Contract> contractList = FXCollections
			.observableArrayList();

	public ObservableList<Contract> getContractList() {
		if (!contractList.isEmpty())
			contractList.clear();
		contractList = FXCollections
				.observableList((List<Contract>) rosterService.listContract());
		return contractList;
	}
	private ObservableList<ContractLine> contractLineList = FXCollections
			.observableArrayList();

	public ObservableList<ContractLine> getContractLineList() {
		if (!contractLineList.isEmpty())
			contractLineList.clear();
		contractLineList = FXCollections.observableList(
				(List<ContractLine>) rosterService.listContractLine());
		return contractLineList;
	}
	private ObservableList<String> contractLineTypeList = FXCollections
			.observableArrayList("SINGLE_ASSIGNMENT_PER_DAY",
					"COMPLETE_WEEKENDS", "IDENTICAL_SHIFT_TYPES_DURING_WEEKEND",
					"NO_NIGHT_SHIFT_BEFORE_FREE_WEEKEND",
					"ALTERNATIVE_SKILL_CATEGORY","ALTERNATIVE_MACHINE","IS_LOADBALANCED","NO_NIGHT_SHIFTS",
					"IS_CASUAL");
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
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

	
	public void setBoolean(BooleanContractLine booleandata) {
		this.booleandata = booleandata;
		getContractList();
		weight.setText(Integer.toString(booleandata.getWeight()));
		contract.setItems(contractList);
		contractLine.setItems(contractLineTypeList);

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
			Contract contractId = contract.getSelectionModel()
					.getSelectedItem();
			String contractLinetype = contractLine.getSelectionModel()
					.getSelectedItem();
			ContractLineType linetype = Enum.valueOf(ContractLineType.class,
					contractLinetype);
			booleandata.setContractLineType(linetype);
			booleandata.setContract(contractId);
			if (contractline.isSelected()) {
				boolean selected = true;
				booleandata.setEnabled(selected);
			} else {

				boolean notselected = false;
				booleandata.setEnabled(notselected);
			}

			if (contractline.isSelected()) {
				boolean selected = true;
				booleandata.setEnabled(selected);
			} else {

				boolean notselected = false;
				booleandata.setEnabled(notselected);
			}

			okClicked = true;
			rosterService.addBooleanContractLine(booleandata);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("YOUR AWESOME");
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

		if (weight.getText() == null || weight.getText().length() == 0) {
			errorMessage += "No valid weight\n";
		}
		if (contract.getSelectionModel().getSelectedItem() == null ) {
			errorMessage += "No valid Contract\n";
		}
		if (contractLine.getSelectionModel().getSelectedItem() == null ) {
			errorMessage += "No valid ContractLine\n";
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
