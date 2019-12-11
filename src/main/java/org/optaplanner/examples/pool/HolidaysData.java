package org.optaplanner.examples.pool;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.Employee;

@Entity(name = "HolidaysData")
public class HolidaysData extends AbstractPersistable{
   
    private int weight;
    @ManyToOne
    private Employee employee;
    private LocalDate startdate;
    private LocalDate enddate;
   
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public LocalDate getStartdate() {
        return startdate;
    }
    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }
    public LocalDate getEnddate() {
        return enddate;
    }
    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }
   

}

