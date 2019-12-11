package org.optaplanner.examples.pool;

import java.time.LocalDate;

import javax.persistence.Entity;

import org.optaplanner.examples.common.domain.AbstractPersistable;
@Entity
public class CalendarData extends AbstractPersistable{
	
private String employeename;
private String shiftType;
private boolean isNight;
private String shiftDescription;
private String startTIme;
private String endTime;
private LocalDate shiftDate;
public String getShiftType() {
	return shiftType;
}
public void setShiftType(String shiftType) {
	this.shiftType = shiftType;
}

public boolean isNight() {
	return isNight;
}
public void setNight(boolean isNight) {
	this.isNight = isNight;
}
public String getShiftDescription() {
	return shiftDescription;
}
public void setShiftDescription(String shiftDescription) {
	this.shiftDescription = shiftDescription;
}
public String getStartTIme() {
	return startTIme;
}
public void setStartTIme(String startTIme) {
	this.startTIme = startTIme;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public String getEmployeename() {
	return employeename;
}
public void setEmployeename(String employeename) {
	this.employeename = employeename;
}
public LocalDate getShiftDate() {
	return shiftDate;
}
public void setShiftDate(LocalDate shiftDate) {
	this.shiftDate = shiftDate;
}


}
