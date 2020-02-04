package org.optaplanner.examples.nurserostering.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import java.util.Comparator;
import java.util.Objects;

@Entity
public class EmployeeDepartment extends AbstractPersistable {
	//private static final Comparator<EmployeeDepartment> COMPARATOR = Comparator.comparing(EmployeeDepartment::getEmployee).thenComparing(EmployeeDepartment::getDepartment);
 	@ManyToOne
	private Employee employee;
    @ManyToOne
	private Department department;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
    @Override
    public String toString() {
        return employee + "-" + department;
    }

}
