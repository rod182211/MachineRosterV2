package org.optaplanner.examples.nurserostering.domain.request;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

@Entity
public class TrainingRequest extends AbstractPersistable {


	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private ShiftDate shiftDate;
  
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


	public ShiftDate getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(ShiftDate shiftDate) {
        this.shiftDate = shiftDate;
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

    @Override
    public String toString() {
        return shiftDate + "_ON_" + employee;
    }

}
