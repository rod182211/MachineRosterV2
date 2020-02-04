package org.optaplanner.examples.nurserostering.domain;

import java.util.Comparator;
import javax.persistence.Entity;


import javax.persistence.ManyToOne;
import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Department;

@Entity
public class ShiftTypeDepartmentRequirement extends AbstractPersistable  {

	
	@ManyToOne
	public ShiftType shiftType;

	@ManyToOne
	public Department department;


	public Department getDepartment() {
		return department;
	}
	public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}
	 


	public void setDepartment(Department department) {
		this.department = department;
	}

	
			  
	  @Override public String toString() { return shiftType + "-" + department; }





}
