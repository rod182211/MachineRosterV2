package org.optaplanner.examples.pool;
import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Employee;



@Entity(name = "DayOffDate")

public class DayOffDate extends AbstractPersistable{
	private int weight;
	@ManyToOne
	private Employee employee;
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
