package org.optaplanner.examples.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.examples.nurserostering.app.NurseRosteringApp;
import org.optaplanner.swing.impl.SwingUncaughtExceptionHandler;
import org.optaplanner.swing.impl.SwingUtils;

public class MainController implements Initializable {

	@FXML
	private Button btnShiftRequest;

	@FXML
	private Button btnEmployees;

	@FXML
	private Button btnScheduleRun;

	@FXML
	private Button btnSettings;

	@FXML
	private Button btnSchedInitialise;

	@FXML
	private Button btnReport;

	@FXML
	private Button calendar;
	@FXML
	private Button btnmynuserroster;

	
	@FXML
	void handleButtonClicks(ActionEvent event) throws Exception {

		if (event.getSource() == btnEmployees) {
			loadStage("/fxml/Employee.fxml");
		} else if (event.getSource() == btnShiftRequest) {
			loadStage("/fxml/Requests.fxml");

		} else if (event.getSource() == btnReport) {
			loadStage("/fxml/ShiftReport.fxml");

		} else if (event.getSource() == btnmynuserroster) {
			loadStage("/fxml/NurseRosteringPanel.fxml");

		} else if (event.getSource() == calendar) {
			Stage primaryStage = (Stage) calendar.getScene().getWindow();
			
			@SuppressWarnings("rawtypes")
			CalendarController app = new CalendarController();
			app.start(primaryStage);
			

		} else if (event.getSource() == btnScheduleRun) {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Request Confirmation");
			alert.setHeaderText("Have you entered all Requests?");
			alert.setContentText("Click OK if entered or Cancel to complete requests?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// I don't think I need to prepare a I like the other look
		 prepareSwingEnvironment();
				new NurseRosteringApp().init();
				
			} else {
				loadStage("/fxml/Requests.fxml");
			}

		} else if (event.getSource() == btnSettings) {
			loadStage("/fxml/Settings.fxml");
		} else if (event.getSource() == btnSchedInitialise) {
			loadStage("/fxml/ScheduleDateInitialiser.fxml");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public static void prepareSwingEnvironment() {
		SwingUncaughtExceptionHandler.register();
		SwingUtils.fixateLookAndFeel();
	}

	private void loadStage(String fxml) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.initModality(Modality.WINDOW_MODAL);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}