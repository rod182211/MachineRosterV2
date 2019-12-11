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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class FreeDayNewEditController implements Initializable {

	
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

	private ObservableList<FreeBefore2DaysWithAWorkDayPattern> feedayListId = FXCollections.observableArrayList();

	public ObservableList<FreeBefore2DaysWithAWorkDayPattern> getFreeBefore2DaysWithAWorkDayPatternId() {
		if (!feedayListId.isEmpty())
			feedayListId.clear();
		feedayListId = FXCollections.observableList((List<FreeBefore2DaysWithAWorkDayPattern>) rosterService
				.listFreeBefore2DaysWithAWorkDayPattern());
		return feedayListId;
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
		freedayofweek.setItems(dayList);
		freecode.setText(freeday.getCode());
		freeweight.setText(Integer.toString(freeday.getWeight()));
		

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

			
			String freeday1 = freecode.getText();
			
			String dow = freedayofweek.getSelectionModel().getSelectedItem();
			// convert the String to Integer
			String weightpas = freeweight.getText();
			int weightinint = Integer.parseInt(weightpas);
			DayOfWeek newdow = DayOfWeek.valueOf(dow);
			freeday.setCode(freeday1);
			freeday.setWeight(weightinint);
			freeday.setFreeDayOfWeek(newdow);
			okClicked = true;
			rosterService.addFreeBefore2DaysWithAWorkDayPattern(freeday);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Free Day added Succesfully!");
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
			errorMessage += "No valid first name!\n";
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
