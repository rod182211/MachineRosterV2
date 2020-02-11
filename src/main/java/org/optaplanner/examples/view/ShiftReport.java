package org.optaplanner.examples.view;

import java.net.URL;

import java.util.List;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;

import org.optaplanner.examples.nurserostering.domain.Employee;

import org.optaplanner.examples.pool.CalendarData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShiftReport implements Initializable {
	
	private String shiftType;
	@FXML
	private Button mainmenue;
	
	@FXML
	private VBox drawer;

	@FXML
	private LineChart<String, Integer> shiftChart;
	@FXML
	CategoryAxis sxAxis;
	@FXML
	private BarChart<String, Integer> shiftviewChart;
	@FXML
	CategoryAxis svxAxis;
	@FXML
	NumberAxis yAxis;
	private int earlyshiftcounter = 0;
	private int nightshiftcounter = 0;
	private int dayshiftcounter = 0;
	private int lateshiftcounter = 0;
	private int lcshiftcounter = 0;
	private int adocounter = 0;
	private int leavecounter = 0;
	private int wlccounter = 0;
	private int trainingcounter = 0;

	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<CalendarData> calendarList = FXCollections.observableArrayList();

	public ObservableList<CalendarData> getCalendarDataList() {
		if (!calendarList.isEmpty())
			calendarList.clear();
		calendarList = FXCollections.observableList((List<CalendarData>) rosterService.listCalendarData());
		return calendarList;
	}

	private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

	public ObservableList<Employee> getEmployeeList() {
		if (!employeeList.isEmpty())
			employeeList.clear();
		employeeList = FXCollections.observableList((List<Employee>) rosterService.listEmployee());
		return employeeList;
	}

	private ObservableList<String> employees = FXCollections.observableArrayList();

	public void initialize(URL location, ResourceBundle resources) {
		loadBarchart();

	}

	private void loadBarchart() {		
		getCalendarDataList();
		Map<String, List<CalendarData>> assignmentMap = calendarList.stream()
				.collect(Collectors.groupingBy(CalendarData::getEmployeename));
	//	yAxis.setLabel("Shifts");
		Set<String> keyset = assignmentMap.keySet();
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series4 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series5 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series6 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series7 = new XYChart.Series<>();
		XYChart.Series<String, Integer> series8 = new XYChart.Series<>();
	//	svxAxis.setLabel("Employees");

		for (String key : keyset) {
			earlyshiftcounter = 0;
			nightshiftcounter = 0;
			dayshiftcounter = 0;
			lateshiftcounter = 0;
			lcshiftcounter = 0;
			adocounter = 0;
			leavecounter = 0;
			wlccounter = 0;
			trainingcounter = 0;

			employees.add(key);
			for (CalendarData e : calendarList) {

				String username = e.getEmployeename();
				if (key.equalsIgnoreCase(username)) {
					shiftType = e.getShiftType();
					if (shiftType.equalsIgnoreCase("E")) {
						earlyshiftcounter++;
						series.setName(shiftType);
						series.getData().add(new XYChart.Data<String, Integer>(key, earlyshiftcounter));

					} else if (shiftType.equalsIgnoreCase("N")) {
						nightshiftcounter++;
						series1.setName(shiftType);
						series1.getData().add(new XYChart.Data<String, Integer>(key, nightshiftcounter));
					} else if (shiftType.equalsIgnoreCase("D")) {
						dayshiftcounter++;
						series6.setName(shiftType);
						series6.getData().add(new XYChart.Data<String, Integer>(key, dayshiftcounter));

					} else if (shiftType.equalsIgnoreCase("L")) {
						lateshiftcounter++;
						series2.setName(shiftType);
						series2.getData().add(new XYChart.Data<String, Integer>(key, lateshiftcounter));

					} else if (shiftType.equalsIgnoreCase("LC")) {
						lcshiftcounter++;
						series3.setName(shiftType);
						series3.getData().add(new XYChart.Data<String, Integer>(key, lcshiftcounter));

					} else if (shiftType.equalsIgnoreCase("ADO")) {
						adocounter++;
						series4.setName(shiftType);
						series4.getData().add(new XYChart.Data<String, Integer>(key, adocounter));

					} else if (shiftType.equalsIgnoreCase("leave")) {
						leavecounter++;
						series5.setName(shiftType);
						series5.getData().add(new XYChart.Data<String, Integer>(key, leavecounter));

					} else if (shiftType.equalsIgnoreCase("WLC")) {
						wlccounter++;
						series7.setName(shiftType);
						series7.getData().add(new XYChart.Data<String, Integer>(key, wlccounter));

					}else if (shiftType.equalsIgnoreCase("training")) {
						trainingcounter++;
						series8.setName(shiftType);
						series8.getData().add(new XYChart.Data<String, Integer>(key, trainingcounter));

					}

				}
			}
		}
		shiftviewChart.getData().add(series);
		shiftviewChart.getData().add(series1);
		shiftviewChart.getData().add(series2);
		shiftviewChart.getData().add(series3);
		shiftviewChart.getData().add(series4);
		shiftviewChart.getData().add(series5);
		shiftviewChart.getData().add(series6);
		shiftviewChart.getData().add(series7);
		shiftviewChart.getData().add(series8);
		svxAxis.setCategories(employees);

	}
	@FXML
	void handleButtonClicks(ActionEvent event) {
		if (event.getSource() == mainmenue) {
		Stage dialogStage = (Stage) mainmenue.getScene().getWindow();
			dialogStage.close();
		
		}
	}
		
	
}