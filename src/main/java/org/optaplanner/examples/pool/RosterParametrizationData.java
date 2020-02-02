package org.optaplanner.examples.pool;

import java.time.LocalDate;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class RosterParametrizationData {
	
@GeneratedValue
private int id;
private LocalDate startDate;
private LocalDate endDate;
private String Code;


	@Id

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}

}


