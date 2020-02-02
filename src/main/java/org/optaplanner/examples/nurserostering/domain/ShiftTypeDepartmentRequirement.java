package org.optaplanner.examples.nurserostering.domain;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

import javax.persistence.Entity;


import javax.persistence.ManyToOne;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Department;

@Entity
public class ShiftTypeDepartmentRequirement extends AbstractPersistable implements Comparable<ShiftTypeDepartmentRequirement>  {

	private static final Comparator<ShiftTypeDepartmentRequirement> COMPARATOR = Comparator.comparing(ShiftTypeDepartmentRequirement::getShiftType).thenComparing(ShiftTypeDepartmentRequirement::getDepartment);

	@ManyToOne
	public ShiftType shiftType;

	@ManyToOne
	public Department department;


	public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	@Override
	public int compareTo(ShiftTypeDepartmentRequirement other) {
		return COMPARATOR.compare(this, other);
	}


		  
	  @Override public String toString() { return shiftType + "-" + department; }
	 

}
