package org.optaplanner.examples.nurserostering.domain.request;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;



@Entity
public class HolidayRequest extends AbstractPersistable {


	@ManyToOne
	private Employee employee;

	@ManyToOne
	private ShiftDate startshiftDate;

	@ManyToOne
	private ShiftDate endshiftDate;

    private int weight;

  
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

	

   

}
