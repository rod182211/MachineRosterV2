package org.optaplanner.examples.nurserostering.domain;


import javax.persistence.Entity;


import javax.persistence.ManyToOne;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Machine;

@Entity
public class ShiftTypeMachineRequirement extends AbstractPersistable  {

	
	@ManyToOne
	public ShiftType shiftType;

	@ManyToOne
	public Machine machine;
	
	public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}
	 			  
	 public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	@Override public String toString() { return shiftType + "-" + machine; }





}
