package org.optaplanner.examples.view;

import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;

import org.optaplanner.examples.nurserostering.domain.contract.ContractLineType;
import org.optaplanner.examples.nurserostering.domain.contract.MinMaxContractLine;

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

public class MinMaxNewController implements Initializable {

	@FXML
	private ComboBox <Contract>contract;

	@FXML
	private ComboBox <String>contractline;
	@FXML
	private TextField maxvalue;
	@FXML
	private TextField minvalue;

	@FXML
	private TextField maxweight;
	@FXML
	private TextField minweight;
	@FXML
	private CheckBox maxwenabled;
	@FXML
	private CheckBox minwenabled;
	

	private Stage dialogStage;

	private MinMaxContractLine minmaxdata;

	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<MinMaxContractLine> MinMaxContractLineList = FXCollections.observableArrayList();

	public ObservableList<MinMaxContractLine> getMinMaxContractLineList() {
		if (!MinMaxContractLineList.isEmpty())
			MinMaxContractLineList.clear();
		MinMaxContractLineList = FXCollections
				.observableList((List<MinMaxContractLine>) rosterService.listMinMaxContractLine());
		return MinMaxContractLineList;
	}

	
	private ObservableList<Contract> contractList = FXCollections.observableArrayList();

	public ObservableList<Contract> getContractList() {
		if (!contractList.isEmpty())
			contractList.clear();
		contractList = FXCollections.observableList((List<Contract>) rosterService.listContract());
		return contractList;
	}

	private ObservableList<String> contractLineTypeList =  FXCollections.observableArrayList("TOTAL_ASSIGNMENTS","CONSECUTIVE_WORKING_DAYS","CONSECUTIVE_FREE_DAYS", "CONSECUTIVE_WORKING_WEEKENDS","TOTAL_WORKING_WEEKENDS_IN_FOUR_WEEKS","TOTAL_NIGHT_ASSIGNMENTS","CONSECUTIVE_LATE_ASSIGNMENTS","CONSECUTIVE_EARLY_ASSIGNMENTS");
	/**
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
	 * Sets the employee to be edited in the dialog.
	 * 
	 * @param employee
	 */

	
	public void setMinMax(MinMaxContractLine minmaxdata) {
		this.minmaxdata = minmaxdata;
		getContractList();
		getMinMaxContractLineList();
		contract.setItems(contractList);		 
		contractline.setItems(contractLineTypeList);
		maxvalue.setText(Integer.toString(minmaxdata.getMaximumValue()));
		minvalue.setText(Integer.toString(minmaxdata.getMinimumValue()));
		maxweight.setText(Integer.toString(minmaxdata.getMaximumWeight()));
		minweight.setText(Integer.toString(minmaxdata.getMinimumWeight()));
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
			
			
			String contractLinetype = contractline.getSelectionModel().getSelectedItem();
			ContractLineType linetype = Enum.valueOf(ContractLineType.class, contractLinetype);
			minmaxdata.setContractLineType(linetype);
			String tempmaxval = maxvalue.getText();
			Contract contractnum = contract.getSelectionModel().getSelectedItem();
			minmaxdata.setContract(contractnum);
			int maxval = Integer.parseInt(tempmaxval);
			minmaxdata.setMaximumValue(maxval);
			String tempminval = minvalue.getText();
			int minval = Integer.parseInt(tempminval);
			minmaxdata.setMinimumValue(minval);
			String tempmaxweight = maxweight.getText();
			int maxw = Integer.parseInt(tempmaxweight);
			minmaxdata.setMaximumWeight(maxw);
			String tempminwieght = minweight.getText();
			int minw = Integer.parseInt(tempminwieght);
			minmaxdata.setMinimumWeight(minw);
			if (maxwenabled.isSelected()) {
				boolean selected = true;
				minmaxdata.setMaximumEnabled(selected);
				}else {
					
				boolean notselected = false;
				minmaxdata.setMaximumEnabled(notselected);
				}
			
			if (minwenabled.isSelected()) {
				boolean selected = true;
				minmaxdata.setMinimumEnabled(selected);
				}else {
					
				boolean notselected = false;
				minmaxdata.setMinimumEnabled(notselected);
				}
			okClicked = true;
			rosterService.addMinMaxContractLine(minmaxdata);
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
		if (contractline.getSelectionModel().getSelectedItem() == null ) {
			errorMessage += "No valid Contract Line!\n";
		}
		if (contract.getSelectionModel().getSelectedItem() == null ) {
			errorMessage += "No valid Contract!\n";
		}
		if (maxvalue.getText() == null || maxvalue.getText().length() == 0) {
			errorMessage += "No valid Max Value!\n";
		}
		if (maxweight.getText() == null || maxweight.getText().length() == 0) {
			errorMessage += "No valid Max Weight!\n";
		}
		if (minvalue.getText() == null || minvalue.getText().length() == 0) {
			errorMessage += "No valid Min Value!\n";
		}
		if (minweight.getText() == null || minweight.getText().length() == 0) {
			errorMessage += "No valid Min Weight!\n";
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
