/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.examples.nurserostering.domain;

import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.ManyToOne;

import javax.persistence.MapKey;

import javax.persistence.OneToMany;

import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.common.swingui.components.Labeled;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;

import org.optaplanner.examples.nurserostering.domain.request.DayOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.DayOnRequest;
import org.optaplanner.examples.nurserostering.domain.request.HolidayRequest;
import org.optaplanner.examples.nurserostering.domain.request.LeaveRequest;
import org.optaplanner.examples.nurserostering.domain.request.RosterDay;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOnRequest;
import org.optaplanner.examples.nurserostering.domain.request.TrainingRequest;

@Entity(name = "Employee")
@XStreamAlias("Employee")
public class Employee extends AbstractPersistable implements Labeled {

	private String employeeId;
	private String code;
	private String name;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Contract contract;

	private String streetnum;
	private String address;
	private String suburb;
	private String postcode;
	private String contactdetails;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapKey(name = "id")
	private Map<ShiftDate, DayOffRequest> dayOffRequestMap;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapKey(name = "id")
	private Map<ShiftDate, DayOnRequest> dayOnRequestMap;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapKey(name = "id")
	private Map<Shift, ShiftOffRequest> shiftOffRequestMap;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapKey(name = "id")
	private Map<Shift, ShiftOnRequest> shiftOnRequestMap;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapKey(name = "id")
	private Map<ShiftDate, HolidayRequest> holidayRequestMap;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapKey(name = "id")
	private Map<Shift, RosterDay> rosterdayMap;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @MapKey(name = "id") 
	 private Map<Shift, LeaveRequest> leaveMap;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @MapKey(name = "id") 
	 private Map<Shift, TrainingRequest> trainingRequestMap;
	 

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public int getWeekendLength() {
		return getContract().getWeekendLength();
	}

	public Map<ShiftDate, DayOffRequest> getDayOffRequestMap() {
		return dayOffRequestMap;
	}

	public void setDayOffRequestMap(
			Map<ShiftDate, DayOffRequest> dayOffRequestMap) {
		this.dayOffRequestMap = dayOffRequestMap;
	}

	public Map<ShiftDate, DayOnRequest> getDayOnRequestMap() {
		return dayOnRequestMap;
	}

	public void setDayOnRequestMap(
			Map<ShiftDate, DayOnRequest> dayOnRequestMap) {
		this.dayOnRequestMap = dayOnRequestMap;
	}

	public Map<Shift, ShiftOffRequest> getShiftOffRequestMap() {
		return shiftOffRequestMap;
	}

	public void setShiftOffRequestMap(
			Map<Shift, ShiftOffRequest> shiftOffRequestMap) {
		this.shiftOffRequestMap = shiftOffRequestMap;
	}

	public Map<Shift, ShiftOnRequest> getShiftOnRequestMap() {
		return shiftOnRequestMap;
	}

	public void setShiftOnRequestMap(
			Map<Shift, ShiftOnRequest> shiftOnRequestMap) {
		this.shiftOnRequestMap = shiftOnRequestMap;
	}

	public Map<ShiftDate, HolidayRequest> getHolidayRequestMap() {
		return holidayRequestMap;
	}

	public void setHolidayRequestMap(
			Map<ShiftDate, HolidayRequest> holidayRequestMap) {
		this.holidayRequestMap = holidayRequestMap;
	}

	

	public Map<Shift, RosterDay> getRosterdayMap() {
		return rosterdayMap;
	}

	public void setRosterdayMap(Map<Shift, RosterDay> rosterdayMap) {
		this.rosterdayMap = rosterdayMap;
	}



	public Map<Shift, LeaveRequest> getLeaveMap() {
		return leaveMap;
	}

	public void setLeaveMap(Map<Shift, LeaveRequest> leaveMap) {
		this.leaveMap = leaveMap;
	}

	public Map<Shift, TrainingRequest> getTrainingRequestMap() {
		return trainingRequestMap;
	}

	public void setTrainingRequestMap(Map<Shift, TrainingRequest> trainingRequestMap) {
		this.trainingRequestMap = trainingRequestMap;
	}

	public String getStreetnum() {
		return streetnum;
	}

	public void setStreetnum(String streetnum) {
		this.streetnum = streetnum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getContactdetails() {
		return contactdetails;
	}

	public void setContactdetails(String contactdetails) {
		this.contactdetails = contactdetails;
	}

	@Override
	public String getLabel() {
		return name;
	}

	@Override
	public String toString() {
		if (name == null) {
			return super.toString();
		}
		return name;
	}

}
