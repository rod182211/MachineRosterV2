package org.optaplanner.examples.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.pool.RosterParametrizationData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RosterParametrizationDataNewEditDialog implements Initializable {
	
	@FXML
	private TextField Id;
	
	@FXML
	private TextField schedulename;

	@FXML
	private DatePicker startdate;

	@FXML
	private DatePicker enddate;
	
  
	private Stage dialogStage;

	private RosterParametrizationData scheddates;
	
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<RosterParametrizationData> RosterParametrizationDataList = FXCollections.observableArrayList();

	public ObservableList<RosterParametrizationData> getRosterParametrizationDataList() {
		  
		if (!RosterParametrizationDataList.isEmpty())
			RosterParametrizationDataList.clear();
		RosterParametrizationDataList = FXCollections.observableList((List<RosterParametrizationData>) rosterService.listRosterParametrizationData());
		return RosterParametrizationDataList;
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
	 * Sets the employee to be edited in the dialog.
	 * 
	 * @param employee
	 */
	
	public void setRosterParametrizationData(RosterParametrizationData scheddates) {
		
		this.scheddates = scheddates;
		
		schedulename.setText(scheddates.getCode());
		startdate.setValue(scheddates.getStartDate());
		
		
	
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
			String id = Id.getText();
			int idinfo = Integer.parseInt(id);
			scheddates.setId(idinfo);
			LocalDate firstdate = startdate.getValue();
			scheddates.setStartDate(firstdate);
			LocalDate finishdate = firstdate.plusDays(13);
			scheddates.setEndDate(finishdate);
			String schedname = schedulename.getText();
			scheddates.setCode(schedname);
			okClicked = true;
			rosterService.addRosterParametrizationData(scheddates);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Update Succesfull");
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

		if (schedulename.getText() == null || schedulename.getText().length() == 0) {
			errorMessage += "No valid Request!\n";
		}
		if (startdate.getValue() == null ) {
			errorMessage += "No valid Date!\n";
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


