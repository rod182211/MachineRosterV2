package org.optaplanner.examples.pool;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.ShiftType;
@Entity(name = "LeaveData")
public class LeaveData extends AbstractPersistable{
	private int weight;

	@ManyToOne
	private Employee employee;
	private LocalDate startdate;
	private LocalDate enddate;
	@ManyToOne
	private ShiftType shiftType;
	


	

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	public int getWeight() {
		return weight;
	}

	

	public void setWeight(int weight) {
		this.weight = weight;
	}



}



