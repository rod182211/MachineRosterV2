package org.optaplanner.examples.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.optaplanner.examples.nurserostering.domain.contract.PatternContractLine;
import org.optaplanner.examples.nurserostering.domain.pattern.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PatternNewController implements Initializable {


@FXML
private ComboBox<Contract> contractforpattern;
@FXML
private ComboBox<Pattern> patternl;

private PatternContractLine patterndata;


private Stage dialogStage;

private boolean okClicked = false;

private RosterService rosterService = new RosterServiceImpl();




private ObservableList<PatternContractLine> patterndataList = FXCollections.observableArrayList();

public ObservableList<PatternContractLine> getPatternContractLineList() {
	if (!patterndataList.isEmpty())
		patterndataList.clear();
	patterndataList = FXCollections.observableList((List<PatternContractLine>) rosterService.listPatternContractLine());
	return patterndataList;
}
private ObservableList<PatternContractLine> patterndatacontractlineList = FXCollections.observableArrayList();

public ObservableList<PatternContractLine> getPatternContractLinecontractlineList() {
	if (!patterndatacontractlineList.isEmpty())
		patterndatacontractlineList.clear();
	patterndatacontractlineList = FXCollections.observableList((List<PatternContractLine>) rosterService.listPatternContractLine());
	return patterndatacontractlineList;
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

public void setPatternContractLineNew(PatternContractLine patterndata) {
this.patterndata = patterndata;

getContractList();
contractforpattern.setItems(contractList);
contractforpattern.setValue(patterndata.getContract());
getPatternList();
patternl.setItems(patternList);
patternl.setValue(patterndata.getPattern());
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

	Pattern pattern =  patternl.getSelectionModel().getSelectedItem();
	Contract contract = contractforpattern.getSelectionModel().getSelectedItem();
	patterndata.setContract(contract);
	patterndata.setPattern(pattern);
	okClicked = true;
	rosterService.addPatternContractLine(patterndata);
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Information Dialog");
	alert.setHeaderText(null);
	alert.setContentText("Update Succesfull");
	alert.showAndWait();
	dialogStage.close();
}


/**
* Called when the user clicks cancel.
*/
@FXML
private void handleCancel() {
dialogStage.close();
}


}