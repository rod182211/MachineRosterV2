package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;

import org.optaplanner.examples.nurserostering.domain.pattern.ShiftType2DaysPattern;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Unwanted2DayController implements Initializable {

	@FXML
	private TableView<ShiftType2DaysPattern> unwanted2dayTable;

	@FXML
	private TableColumn<ShiftType2DaysPattern, String> code;

	@FXML
	private TableColumn<ShiftType2DaysPattern, Integer> weight;
	@FXML
	private TableColumn<ShiftType2DaysPattern, String> dayIndex0ShiftType;
	
	@FXML
	private TableColumn<ShiftType2DaysPattern, String> dayIndex1ShiftType;
	

	@FXML
	private Label dayweight;

	@FXML
	private Label codefield;

	@FXML
	private Label dayIndex0ShiftTypefield;
	@FXML
	private Label dayIndex1ShiftTypefield;
	

	private ShiftType2DaysPattern shift2daydata;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<ShiftType2DaysPattern> shift2daydataList = FXCollections.observableArrayList();

	public ObservableList<ShiftType2DaysPattern> getShiftType2DaysPatternList() {
		if (!shift2daydataList.isEmpty())
			shift2daydataList.clear();
		shift2daydataList = FXCollections.observableList((List<ShiftType2DaysPattern>) rosterService.listShiftType2DaysPattern());
		return shift2daydataList;
	}



	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadShiftType2DaysPattern();

	}

	public void loadShiftType2DaysPattern() {
		unwanted2dayTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		unwanted2dayTable.getItems().clear();
		unwanted2dayTable.setItems(getShiftType2DaysPatternList());
		dayIndex0ShiftType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDayIndex0ShiftType().getCode()));
		dayIndex1ShiftType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDayIndex1ShiftType().getCode()));
		code.setCellValueFactory(new PropertyValueFactory<ShiftType2DaysPattern, String>("code"));
		weight.setCellValueFactory(new PropertyValueFactory<ShiftType2DaysPattern, Integer>("weight"));
		
			showShiftType2DaysPatternDetails(null);
		unwanted2dayTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftType2DaysPatternDetails(newValue));

	}

	private void showShiftType2DaysPatternDetails(ShiftType2DaysPattern shift2daydata) {
		if (shift2daydata != null) {
			dayIndex0ShiftTypefield.setText(shift2daydata.getDayIndex0ShiftType().getCode());
			dayIndex1ShiftTypefield.setText(shift2daydata.getDayIndex1ShiftType().getCode());
		
			codefield.setText(shift2daydata.getCode());
			dayweight.setText(Integer.toString(shift2daydata.getWeight()));

		} else {

			dayIndex0ShiftTypefield.setText("");
			dayIndex1ShiftTypefield.setText("");
			codefield.setText("");
			dayweight.setText("");

		}
	}

	@FXML
	private void handleDeleteShiftType2DaysPattern() {
		int select = unwanted2dayTable.getSelectionModel().getSelectedIndex();
		
		if (select >= 0) {
			 ObservableList<ShiftType2DaysPattern> itemsSelected;
			 itemsSelected = unwanted2dayTable.getSelectionModel().getSelectedItems();
		Alert alertpattern = new Alert(AlertType.CONFIRMATION);
		alertpattern.setTitle("STOP");
		alertpattern.setHeaderText("YOU MUST DELETE the Pattern entery First");
		alertpattern.setContentText("Click OK if already deleted or Cancel to delete the Pattern");
		Optional<ButtonType> resultpattern = alertpattern.showAndWait();
		if (resultpattern.get() == ButtonType.OK) {
			rosterService.removeShiftType2DaysPattern(itemsSelected);
			loadShiftType2DaysPattern();
			
		}
		
		else {
			  loadStage("/fxml/Pattern.fxml");
		}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No item Selected");
			alert.setContentText("Please select a row.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleNewShiftType2DaysPatternDetails() {
		ShiftType2DaysPattern temprequest = new ShiftType2DaysPattern();
		boolean okClicked = showShiftType2DaysPatternDetailsNewEditDialog(temprequest);

		if (okClicked) {

			showShiftType2DaysPatternDetails(shift2daydata);
		}
		loadShiftType2DaysPattern();

	}

	
	@FXML
	private void handleEditShiftType2DaysPattern() {

		ShiftType2DaysPattern selectedrequest = unwanted2dayTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showShiftType2DaysPatternDetailsEditDialog(selectedrequest);
			if (okClicked) {
				showShiftType2DaysPatternDetails(selectedrequest);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Shift Selected");
			alert.setContentText("Please select a row in the table.");

			alert.showAndWait();
		}
		loadShiftType2DaysPattern();

	}

	public boolean showShiftType2DaysPatternDetailsEditDialog(ShiftType2DaysPattern shift2daydata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/ShiftType2DaysPatternDataEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Unwanted 2 day Pattern");
			
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			
			ShiftType2DaysPatternEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftType2DaysPatternDetails(shift2daydata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showShiftType2DaysPatternDetailsNewEditDialog(ShiftType2DaysPattern shift2daydata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShiftType2DaysPatternNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New 2 Day Pattern");
			
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			ShiftType2DaysPatternNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftType2DaysPatternDetails(shift2daydata);
			
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	  private void loadStage(String fxml) {
	        try {
	            Parent root = FXMLLoader.load(getClass().getResource(fxml));
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	         //   stage.getIcons().add(new Image("/icons/icon.png"));
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
