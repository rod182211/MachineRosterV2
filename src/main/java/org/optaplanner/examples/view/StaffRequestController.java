package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StaffRequestController implements Initializable {
	@FXML
	private Label applicatontitle;
	@FXML
	private Label applicatonname;

	@FXML
	private Button btnDayOn;

	@FXML
	private Button btnDayOff;

	@FXML
	private Button btnShiftOn;

	@FXML
	private Button btnShiftOff;
	@FXML
	private Button btnHoliday;
	@FXML
	private Button btnRosterDayOff;
	@FXML
	private Button btnLeave;
	@FXML
	private Button btnTraining;
	
	

	@FXML
	void handleButtonClick(ActionEvent event) {
		if (event.getSource() == btnDayOn) {
			loadStage("/fxml/DayOn.fxml");
		} else if (event.getSource() == btnDayOff) {
			loadStage("/fxml/DayOff.fxml");
		} else if (event.getSource() == btnShiftOn) {
			loadStage("/fxml/ShiftOn.fxml");
		} else if (event.getSource() == btnShiftOff) {
			loadStage("/fxml/ShiftOff.fxml");		
		}
		else if (event.getSource() == btnRosterDayOff) {
			loadStage("/fxml/RosterDayOff.fxml");
		
		}
		else if (event.getSource() == btnHoliday) {
			loadStage("/fxml/Holiday.fxml");
		
		}
		else if (event.getSource() == btnLeave) {
			loadStage("/fxml/Leave.fxml");
		
		}
		else if (event.getSource() == btnTraining) {
			loadStage("/fxml/Training.fxml");
		
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	private void loadStage(String fxml) {
		try {
			Parent root2 = FXMLLoader.load(getClass().getResource(fxml));
			Stage stage = new Stage();
			stage.setScene(new Scene(root2));
			// stage.getIcons().add(new Image("/icons/icon.png"));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
