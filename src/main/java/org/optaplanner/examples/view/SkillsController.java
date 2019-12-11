package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;


import org.optaplanner.examples.nurserostering.domain.Skill;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SkillsController implements Initializable {
	@FXML
	private AnchorPane skillsTab;

	@FXML
	private TableView<Skill> skillsTable;

	
	@FXML
	private TableColumn<Skill, String> skillsCol;

	
	@FXML
	private Label skillfield;



	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<Skill> skillsList = FXCollections.observableArrayList();

	public ObservableList<Skill> getSkillsList() {
		if (!skillsList.isEmpty())
			skillsList.clear();
		skillsList = FXCollections.observableList((List<Skill>) rosterService.listSkill());
		return skillsList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadSkill();
	}

	public void loadSkill() {
		skillsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		skillsTable.getItems().clear();
		skillsTable.setItems(getSkillsList());
		skillsCol.setCellValueFactory(new PropertyValueFactory<Skill, String>("code"));
		showSkillsDetails(null);
		skillsTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showSkillsDetails(newValue));

	}

	private void showSkillsDetails(Skill skills) {
		if (skills != null) {
			// Fill the labels with info from the skill object.

			skillfield.setText(skills.getCode());
		

		} else {
			// Skill is null, remove all the text.
			
			skillfield.setText("");

		}
	}

	@FXML
	private void handleDeleteSkills() {
		int selectItem = skillsTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {
			 ObservableList<Skill> itemsSelected;
			 itemsSelected = skillsTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeSkill(itemsSelected);
				loadSkill();
			} else

			{
				loadSkill();
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Skill Selected");
			alert.setContentText("Please select a Skill.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleNewSkills() {
		Skill tempskills = new Skill();
		boolean okClicked = showSkillsNewEditDialog(tempskills);

		if (okClicked) {
//    recall the screen
			loadSkill();

		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditSkills() {
		Skill selectedSkills = skillsTable.getSelectionModel().getSelectedItem();

		if (selectedSkills != null) {
			boolean okClicked = showSkillsEditDialog(selectedSkills);
			if (okClicked) {
				showSkillsDetails(selectedSkills);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Skill Selected");
			alert.setContentText("Please select a skill in the table.");

			alert.showAndWait();
		}
		loadSkill();
	}

	public boolean showSkillsEditDialog(Skill skills) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/SkillsEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Skills");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			SkillsEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSkills(skills);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showSkillsNewEditDialog(Skill skills) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SkillsNewEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Skill");
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			SkillsNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSkills(skills);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
