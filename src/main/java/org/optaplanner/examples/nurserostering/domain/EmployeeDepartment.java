package org.optaplanner.examples.nurserostering.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

@Entity
public class EmployeeDepartment extends AbstractPersistable implements Comparable<EmployeeDepartment>{
	private static final Comparator<EmployeeDepartment> COMPARATOR = Comparator.comparing(EmployeeDepartment::getEmployee).thenComparing(EmployeeDepartment::getDepartment);
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final EmployeeDepartment other = (EmployeeDepartment) o;
		return Objects.equals(employee, other.employee) && Objects.equals(department, other.department);
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee, department);
	}

	@Override
	public int compareTo(EmployeeDepartment other) {
		return COMPARATOR.compare(this, other);
	}
	
    @Override
    public String toString() {
        return employee + "-" + department;
    }

}
