package org.optaplanner.examples.pool;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;

import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.ShiftType;
@Entity(name = "ShiftOnDate")
public class ShiftOnDate extends AbstractPersistable{

	
	

	private int weight;
   
	@ManyToOne
	private Employee employee;
	@ManyToOne
	private ShiftType shiftType;
    private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
