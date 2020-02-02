package org.optaplanner.database;

import java.util.List;

import org.optaplanner.examples.nurserostering.domain.*;
import org.optaplanner.examples.nurserostering.domain.contract.*;
import org.optaplanner.examples.nurserostering.domain.pattern.*;
import org.optaplanner.examples.pool.CalendarData;
import org.optaplanner.examples.pool.DayOffDate;
import org.optaplanner.examples.pool.DayOnDate;
import org.optaplanner.examples.pool.ShiftOnDate;
import org.optaplanner.examples.pool.TrainingData;

import javafx.collections.ObservableList;

import org.optaplanner.examples.pool.ShiftOffDate;
import org.optaplanner.examples.pool.HolidaysData;
import org.optaplanner.examples.pool.LeaveData;
import org.optaplanner.examples.pool.RosterDayOff;
import org.optaplanner.examples.pool.RosterParametrizationData;
import org.optaplanner.examples.nurserostering.domain.request.DayOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.DayOnRequest;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOnRequest;

public class RosterServiceImpl implements RosterService {

	private RosterDAO rosterDAO = new RosterDAOImpl();
	@Override
	public List<ShiftType2DaysPattern> listShiftType2DaysPatterncode() {
		return rosterDAO.listShiftType2DaysPatterncode();
	}

	@Override
	public void removeShiftType2DaysPattern(ShiftType2DaysPattern itemsSelected) {
		rosterDAO.removeShiftType2DaysPattern(itemsSelected);
	}
	@Override
	public void updateShiftType2DaysPattern(ShiftType2DaysPattern shift2daydata) {
		rosterDAO.updateShiftType2DaysPattern(shift2daydata);
	}

	@Override
	public void addShiftType2DaysPattern(ShiftType2DaysPattern shift2daydata) {
		rosterDAO.addShiftType2DaysPattern(shift2daydata);
	}
	@Override
	public List<ShiftType2DaysPattern> listShiftType2DaysPattern() {
		return rosterDAO.listShiftType2DaysPattern();
	}
	@Override
	public List<ShiftType2DaysPattern> listShiftType2DaysPatternId() {
		return rosterDAO.listShiftType2DaysPatternId();
	}
	@Override
	public void addEmployee(Employee employee) {
		rosterDAO.addEmployee(employee);
	}

	@Override
	public List<Employee> listEmployee() {
		return rosterDAO.listEmployee();
	}
	
	@Override
	public void removeEmployee(ObservableList<Employee> itemsSelected) {
		rosterDAO.removeEmployee(itemsSelected);
	}

	@Override
	public void updateEmployee(Employee employee) {
		rosterDAO.updateEmployee(employee);
	}

	@Override
	public void insertEmployee(Employee employee) {
		rosterDAO.insertEmployee(employee);
	}
	@Override
	public List<Employee> listEmployeeId(long empid) {
		return rosterDAO.listEmployeeId(empid);
	}
	@Override
	public List<Employee> listEmployeename() {
		return rosterDAO.listEmployeename();
	}
	@Override
	public List<Pattern> listPattern() {
		return rosterDAO.listPattern();
	}
	
	@Override
	public void removePattern(ObservableList<Pattern> itemsSelected) {
		rosterDAO.removePattern(itemsSelected);
	}
	
	@Override
	public void deletePattern(Pattern itemsSelected) {
		rosterDAO.deletePattern(itemsSelected);
	}
	@Override
	public List<Pattern> listPatterncode() {
		return rosterDAO.listPatterncode();
	}

	@Override
	public void updatePattern(Pattern pattern) {
		rosterDAO.updatePattern(pattern);
	}

	@Override
	public void addPattern(Pattern pattern) {
		rosterDAO.addPattern(pattern);
	}
	@Override
	public List<Pattern> listPatternId() {
		return rosterDAO.listPatternId();
	}

	@Override
	public void addSkill(Skill skills) {
		rosterDAO.addSkill(skills);
	}

	@Override
	public List<Skill> listSkillId() {
		return rosterDAO.listSkillId();
	}

	@Override
	public List<Skill> listSkillcode() {
		return rosterDAO.listSkillcode();
	}

	@Override
	public List<Skill> listSkill() {
		return rosterDAO.listSkill();
	}

	@Override
	public void removeSkill(ObservableList<Skill> itemsSelected) {
		rosterDAO.removeSkill(itemsSelected);
	}

	@Override
	public void updateSkill(Skill skills) {
		rosterDAO.updateSkill(skills);
	}

	@Override
	public List<Contract> listContract() {
		return rosterDAO.listContract();
	}

	@Override
	public void addContract(Contract contract) {
		rosterDAO.addContract(contract);
	}

	@Override
	public List<Contract> listContractId() {
		return rosterDAO.listContractId();
	}

	@Override
	public void removeContract(ObservableList<Contract> itemsSelected) {
		rosterDAO.removeContract(itemsSelected);
	}

	@Override
	public void updateContract(Contract contract) {
		rosterDAO.updateContract(contract);
	}

	@Override
	public List<Contract> listContractcode() {
		return rosterDAO.listContractcode();
	}

	@Override
	public void addRosterParametrizationData(RosterParametrizationData scheddates) {
		rosterDAO.addRosterParametrizationData(scheddates);
	}

	@Override
	public List<RosterParametrizationData> listRosterParametrizationData() {
		return rosterDAO.listRosterParametrizationData();
	}

	@Override
	public void removeRosterParametrizationData(ObservableList<RosterParametrizationData> itemsSelected) {
		rosterDAO.removeRosterParametrizationData(itemsSelected);
	}

	@Override
	public void updateRosterParametrizationData(RosterParametrizationData scheddates) {
		rosterDAO.updateRosterParametrizationData(scheddates);
	}

	


	@Override
	public List<BooleanContractLine> listBooleanContractLine() {
		return rosterDAO.listBooleanContractLine();
	}

	@Override
	public void addBooleanContractLine(BooleanContractLine booleandata) {
		rosterDAO.addBooleanContractLine(booleandata);
	}

	@Override
	public List<BooleanContractLine> listBooleanContractLineId() {
		return rosterDAO.listBooleanContractLineId();
	}

	@Override
	public void removeBooleanContractLine(ObservableList<BooleanContractLine> itemsSelected) {
		rosterDAO.removeBooleanContractLine(itemsSelected);
	}

	@Override
	public void updateBooleanContractLine(BooleanContractLine booleandata) {
		rosterDAO.updateBooleanContractLine(booleandata);
	}
	@Override
	public List<MinMaxContractLine> listMinMaxContractLine() {
		return rosterDAO.listMinMaxContractLine();
	}

	@Override
	public void addMinMaxContractLine(MinMaxContractLine minmaxdata) {
		rosterDAO.addMinMaxContractLine(minmaxdata);
	}

	@Override
	public List<MinMaxContractLine> listMinMaxContractLineId() {
		return rosterDAO.listMinMaxContractLineId();
	}

	@Override
	public void removeMinMaxContractLine(ObservableList<MinMaxContractLine> itemsSelected) {
		rosterDAO.removeMinMaxContractLine(itemsSelected);
	}

	@Override
	public void updateMinMaxContractLine(MinMaxContractLine minmaxdata) {
		rosterDAO.updateMinMaxContractLine(minmaxdata);
	}

	
	
	@Override
	public List<PatternContractLine> listPatternContractLine() {
		return rosterDAO.listPatternContractLine();
	}

	@Override
	public void addPatternContractLine(PatternContractLine patterndata) {
		rosterDAO.addPatternContractLine(patterndata);
	}

	@Override
	public List<PatternContractLine> listPatternContractLineId() {
		return rosterDAO.listPatternContractLineId();
	}
	@Override
	public List<PatternContractLine> listPatternContractLinecode() {
		return rosterDAO.listPatternContractLinecode();
	}

	@Override
	public void removePatternContractLine(ObservableList<PatternContractLine> itemsSelected) {
		rosterDAO.removePatternContractLine(itemsSelected);
	}

	@Override
	public void updatePatternContractLine(PatternContractLine patterndata) {
		rosterDAO.updatePatternContractLine(patterndata);
	}
	@Override
	public void deletePatternContractLine(PatternContractLine patterndata) {
		rosterDAO.deletePatternContractLine(patterndata);
	}
	@Override
	public List<DayOnRequest> listDayOnRequest() {
		return rosterDAO.listDayOnRequest();
	}

	@Override
	public void addDayOnRequest(DayOnRequest dayondata) {
		rosterDAO.addDayOnRequest(dayondata);
	}

	@Override
	public List<DayOnRequest> listDayOnRequestId() {
		return rosterDAO.listDayOnReqestDataId();
	}

	@Override
	public void removeDayOnRequest(ObservableList<DayOnRequest> itemsSelected) {
		rosterDAO.removeDayOnRequest(itemsSelected);
	}

	@Override
	public void updateDayOnRequest(DayOnRequest dayondata) {
		rosterDAO.updateDayOnRequest(dayondata);
	}
	
	@Override
	public List<DayOffRequest> listDayOffRequest() {
		return rosterDAO.listDayOffRequest();
	}

	@Override
	public void addDayOffRequest(DayOffRequest dayoffdata) {
		rosterDAO.addDayOffRequest(dayoffdata);
	}

	@Override
	public List<DayOffRequest> listDayOffRequestId() {
		return rosterDAO.listDayOffRequestId();
	}

	@Override
	public void removeDayOffRequest(ObservableList<DayOffRequest> itemsSelected) {
		rosterDAO.removeDayOffRequest(itemsSelected);
	}

	@Override
	public void updateDayOffRequest(DayOffRequest dayoffdata) {
		rosterDAO.updateDayOffRequest(dayoffdata);
	}
	
	
	@Override
	public List<ShiftOnRequest> listShiftOnRequest() {
		return rosterDAO.listShiftOnRequest();
	}

	@Override
	public void addShiftOnRequest(ShiftOnRequest shiftondata) {
		rosterDAO.addShiftOnRequest(shiftondata);
	}

	@Override
	public List<ShiftOnRequest> listShiftOnRequestId() {
		return rosterDAO.listShiftOnRequestId();
	}

	@Override
	public void removeShiftOnRequest(ObservableList<ShiftOnRequest> itemsSelected) {
		rosterDAO.removeShiftOnRequest(itemsSelected);
	}

	@Override
	public void updateShiftOnRequest(ShiftOnRequest shiftondata) {
		rosterDAO.updateShiftOnRequest(shiftondata);
	}
	
	@Override
	public List<ShiftOffRequest> listShiftOffRequest() {
		return rosterDAO.listShiftOffRequest();
	}

	@Override
	public void addShiftOffRequest(ShiftOffRequest shiftoffdata) {
		rosterDAO.addShiftOffRequest(shiftoffdata);
	}

	@Override
	public List<ShiftOffRequest> listShiftOffRequestId() {
		return rosterDAO.listShiftOffRequestId();
	}

	@Override
	public void removeShiftOffRequest(ObservableList<ShiftOffRequest> itemsSelected) {
		rosterDAO.removeShiftOffRequest(itemsSelected);
	}

	@Override
	public void updateShiftOffRequest(ShiftOffRequest shiftoffdata) {
		rosterDAO.updateShiftOffRequest(shiftoffdata);
	}
	@Override
	public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePattern() {
		return rosterDAO.listWorkBeforeFreeSequencePattern();
	}

	@Override
	public void addWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern workbeforedata) {
		rosterDAO.addWorkBeforeFreeSequencePattern(workbeforedata);
	}

	@Override
	public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePatternId() {
		return rosterDAO.listWorkBeforeFreeSequencePatternId();
	}
	@Override
	public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePatterncode() {
		return rosterDAO.listWorkBeforeFreeSequencePatterncode();
	}

	@Override
	public void removeWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern itemsSelected) {
		rosterDAO.removeWorkBeforeFreeSequencePattern(itemsSelected);
	}

	@Override
	public void updateWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern workbeforedata) {
		rosterDAO.updateWorkBeforeFreeSequencePattern(workbeforedata);
	}
	
	
	@Override
	public void updateShiftType3DaysPattern(ShiftType3DaysPattern shift3daydata) {
		rosterDAO.updateShiftType3DaysPattern(shift3daydata);
	}
	@Override
	public void addShiftType3DaysPattern(ShiftType3DaysPattern shift3daydata) {
		rosterDAO.addShiftType3DaysPattern(shift3daydata);
	}

	@Override
	public List<ShiftType3DaysPattern> listShiftType3DaysPatternId() {
		return rosterDAO.listShiftType3DaysPatternId();
	}
	@Override
	public List<ShiftType3DaysPattern> listShiftType3DaysPattern() {
		return rosterDAO.listShiftType3DaysPattern();
	}
	@Override
	public void removeShiftType3DaysPattern(ShiftType3DaysPattern itemsSelected) {
		rosterDAO.removeShiftType3DaysPattern(itemsSelected);
	}

	@Override
	public void updateFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern freeday) {
		rosterDAO.updateFreeBefore2DaysWithAWorkDayPattern(freeday);
	}
	@Override
	public List<FreeBefore2DaysWithAWorkDayPattern> listFreeBefore2DaysWithAWorkDayPattern() {
		return rosterDAO.listFreeBefore2DaysWithAWorkDayPattern();
	}

	@Override
	public void addFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern freeday) {
		rosterDAO.addFreeBefore2DaysWithAWorkDayPattern(freeday);
	}

	@Override
	public List<FreeBefore2DaysWithAWorkDayPattern> listFreeBefore2DaysWithAWorkDayPatternId() {
		return rosterDAO.listFreeBefore2DaysWithAWorkDayPatternId();
	}

	@Override
	public void removeFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern itemsSelected) {
		rosterDAO.removeFreeBefore2DaysWithAWorkDayPattern(itemsSelected);
	}
	@Override
	public void addContractLine(ContractLine contractline) {
		rosterDAO.addContractLine(contractline);
	}

	@Override
	public List<ContractLine> listContractLine() {
		return rosterDAO.listContractLine();
	}
	@Override
	public List<ContractLine> listContractLinecode() {
		return rosterDAO.listContractLinecode();
	}
	
	@Override
	public void removeContractLine(ObservableList<ContractLine> itemsSelected) {
		rosterDAO.removeContractLine(itemsSelected);
	}

	@Override
	public void updateContractLine(ContractLine employee) {
		rosterDAO.updateContractLine(employee);
	}

	@Override
	public List<ContractLine> listContractLineId() {
		return rosterDAO.listContractLineId();
	}
	@Override
	public void addShiftType(ShiftType shifttype) {
		rosterDAO.addShiftType(shifttype);
	}

	@Override
	public List<ShiftType> listShiftTypeId() {
		return rosterDAO.listShiftTypeId();
	}

	@Override
	public List<ShiftType> listShiftTypecode() {
		return rosterDAO.listShiftTypecode();
	}

	@Override
	public List<ShiftType> listShiftType() {
		return rosterDAO.listShiftType();
	}

	@Override
	public void removeShiftType(ObservableList<ShiftType> itemsSelected) {
		rosterDAO.removeShiftType(itemsSelected);
	}

	@Override
	public void updateShiftType(ShiftType shiftype) {
		rosterDAO.updateShiftType(shiftype);
	}
	@Override
	public void addShiftTypeSkillRequirement(ShiftTypeSkillRequirement skillrequirement) {
		rosterDAO.addShiftTypeSkillRequirement(skillrequirement);
	}

	@Override
	public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirement() {
		return rosterDAO.listShiftTypeSkillRequirement();
	}
	@Override
	public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirementday() {
		return rosterDAO.listShiftTypeSkillRequirementday();
	}
	
	@Override
	public void removeShiftTypeSkillRequirement(ObservableList<ShiftTypeSkillRequirement> itemsSelected) {
		rosterDAO.removeShiftTypeSkillRequirement(itemsSelected);
	}

	@Override
	public void updateShiftTypeSkillRequirement(ShiftTypeSkillRequirement skillrequirement) {
		rosterDAO.updateShiftTypeSkillRequirement(skillrequirement);
	}

	@Override
	public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirementId() {
		return rosterDAO.listShiftTypeSkillRequirementId();
	}

	@Override
	public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirementcode() {
		return rosterDAO.listShiftTypeSkillRequirementcode();
	}
	@Override
	public void addSkillProficiency(SkillProficiency skillprof) {
		rosterDAO.addSkillProficiency(skillprof);
	}

	@Override
	public List<SkillProficiency> listSkillProficiency() {
		return rosterDAO.listSkillProficiency();
	}
	
	@Override
	public void removeSkillProficiency(ObservableList<SkillProficiency> itemsSelected) {
		rosterDAO.removeSkillProficiency(itemsSelected);
	}

	@Override
	public void updateSkillProficiency(SkillProficiency skillprof) {
		rosterDAO.updateSkillProficiency(skillprof);
	}

	@Override
	public void insertSkillProficiency(SkillProficiency skillprof) {
		rosterDAO.insertSkillProficiency(skillprof);
	}
	@Override
	public List<SkillProficiency> listSkillProficiencyId() {
		return rosterDAO.listSkillProficiencyId();
	}
	@Override
	public List<SkillProficiency> listSkillProficiencyempId() {
		return rosterDAO.listSkillProficiencyempId();
	}
	@Override
	public List<SkillProficiency> listSkillProficiencycode() {
		return rosterDAO.listSkillProficiencycode();
	}
	@Override
	public void addShift(Shift shift) {
		rosterDAO.addShift(shift);
	}

	@Override
	public List<Shift> listShiftId() {
		return rosterDAO.listShiftId();
	}

	@Override
	public List<Shift> listShiftcode() {
		return rosterDAO.listShiftcode();
	}

	@Override
	public List<Shift> listShift() {
		return rosterDAO.listShift();
	}

	@Override
	public void removeShift(ObservableList<Shift> itemsSelected) {
		rosterDAO.removeShift(itemsSelected);
	}

	@Override
	public void updateShift(Shift shift) {
		rosterDAO.updateShift(shift);
	}
	@Override
	public void addShiftDate(ShiftDate shiftDate) {
		rosterDAO.addShiftDate(shiftDate);
	}

	@Override
	public List<ShiftDate> listShiftDateId() {
		return rosterDAO.listShiftDateId();
	}

	@Override
	public List<ShiftDate> listShiftDatecode() {
		return rosterDAO.listShiftDatecode();
	}

	@Override
	public List<ShiftDate> listShiftDate() {
		return rosterDAO.listShiftDate();
	}

	@Override
	public void removeShiftDate(ObservableList<ShiftDate> itemsSelected) {
		rosterDAO.removeShiftDate(itemsSelected);
	}

	@Override
	public void updateShiftDate(ShiftDate shiftDate) {
		rosterDAO.updateShiftDate(shiftDate);
	}
	@Override
	public void addCoverRequirements(CoverRequirements cover) {
		rosterDAO.addCoverRequirements(cover);
	}

	@Override
	public List<CoverRequirements> listCoverRequirementsId() {
		return rosterDAO.listCoverRequirementsId();
	}

	@Override
	public List<CoverRequirements> listCoverRequirementscode() {
		return rosterDAO.listCoverRequirementscode();
	}

	@Override
	public List<CoverRequirements> listCoverRequirements() {
		return rosterDAO.listCoverRequirements();
	}

	@Override
	public void removeCoverRequirements(ObservableList<CoverRequirements> itemsSelected) {
		rosterDAO.removeCoverRequirements(itemsSelected);
	}

	@Override
	public void updateCoverRequirements(CoverRequirements cover) {
		rosterDAO.updateCoverRequirements(cover);
	}
	@Override
	public List<ShiftAssignment> listShiftAssignment() {
		return rosterDAO.listShiftAssignment();
	}
	@Override
	public List<DayOffDate> listDayOffDate() {
		return rosterDAO.listDayOffDate();
	}

	@Override
	public void addDayOffDate(DayOffDate dayoffdata) {
		rosterDAO.addDayOffDate(dayoffdata);
	}

	@Override
	public List<DayOffDate> listDayOffDateId() {
		return rosterDAO.listDayOffDateId();
	}

	@Override
	public void removeDayOffDate(ObservableList<DayOffDate> itemsSelected) {
		rosterDAO.removeDayOffDate(itemsSelected);
	}

	@Override
	public void updateDayOffDate(DayOffDate dayoffdata) {
		rosterDAO.updateDayOffDate(dayoffdata);
	}
	
	@Override
	public List<DayOnDate> listDayOnDate() {
		return rosterDAO.listDayOnDate();
	}

	@Override
	public void addDayOnDate(DayOnDate dayondata) {
		rosterDAO.addDayOnDate(dayondata);
	}

	@Override
	public List<DayOnDate> listDayOnDateId() {
		return rosterDAO.listDayOnDateId();
	}

	@Override
	public void removeDayOnDate(ObservableList<DayOnDate> itemsSelected) {
		rosterDAO.removeDayOnDate(itemsSelected);
	}

	@Override
	public void updateDayOnDate(DayOnDate dayondata) {
		rosterDAO.updateDayOnDate(dayondata);
	}
	
	@Override
	public List<ShiftOnDate> listShiftOnDate() {
		return rosterDAO.listShiftOnDate();
	}

	@Override
	public void addShiftOnDate(ShiftOnDate shiftondata) {
		rosterDAO.addShiftOnDate(shiftondata);
	}

	@Override
	public List<ShiftOnDate> listShiftOnDateId() {
		return rosterDAO.listShiftOnDateId();
	}

	@Override
	public void removeShiftOnDate(ObservableList<ShiftOnDate> itemsSelected) {
		rosterDAO.removeShiftOnDate(itemsSelected);
	}

	@Override
	public void updateShiftOnDate(ShiftOnDate shiftondata) {
		rosterDAO.updateShiftOnDate(shiftondata);
	}
	
	@Override
	public List<ShiftOffDate> listShiftOffDate() {
		return rosterDAO.listShiftOffDate();
	}

	@Override
	public void addShiftOffDate(ShiftOffDate shiftoffdata) {
		rosterDAO.addShiftOffDate(shiftoffdata);
	}

	@Override
	public List<ShiftOffDate> listShiftOffDateId() {
		return rosterDAO.listShiftOffDateId();
	}

	@Override
	public void removeShiftOffDate(ObservableList<ShiftOffDate> itemsSelected) {
		rosterDAO.removeShiftOffDate(itemsSelected);
	}

	@Override
	public void updateShiftOffDate(ShiftOffDate shiftoffdata) {
		rosterDAO.updateShiftOffDate(shiftoffdata);
	}
	
	@Override
	public List<HolidaysData> listHolidaysData() {
		return rosterDAO.listHolidaysData();
	}

	@Override
	public void addHolidaysData(HolidaysData holidaydata) {
		rosterDAO.addHolidaysData(holidaydata);
	}

	@Override
	public List<HolidaysData> listHolidaysDataId() {
		return rosterDAO.listHolidaysDataId();
	}

	@Override
	public void removeHolidaysData(ObservableList<HolidaysData> itemsSelected) {
		rosterDAO.removeHolidaysData(itemsSelected);
	}

	@Override
	public void updateHolidaysData(HolidaysData holidaydata) {
		rosterDAO.updateHolidaysData(holidaydata);
	}
	
	@Override
	public List<RosterDayOff> listRosterDayOff() {
		return rosterDAO.listRosterDayOff();
	}

	@Override
	public void addRosterDayOff(RosterDayOff rdodata) {
		rosterDAO.addRosterDayOff(rdodata);
	}

	@Override
	public List<RosterDayOff> listRosterDayOffId() {
		return rosterDAO.listRosterDayOffId();
	}

	@Override
	public void removeRosterDayOff(ObservableList<RosterDayOff> itemsSelected) {
		rosterDAO.removeRosterDayOff(itemsSelected);
	}

	@Override
	public void updateRosterDayOff(RosterDayOff rdodata) {
		rosterDAO.updateRosterDayOff(rdodata);
	}
	
	@Override
	public List<LeaveData> listLeaveData() {
		return rosterDAO.listLeaveData();
	}

	@Override
	public void addLeaveData(LeaveData leavedata) {
		rosterDAO.addLeaveData(leavedata);
	}

	@Override
	public List<LeaveData> listLeaveDataId() {
		return rosterDAO.listLeaveDataId();
	}

	@Override
	public void removeLeaveData(ObservableList<LeaveData> itemsSelected) {
		rosterDAO.removeLeaveData(itemsSelected);
	}

	@Override
	public void updateLeaveData(LeaveData leavedata) {
		rosterDAO.updateLeaveData(leavedata);
	}
	
	@Override
	public List<TrainingData> listTrainingData() {
		return rosterDAO.listTrainingData();
	}

	@Override
	public void addTrainingData(TrainingData trainingdata) {
		rosterDAO.addTrainingData(trainingdata);
	}

	@Override
	public List<TrainingData> listTrainingDataId() {
		return rosterDAO.listTrainingDataId();
	}

	@Override
	public void removeTrainingData(ObservableList<TrainingData> itemsSelected) {
		rosterDAO.removeTrainingData(itemsSelected);
	}

	@Override
	public void updateTrainingData(TrainingData trainingdata) {
		rosterDAO.updateTrainingData(trainingdata);
	}
	
	@Override
	public List<CalendarData> listCalendarData() {
		return rosterDAO.listCalendarData();
	}

	@Override
	public void addCalendarData(CalendarData assignmentdata) {
		rosterDAO.addCalendarData(assignmentdata);
	}

	@Override
	public List<CalendarData> listCalendarDataId() {
		return rosterDAO.listCalendarDataId();
	}

	@Override
	public void removeCalendarData(ObservableList<CalendarData> itemsSelected) {
		rosterDAO.removeCalendarData(itemsSelected);
	}

	@Override
	public void updateCalendarData(CalendarData calendardata) {
		rosterDAO.updateCalendarData(calendardata);
	}
	@Override
	public List<WorkEarlyPattern> listWorkEarlyPattern() {
		return rosterDAO.listWorkEarlyPattern();
	}

	@Override
	public void addWorkEarlyPattern(WorkEarlyPattern workbeforedata) {
		rosterDAO.addWorkEarlyPattern(workbeforedata);
	}

	@Override
	public List<WorkEarlyPattern> listWorkEarlyPatternId() {
		return rosterDAO.listWorkEarlyPatternId();
	}
	@Override
	public List<WorkEarlyPattern> listWorkEarlyPatterncode() {
		return rosterDAO.listWorkEarlyPatterncode();
	}

	@Override
	public void removeWorkEarlyPattern(ObservableList<WorkEarlyPattern> itemsSelected) {
		rosterDAO.removeWorkEarlyPattern(itemsSelected);
	}

	@Override
	public void updateWorkEarlyPattern(WorkEarlyPattern workbeforedata) {
		rosterDAO.updateWorkEarlyPattern(workbeforedata);
	}
	
	@Override
	public void addDepartment(Department Department) {
		rosterDAO.addDepartment(Department);
	}

	@Override
	public List<Department> listDepartment() {
		return rosterDAO.listDepartment();
	}
	
	@Override
	public void removeDepartment(ObservableList<Department> itemsSelected) {
		rosterDAO.removeDepartment(itemsSelected);
	}

	@Override
	public void updateDepartment(Department department) {
		rosterDAO.updateDepartment(department);
	}

	@Override
	public List<Department> listDepartmentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listDepartmentcode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShiftTypeDepartmentRequirement> listShiftTypeDepartmentRequirement() {
		return rosterDAO.listShiftTypeDepartmentRequirement();
	}
	
	@Override
	public void removeShiftTypeDepartmentRequirement(ObservableList<ShiftTypeDepartmentRequirement> itemsSelected) {
		rosterDAO.removeShiftTypeDepartmentRequirement(itemsSelected);
	}
	
	

	@Override
	public void updateShiftTypeDepartmentRequirement(ShiftTypeDepartmentRequirement shiftTypeDepartmentRequirement) {
		rosterDAO.updateShiftTypeDepartmentRequirement(shiftTypeDepartmentRequirement);
	}

	@Override
	public void addShiftTypeDepartmentRequirement(ShiftTypeDepartmentRequirement shiftTypeDepartmentRequirement) {
		rosterDAO.addShiftTypeDepartmentRequirement(shiftTypeDepartmentRequirement);
	}
	@Override
	public List<ShiftTypeDepartmentRequirement> listShiftTypeDepartmentRequirementId() {
		return rosterDAO.listShiftTypeDepartmentRequirementId();
	}

	

	@Override
	public List<EmployeeDepartment> listEmployeeDepartment() {
		return rosterDAO.listEmployeeDepartment();
	}
	
	@Override
	public void removeEmployeeDepartment(ObservableList<EmployeeDepartment> itemsSelected) {
		rosterDAO.removeEmployeeDepartment(itemsSelected);
	}
	
	

	@Override
	public void updateEmployeeDepartment(EmployeeDepartment employeeDepartment) {
		rosterDAO.updateEmployeeDepartment(employeeDepartment);
	}

	@Override
	public void addEmployeeDepartment(EmployeeDepartment employeeDepartment) {
		rosterDAO.addEmployeeDepartment(employeeDepartment);
	}
	@Override
	public List<EmployeeDepartment> listEmployeeDepartmentId() {
		return rosterDAO.listEmployeeDepartmentId();
	}
}
	