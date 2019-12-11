package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.optaplanner.examples.nurserostering.domain.pattern.ShiftType3DaysPattern;


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

public class Unwanted3DyaPatternController implements Initializable {

	@FXML
	private TableView<ShiftType3DaysPattern> unwanted3dayTable;

	@FXML
	private TableColumn<ShiftType3DaysPattern, String> code;
	@FXML
	private TableColumn<ShiftType3DaysPattern, Integer> weight;
	@FXML
	private TableColumn<ShiftType3DaysPattern, ShiftType> dayIndex0ShiftType;
	
	@FXML
	private TableColumn<ShiftType3DaysPattern, ShiftType> dayIndex1ShiftType;
	
	@FXML
	private TableColumn<ShiftType3DaysPattern, ShiftType> dayIndex2ShiftType;
	
	@FXML
	private Label dayweight;

	@FXML
	private Label codefield;

	@FXML
	private Label dayIndex0ShiftTypefield;
	@FXML
	private Label dayIndex1ShiftTypefield;
	@FXML
	private Label dayIndex2ShiftTypefield;
	
	

	private ShiftType3DaysPattern shift3daydata;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<ShiftType3DaysPattern> shift3daydataList = FXCollections.observableArrayList();

	public ObservableList<ShiftType3DaysPattern> getShiftType3DaysPatternList() {
		if (!shift3daydataList.isEmpty())
			shift3daydataList.clear();
		shift3daydataList = FXCollections.observableList((List<ShiftType3DaysPattern>) rosterService.listShiftType3DaysPattern());
		return shift3daydataList;
	}

	private ObservableList<ShiftType3DaysPattern> shift3daydataListId = FXCollections.observableArrayList();

	public ObservableList<ShiftType3DaysPattern> getShiftType3DaysPatternListId() {
		if (!shift3daydataListId.isEmpty())
			shift3daydataListId.clear();
		shift3daydataListId = FXCollections.observableList((List<ShiftType3DaysPattern>) rosterService.listShiftType3DaysPatternId());
		return shift3daydataListId;
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadShiftType3DaysPattern();

	}

	public void loadShiftType3DaysPattern() {
		unwanted3dayTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		unwanted3dayTable.getItems().clear();
		unwanted3dayTable.setItems(getShiftType3DaysPatternList());
		dayIndex0ShiftType.setCellValueFactory(new PropertyValueFactory<ShiftType3DaysPattern, ShiftType>("dayIndex0ShiftType"));
		dayIndex1ShiftType.setCellValueFactory(new PropertyValueFactory<ShiftType3DaysPattern, ShiftType>("dayIndex1ShiftType"));
		dayIndex2ShiftType.setCellValueFactory(new PropertyValueFactory<ShiftType3DaysPattern, ShiftType>("dayIndex2ShiftType"));
		code.setCellValueFactory(new PropertyValueFactory<ShiftType3DaysPattern, String>("code"));
		weight.setCellValueFactory(new PropertyValueFactory<ShiftType3DaysPattern, Integer>("weight"));
		showShiftType3DaysPatternDetails(null);
		unwanted3dayTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showShiftType3DaysPatternDetails(newValue));

	}

	private void showShiftType3DaysPatternDetails(ShiftType3DaysPattern shift3daydata) {
		if (shift3daydata != null) {
			dayIndex0ShiftTypefield.setText(shift3daydata.getDayIndex0ShiftType().toString());
			dayIndex1ShiftTypefield.setText(shift3daydata.getDayIndex1ShiftType().toString());
			dayIndex2ShiftTypefield.setText(shift3daydata.getDayIndex2ShiftType().toString());
			codefield.setText(shift3daydata.getCode());
			dayweight.setText(Integer.toString(shift3daydata.getWeight()));

		} else {

			dayIndex0ShiftTypefield.setText("");
			dayIndex1ShiftTypefield.setText("");
			dayIndex2ShiftTypefield.setText("");
			codefield.setText("");
			dayweight.setText("");

		}
	}

	@FXML
	private void handleDeleteShiftType3DaysPattern() {
int select = unwanted3dayTable.getSelectionModel().getSelectedIndex();
		
		if (select >= 0) {
			 ObservableList<ShiftType3DaysPattern> itemsSelected;
			 itemsSelected = unwanted3dayTable.getSelectionModel().getSelectedItems();
		Alert alertpattern = new Alert(AlertType.CONFIRMATION);
		alertpattern.setTitle("Request Confirmation");
		alertpattern.setHeaderText("YOU MUST DELETE the Pattern entery First");
		alertpattern.setContentText("Click OK if already deleted or Cancel to delete the Pattern");
		Optional<ButtonType> resultpattern = alertpattern.showAndWait();
		if (resultpattern.get() == ButtonType.OK) {
			rosterService.removeShiftType3DaysPattern(itemsSelected);
			loadShiftType3DaysPattern();
			
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
	private void handleNewShiftType3DaysPatternDetails() {
		ShiftType3DaysPattern temprequest = new ShiftType3DaysPattern();
		boolean okClicked = showShiftType3DaysPatternDetailsNewEditDialog(temprequest);

		if (okClicked) {

			showShiftType3DaysPatternDetails(shift3daydata);
		}
		loadShiftType3DaysPattern();
	}

	
	@FXML
	private void handleEditShiftType3DaysPattern() {

		ShiftType3DaysPattern selectedrequest = unwanted3dayTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showShiftType3DaysPatternDetailsEditDialog(selectedrequest);
			if (okClicked) {
				showShiftType3DaysPatternDetails(selectedrequest);
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
		loadShiftType3DaysPattern();
	}

	public boolean showShiftType3DaysPatternDetailsEditDialog(ShiftType3DaysPattern shift3daydata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/ShiftType3DaysPatternDataEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Unwanted 3 day Pattern");
			
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			
			ShiftType3DaysPatternEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftType3DaysPatternDetails(shift3daydata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showShiftType3DaysPatternDetailsNewEditDialog(ShiftType3DaysPattern shift3daydata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShiftType3DaysPatternNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New 3 Day Pattern");
			
			
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ShiftType3DaysPatternNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setShiftType3DaysPattern(shift3daydata);

			// Show the dialog and wait until the user closes it
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
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
