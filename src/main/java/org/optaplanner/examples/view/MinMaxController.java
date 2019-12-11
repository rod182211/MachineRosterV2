package org.optaplanner.examples.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.nurserostering.domain.contract.MinMaxContractLine;



import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MinMaxController implements Initializable{

	@FXML
	private TableView<MinMaxContractLine> minmaxTable;

	@FXML
	private TableColumn<MinMaxContractLine, Boolean> minenabled;
	@FXML
	private TableColumn<MinMaxContractLine, Boolean> maxenabled;

	@FXML
	private TableColumn<MinMaxContractLine, String> contractcol;
	@FXML
	private TableColumn<MinMaxContractLine, String> contractl;

		
	@FXML
	private Label  contractline;
	@FXML
	private Label  Max;
	@FXML
	private Label  Min;
	@FXML
	private Label minweight;
	@FXML
	private Label maxweight;
	@FXML
	private Label maxshiftenabled;
	@FXML
	private Label minshiftenabled;
	
	@FXML
	private Label contract;
	
	
	
	


	private RosterService rosterService = new RosterServiceImpl();

	private ObservableList<MinMaxContractLine> minmaxdataList = FXCollections.observableArrayList();

	public ObservableList<MinMaxContractLine> getMinMaxDataList() {
		if (!minmaxdataList.isEmpty())
			minmaxdataList.clear();
		minmaxdataList = FXCollections.observableList((List<MinMaxContractLine>) rosterService.listMinMaxContractLine());
		return minmaxdataList;
	}

	
	
	 @Override
		public void initialize(URL location, ResourceBundle resources) {
		
		loadMinMax();
		
	}
	
	public void loadMinMax() {

		minmaxTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		minmaxTable.getItems().clear();
		minmaxTable.setItems(getMinMaxDataList());
		minenabled.setCellValueFactory(new PropertyValueFactory<MinMaxContractLine, Boolean>("minimumEnabled"));
		maxenabled.setCellValueFactory(new PropertyValueFactory<MinMaxContractLine, Boolean>("maximumEnabled"));
		contractcol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContract().getCode()));
		contractl.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContractLineType().toString()));
		showMinMaxDetails(null);
		minmaxTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showMinMaxDetails(newValue));

	}
	
	private void showMinMaxDetails(MinMaxContractLine minmaxdata) {
		if (minmaxdata != null) {
					
		    contractline.setText(minmaxdata.getContractLineType().toString());
		    Min.setText(Integer.toString(minmaxdata.getMinimumValue()));
		    Max.setText(Integer.toString(minmaxdata.getMaximumValue()));
		    contract.setText(minmaxdata.getContract().getCode());
		    minweight.setText(Integer.toString(minmaxdata.getMinimumWeight()));
		    maxweight.setText(Integer.toString(minmaxdata.getMaximumWeight()));
		    minshiftenabled.setText(Boolean.toString(minmaxdata.isMinimumEnabled()));
		    maxshiftenabled.setText(Boolean.toString(minmaxdata.isMaximumEnabled()));
		    
			

		} else { 

				
			contractline.setText("");
			Min.setText("");
			Max.setText("");
			contract.setText("");
			minweight.setText("");
			maxweight.setText("");
			minenabled.setText("");
			maxenabled.setText("");

		}
	}

	@FXML
	private void handleDeleteMinMax() {
		int selectItem =  minmaxTable.getSelectionModel().getSelectedIndex();
		if (selectItem >= 0) {

			 ObservableList<MinMaxContractLine> itemsSelected;
			 itemsSelected = minmaxTable.getSelectionModel().getSelectedItems();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Look, a Confirmation Dialog");
			alert.setContentText("Are you sure you want to Delete?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				rosterService.removeMinMaxContractLine(itemsSelected);
				loadMinMax();
			} else

			{
				loadMinMax();
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
	private void handleNewMinMax() {
		MinMaxContractLine temprequest = new MinMaxContractLine();
		boolean okClicked = showMinMaxNewEditDialog(temprequest);

		if (okClicked) {
			loadMinMax();
			showMinMaxDetails(temprequest);

		}
		loadMinMax();
		
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditMinMax() {
		
		MinMaxContractLine selectedrequest = minmaxTable.getSelectionModel().getSelectedItem();

		if (selectedrequest != null) {
			boolean okClicked = showMinMaxEditDialog(selectedrequest);
			if (okClicked) {
				loadMinMax();
				showMinMaxDetails(selectedrequest);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			// alert.initOwner(getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Item Selected");
			alert.setContentText("Please select an item in the table.");

			alert.showAndWait();
		}
		loadMinMax();
	}

	public boolean showMinMaxEditDialog(MinMaxContractLine minmaxdata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/MinMaxEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Min Max");
			/*
			 * dialogStage.initModality(Modality.WINDOW_MODAL);
			 * dialogStage.initOwner(primaryStage);
			 */
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MinMaxEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMinMax(minmaxdata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showMinMaxNewEditDialog(MinMaxContractLine minmaxdata) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MinMaxNewDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("New Item");
			
			/*  dialogStage.initModality(Modality.WINDOW_MODAL);
			  dialogStage.initOwner(primaryStage)*/
			 ;
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MinMaxNewController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMinMax(minmaxdata);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
