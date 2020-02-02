package org.optaplanner.examples.nurserostering.domain;

import java.time.DayOfWeek;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import org.optaplanner.examples.common.domain.AbstractPersistable;


@Entity
public class CoverRequirements extends AbstractPersistable {
	


	private DayOfWeek dayOfWeek;
 
	private int requiredEmployeesize;


	@ManyToOne
	private ShiftType shiftType;	
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getRequiredEmployeesize() {
		return requiredEmployeesize;
	}
	public void setRequiredEmployeesize(int requiredEmployeesize) {
		this.requiredEmployeesize = requiredEmployeesize;
	}
	public ShiftType getShiftType() {
		return shiftType;
	}
	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	
	

}
