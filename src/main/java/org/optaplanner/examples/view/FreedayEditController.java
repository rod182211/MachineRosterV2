package org.optaplanner.examples.view;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.pattern.FreeBefore2DaysWithAWorkDayPattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class FreedayEditController implements Initializable {

	
	@FXML
	private TextField freecode;

	@FXML
	private TextField startTime;

	@FXML
	private TextField freeweight;

	@FXML
	private ComboBox<String> freedayofweek;

	private Stage dialogStage;

	private FreeBefore2DaysWithAWorkDayPattern freeday;
	private boolean okClicked = false;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<FreeBefore2DaysWithAWorkDayPattern> feedayList = FXCollections.observableArrayList();

	public ObservableList<FreeBefore2DaysWithAWorkDayPattern> getFreeBefore2DaysWithAWorkDayPatternList() {
		if (!feedayList.isEmpty())
			feedayList.clear();
		feedayList = FXCollections.observableList((List<FreeBefore2DaysWithAWorkDayPattern>) rosterService
				.listFreeBefore2DaysWithAWorkDayPattern());
		return feedayList;
	}

	
	private ObservableList<String> dayList =  FXCollections.observableArrayList("MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY");

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

	public void setFreeDay(FreeBefore2DaysWithAWorkDayPattern freeday) {
		this.freeday = freeday;
		
		freecode.setText(freeday.getCode());
		freeweight.setText(Integer.toString(freeday.getWeight()));
		freedayofweek.setValue(freeday.getFreeDayOfWeek().toString());
		freedayofweek.setItems(dayList);
	

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

		
			String weightpas = freeweight.getText();
			int weightinint = Integer.parseInt(weightpas);
			String dow = (String) freedayofweek.getSelectionModel().getSelectedItem();
			DayOfWeek newdow = DayOfWeek.valueOf(dow);
			freeday.setCode(freecode.getText());
			freeday.setWeight(weightinint);
			freeday.setFreeDayOfWeek(newdow);
			okClicked = true;
			rosterService.updateFreeBefore2DaysWithAWorkDayPattern(freeday);
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

		if (freecode.getText() == null || freecode.getText().length() == 0) {
			errorMessage += "No valid freeday!\n";
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
