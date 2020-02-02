package org.optaplanner.examples.nurserostering.solver.drools;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

public class EmployeeEarlyWorkSequence implements Comparable<EmployeeEarlyWorkSequence>, Serializable {

    private static final Comparator<EmployeeEarlyWorkSequence> COMPARATOR =
            Comparator.comparing(EmployeeEarlyWorkSequence::getEmployee)
            		.thenComparing(EmployeeEarlyWorkSequence::getShiftType)
                    .thenComparingInt(EmployeeEarlyWorkSequence::getFirstDayIndex)
                    .thenComparingInt(EmployeeEarlyWorkSequence::getLastDayIndex);

    private Employee employee;
    private ShiftType shiftType;
    private int firstDayIndex;
    private int lastDayIndex;

    public EmployeeEarlyWorkSequence(Employee employee, ShiftType shiftType, int firstDayIndex, int lastDayIndex) {
        this.employee = employee;
        this.shiftType = shiftType;
        this.firstDayIndex = firstDayIndex;
        this.lastDayIndex = lastDayIndex;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getFirstDayIndex() {
        return firstDayIndex;
    }

    public void setFirstDayIndex(int firstDayIndex) {
        this.firstDayIndex = firstDayIndex;
    }

    public int getLastDayIndex() {
        return lastDayIndex;
    }

    public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	public void setLastDayIndex(int lastDayIndex) {
        this.lastDayIndex = lastDayIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final EmployeeEarlyWorkSequence other = (EmployeeEarlyWorkSequence) o;
        return Objects.equals(employee, other.employee) && (shiftType == other.shiftType)&&
                firstDayIndex == other.firstDayIndex && 
                lastDayIndex == other.lastDayIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, shiftType, firstDayIndex, lastDayIndex);
    }

    @Override
    public int compareTo(EmployeeEarlyWorkSequence other) {
        return COMPARATOR.compare(this, other);
    }

    @Override
    public String toString() {
        return employee + " is working between " + firstDayIndex + " - " + lastDayIndex;
    }

    public int getDayLength() {
        return lastDayIndex - firstDayIndex + 1;
    }

}
