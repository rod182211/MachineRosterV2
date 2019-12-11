package org.optaplanner.examples.view;

import java.net.URL;
import java.time.LocalDate;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.ResourceBundle;

import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.pool.CalendarData;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;

import com.calendarfx.model.Calendar.Style;
import com.calendarfx.view.CalendarView;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class CalendarController<CalendarEvent> implements Initializable {
    private Stage primaryStage;
	private RosterService rosterService = new RosterServiceImpl();
	private ObservableList<CalendarData> calendarList = FXCollections.observableArrayList();

	public ObservableList<CalendarData> getCalendarDataList() {
		if (!calendarList.isEmpty())
			calendarList.clear();
		calendarList = FXCollections.observableList((List<CalendarData>) rosterService.listCalendarData());
		return calendarList;
	}

	//@Override
	public void start(Stage primaryStage) throws Exception {

		CalendarView calendarView = new CalendarView();
		Calendar shifts = new Calendar("ShiftRoster");
		shifts.setStyle(Style.STYLE2);
		//ZoneId id = ZoneId.of("Australia/Brisbane");

		getCalendarDataList();
		for (CalendarData task : calendarList) {
			Entry<String> shiftdetails = new Entry<>(task.getEmployeename());
			String startTime = task.getStartTIme();
			String endTime = task.getEndTime();
			LocalDate date = task.getShiftDate();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm:ss");
			LocalTime start = LocalTime.parse(startTime, dtf);
			LocalTime end = LocalTime.parse(endTime, dtf);

			if (!start.isAfter(end)) {
				shiftdetails.setInterval(date);
				shiftdetails.setInterval(start, end);
				shifts.addEntry(shiftdetails);
			}
			if (!end.isAfter(start)) {
				shiftdetails.setInterval(date);
				shiftdetails.setInterval(date, start, date.plusDays(1), end);
				shifts.addEntry(shiftdetails);
			}
		}

		CalendarSource calendarSourceTasks = new CalendarSource("Shifts");
		calendarSourceTasks.getCalendars().addAll(shifts);
		calendarView.getCalendarSources().setAll(calendarSourceTasks);

		Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
			@Override
			public void run() {
				while (true) {
					Platform.runLater(() -> {
						calendarView.setToday(LocalDate.now());
						calendarView.setTime(LocalTime.now());
					});

					try {
						// update every 10 seconds
						sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			};
		};

		updateTimeThread.setPriority(Thread.MIN_PRIORITY);
		updateTimeThread.setDaemon(true);
		updateTimeThread.start();
		Scene scene = new Scene(calendarView);
		primaryStage.setTitle("Calendar");
		primaryStage.setScene(scene);
		primaryStage.setWidth(1300);
		primaryStage.setHeight(1000);
		primaryStage.centerOnScreen();
	    primaryStage.show();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
	}
}