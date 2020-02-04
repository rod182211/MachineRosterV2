package org.optaplanner.examples.nurserostering.domain.pattern;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

import com.thoughtworks.xstream.annotations.XStreamAlias;


	
	@Entity
	@DiscriminatorValue(value ="WorkEarly")  
	@XStreamAlias("WorkEarlyPattern")
	public class WorkEarlyPattern extends Pattern {


		@ManyToOne
		private Employee employee;

		@ManyToOne
		private ShiftType workShiftType; // null means any
		
	
		private int shiftLength;

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		public ShiftType getWorkShiftType() {
			return workShiftType;
		}

		public void setWorkShiftType(ShiftType workShiftType) {
			this.workShiftType = workShiftType;
		}

		public int getShiftLength() {
			return shiftLength;
		}

		public void setShiftLength(int shiftLength) {
			this.shiftLength = shiftLength;
		}

	   

	}
