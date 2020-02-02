package org.optaplanner.examples.nurserostering.domain.request;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

@Entity
public class LeaveRequest extends AbstractPersistable {


    @ManyToOne
	private Employee employee;

	@ManyToOne
	private ShiftDate startshiftDate;

	@ManyToOne
	private ShiftDate endshiftDate;

    @ManyToOne
	private ShiftType shiftType;
   
    @ManyToOne
	private Shift shift;
    
    public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	private int weight;

	public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public ShiftDate getStartshiftDate() {
		return startshiftDate;
	}

	public void setStartshiftDate(ShiftDate startshiftDate) {
		this.startshiftDate = startshiftDate;
	}

	public ShiftDate getEndshiftDate() {
		return endshiftDate;
	}

	public void setEndshiftDate(ShiftDate endshiftDate) {
		this.endshiftDate = endshiftDate;
	}

	public int getWeight() {
        return weight;
    }
 	
	public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	public void setWeight(int weight) {
        this.weight = weight;
    }

	/*
	 * @Override public String toString() { return shiftDate + "_ON_" + employee; }
	 */
}
