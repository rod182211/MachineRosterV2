package org.optaplanner.examples.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
	@FXML
	private Label applicatontitle;
	@FXML
	private Label applicatonname;

	@FXML
	private Button btnSkills;

	@FXML
	private Button btnShiftType;

	@FXML
	private Button btnContract;

	@FXML
	private Button btnWorkBefore;

	@FXML
	private Button btnShift2days;

	@FXML
	private Button btnShift3Days;
	@FXML
	private Button btnContractLine;
	@FXML
	private Button btnShiftAssignement;

	@FXML
	private Button btnMinMaxContract;
	@FXML
	private Button btnPatternContractLine;
	@FXML
	private Button btnBooleanContract;
	@FXML
	private Button btnPattern;
	@FXML
	private Button btnFreeBefore2days;
	
	@FXML
	private Button btnCoverRequiremtns;
	@FXML
	private Button btnSkillProficiency;

	@FXML
	void handleButtonClick(ActionEvent event) {
		if (event.getSource() == btnSkills) {
			loadStage("/fxml/Skills.fxml");
		} else if (event.getSource() == btnShiftType) {
			loadStage("/fxml/Shifts.fxml");
		} else if (event.getSource() == btnContract) {
			loadStage("/fxml/Contract.fxml");
		} else if (event.getSource() == btnBooleanContract) {
			loadStage("/fxml/Boolean.fxml");
		} else if (event.getSource() == btnWorkBefore) {
			loadStage("/fxml/WorkBeforeFree.fxml");
		} else if (event.getSource() == btnFreeBefore2days) {
			loadStage("/fxml/FreeBefore2Days.fxml");

		} else if (event.getSource() == btnShiftAssignement) {
			loadStage("/fxml/ShiftAssignment.fxml");
		}
		else if (event.getSource() ==  btnMinMaxContract) {
			loadStage("/fxml/MinMax.fxml");
		}
		else if (event.getSource() ==  btnPatternContractLine) {
			loadStage("/fxml/Pattern.fxml");
		}
		else if (event.getSource() ==  btnShift2days) {
			loadStage("/fxml/Unwanted2Day.fxml");
		}
		else if (event.getSource() ==  btnShift3Days) {
			loadStage("/fxml/Unwanted3Days.fxml");
		}
		else if (event.getSource() == btnCoverRequiremtns) {
			loadStage("/fxml/CoverRequirements.fxml");
		}
		else if (event.getSource() ==  btnSkillProficiency) {
			loadStage("/fxml/SkillProficiency.fxml");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	private void loadStage(String fxml) {
		try {
			Parent root1 = FXMLLoader.load(getClass().getResource(fxml));
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			// stage.getIcons().add(new Image("/icons/icon.png"));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
