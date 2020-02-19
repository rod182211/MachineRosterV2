package org.optaplanner.examples.nurserostering.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.optaplanner.examples.common.domain.AbstractPersistable;
@Entity
public class EmployeeMachine extends AbstractPersistable {

	 @ManyToOne
	private Employee employee;

    @ManyToOne
	private Machine machine;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
	

}
