package org.optaplanner.examples.nurserostering.domain.request;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

@Entity
public class RosterDay extends AbstractPersistable {
 private int weight;
	@ManyToOne(cascade = CascadeType.MERGE)
    private Employee employee;
	@ManyToOne(cascade = CascadeType.MERGE)
	private ShiftDate shiftDate;
    @ManyToOne(cascade = CascadeType.MERGE)
	private ShiftType shiftType;
	@ManyToOne(cascade = CascadeType.MERGE)
   	private Shift shift;
       
    	

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

	public ShiftDate getShiftDate() {
		return shiftDate;
	}

	public void setShiftDate(ShiftDate shiftDate) {
		this.shiftDate = shiftDate;
	}

	public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	
 

}
