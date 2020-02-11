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

import org.optaplanner.examples.nurserostering.domain.Skill;









public interface RosterDAO {
	//get all employee Data
public void addEmployee(Employee employee);
public List<Employee> listEmployee();
public void removeEmployee(Employee itemsSelected);
public void updateEmployee(Employee employee);
public void insertEmployee(Employee employee);
public List<Employee> listEmployeename();   
public List<Employee> listEmployeeId(long empid);

    //get all skills data
 public void addSkill(Skill skills);
 public List<Skill> listSkill();
 public List<Skill> listSkillId();
 public List<Skill> listSkillcode();
 public void removeSkill(ObservableList<Skill> itemsSelected);
 public void updateSkill(Skill skills);
 

public void addShiftType(ShiftType shifttype);
public List<ShiftType> listShiftType();
public List<ShiftType> listShiftTypeId();
public List<ShiftType> listShiftTypecode();
public void removeShiftType(ObservableList<ShiftType> itemsSelected);
public void updateShiftType(ShiftType shifttype);

 
 public void addRosterParametrizationData(RosterParametrizationData scheddates);
 public List<RosterParametrizationData> listRosterParametrizationData();
 public void removeRosterParametrizationData(ObservableList<RosterParametrizationData> itemsSelected);
 public void updateRosterParametrizationData(RosterParametrizationData scheddates);

 
public void addPattern(Pattern pattern);
public List<Pattern> listPattern();
public List<Pattern> listPatternId();
public List<Pattern> listPatterncode();
public void removePattern(ObservableList<Pattern> itemsSelected);
public void updatePattern(Pattern pattern);
public void deletePattern(Pattern itemsSelected);
 //get all contract data
 public List<Contract> listContract();
 public void addContract(Contract contract);
 public List<Contract> listContractId();
 public void removeContract(ObservableList<Contract> itemsSelected);
 public void updateContract(Contract contract);
 public List<Contract> listContractcode();
 
 
 public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirement();
 public void addShiftTypeSkillRequirement(ShiftTypeSkillRequirement skillrequirement);
 public void removeShiftTypeSkillRequirement(ObservableList<ShiftTypeSkillRequirement> itemsSelected);
 public void updateShiftTypeSkillRequirement(ShiftTypeSkillRequirement skillrequirement);
 public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirementId();
 public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirementcode();
 public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirementday();
 
 public List<BooleanContractLine> listBooleanContractLine();
 public void addBooleanContractLine(BooleanContractLine booleandata);
 public void removeBooleanContractLine(ObservableList<BooleanContractLine> itemsSelected);
 public void updateBooleanContractLine(BooleanContractLine booleandata);
 public List<BooleanContractLine> listBooleanContractLineId();
 

 public void addMinMaxContractLine(MinMaxContractLine minmaxdata);
 public void removeMinMaxContractLine(ObservableList<MinMaxContractLine> itemsSelected);
 public void updateMinMaxContractLine(MinMaxContractLine minmaxdata);
 public List<MinMaxContractLine> listMinMaxContractLineId();
 public List<MinMaxContractLine>listMinMaxContractLine();

 public void addPatternContractLine(PatternContractLine patterndata);
 public void removePatternContractLine(ObservableList<PatternContractLine> itemsSelected);
 public void updatePatternContractLine(PatternContractLine patterndata);
 public void deletePatternContractLine(PatternContractLine patterndata);
 public List<PatternContractLine> listPatternContractLineId();
 public List<PatternContractLine> listPatternContractLinecode();
 public List<PatternContractLine> listPatternContractLine();
 
 public void addDayOnRequest(DayOnRequest dayondata);
 public void removeDayOnRequest(ObservableList<DayOnRequest> itemsSelected);
 public void updateDayOnRequest(DayOnRequest dayondata);
 public List<DayOnRequest> listDayOnReqestDataId();
 public List<DayOnRequest>listDayOnRequest();
 
 public void addDayOffRequest(DayOffRequest dayoffdata);
 public void removeDayOffRequest (ObservableList<DayOffRequest> itemsSelected);
 public void updateDayOffRequest(DayOffRequest  dayoffdata);
 public List<DayOffRequest> listDayOffRequestId();
 public List<DayOffRequest>listDayOffRequest();
 
 public void addShiftOnRequest(ShiftOnRequest  shiftondata);
 public void removeShiftOnRequest (ObservableList<ShiftOnRequest> itemsSelected);
 public void updateShiftOnRequest(ShiftOnRequest shiftondata);
 public List<ShiftOnRequest> listShiftOnRequestId();
 public List<ShiftOnRequest >listShiftOnRequest ();
 
 
 public void addShiftOffRequest (ShiftOffRequest  dayondata);
 public void removeShiftOffRequest(ObservableList<ShiftOffRequest> itemsSelected);
 public void updateShiftOffRequest (ShiftOffRequest dayondata);
 public List<ShiftOffRequest> listShiftOffRequestId();
 public List<ShiftOffRequest>listShiftOffRequest();
 
 public void addWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern  workbeforedata);
 public void removeWorkBeforeFreeSequencePattern (WorkBeforeFreeSequencePattern itemsSelected);
 public void updateWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern workbeforedata);
 public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePatternId();
 public List<WorkBeforeFreeSequencePattern>listWorkBeforeFreeSequencePattern ();
 public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePatterncode();
 
 public void addWorkEarlyPattern(WorkEarlyPattern  workbeforedata);
 public void removeWorkEarlyPattern (ObservableList<WorkEarlyPattern> itemsSelected);
 public void updateWorkEarlyPattern(WorkEarlyPattern workbeforedata);
 public List<WorkEarlyPattern> listWorkEarlyPatternId();
 public List<WorkEarlyPattern>listWorkEarlyPattern ();
 public List<WorkEarlyPattern> listWorkEarlyPatterncode();
 
 public void addShiftType2DaysPattern(ShiftType2DaysPattern  shift2daydata);
 public void removeShiftType2DaysPattern(ShiftType2DaysPattern itemsSelected);
 public void updateShiftType2DaysPattern (ShiftType2DaysPattern shift2daydata);
 public List<ShiftType2DaysPattern> listShiftType2DaysPatternId();
 public List<ShiftType2DaysPattern>listShiftType2DaysPattern();
 public List<ShiftType2DaysPattern> listShiftType2DaysPatterncode();
 
 public void addShiftType3DaysPattern(ShiftType3DaysPattern  shift3daydata);
 public void removeShiftType3DaysPattern(ShiftType3DaysPattern itemsSelected);
 public void updateShiftType3DaysPattern (ShiftType3DaysPattern shift3daydata);
 public List<ShiftType3DaysPattern> listShiftType3DaysPatternId();
 public List<ShiftType3DaysPattern>listShiftType3DaysPattern();
 
 public void addFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern  freeday);
 public void removeFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern itemsSelected);
 public void updateFreeBefore2DaysWithAWorkDayPattern (FreeBefore2DaysWithAWorkDayPattern freeday);
 public List<FreeBefore2DaysWithAWorkDayPattern> listFreeBefore2DaysWithAWorkDayPatternId();
 public List<FreeBefore2DaysWithAWorkDayPattern>listFreeBefore2DaysWithAWorkDayPattern();

 public void addContractLine(ContractLine contractline);
 public void removeContractLine(ObservableList<ContractLine> itemsSelected);
 public void updateContractLine(ContractLine contractline);
 public List<ContractLine> listContractLineId();
 public List<ContractLine>listContractLine();
 public List<ContractLine> listContractLinecode();
 
 
 public void addSkillProficiency(SkillProficiency skillprof);
 public List<SkillProficiency> listSkillProficiency();
 public void removeSkillProficiency(SkillProficiency itemsSelected);
 public void updateSkillProficiency(SkillProficiency skillprof);
 public void insertSkillProficiency(SkillProficiency skillprof);
 public List<SkillProficiency> listSkillProficiencyId();
 public List<SkillProficiency> listSkillProficiencyempId();
 public List<SkillProficiency> listSkillProficiencycode();
 
 public void addShift(Shift shift);
 public List<Shift> listShift();
 public List<Shift> listShiftId();
 public List<Shift> listShiftcode();
 public void removeShift(ObservableList<Shift> itemsSelected);
 public void updateShift(Shift shift);
 
 public List<CoverRequirements> listCoverRequirements();
 public void addCoverRequirements(CoverRequirements cover);
 public void removeCoverRequirements(ObservableList<CoverRequirements> itemsSelected);
 public void updateCoverRequirements(CoverRequirements cover);
 public List<CoverRequirements> listCoverRequirementsId();
 public List<CoverRequirements> listCoverRequirementscode();
 public List<CoverRequirements> listCoverRequirementsday();
 
 
 public void addShiftDate(ShiftDate shiftDate);
 public List<ShiftDate> listShiftDate();
 public List<ShiftDate> listShiftDateId();
 public List<ShiftDate> listShiftDatecode();
 public void removeShiftDate(ObservableList<ShiftDate> itemsSelected);
 public void updateShiftDate(ShiftDate shiftDate);
 
 public List<ShiftAssignment> listShiftAssignment();
 
 public void addDayOffDate(DayOffDate dayoffdata);
 public void removeDayOffDate (ObservableList<DayOffDate> itemsSelected);
 public void updateDayOffDate(DayOffDate  dayoffdata);
 public List<DayOffDate> listDayOffDateId();
 public List<DayOffDate>listDayOffDate();
 
 public void addDayOnDate(DayOnDate dayondata);
 public void removeDayOnDate (ObservableList<DayOnDate> itemsSelected);
 public void updateDayOnDate(DayOnDate  dayondata);
 public List<DayOnDate> listDayOnDateId();
 public List<DayOnDate>listDayOnDate();
 
 
 public void addShiftOnDate(ShiftOnDate shiftondata);
 public void removeShiftOnDate (ObservableList<ShiftOnDate> itemsSelected);
 public void updateShiftOnDate(ShiftOnDate  shiftondata);
 public List<ShiftOnDate> listShiftOnDateId();
 public List<ShiftOnDate>listShiftOnDate();
 
 public void addShiftOffDate(ShiftOffDate shiftoffdata);
 public void removeShiftOffDate (ObservableList<ShiftOffDate> itemsSelected);
 public void updateShiftOffDate(ShiftOffDate  shiftoffdata);
 public List<ShiftOffDate> listShiftOffDateId();
 public List<ShiftOffDate>listShiftOffDate();
 
 public void addHolidaysData(HolidaysData shiftoffdata);
 public void removeHolidaysData (ObservableList<HolidaysData> itemsSelected);
 public void updateHolidaysData(HolidaysData  shiftoffdata);
 public List<HolidaysData> listHolidaysDataId();
 public List<HolidaysData>listHolidaysData();
 
 
 public void addRosterDayOff(RosterDayOff rdodata);
 public void removeRosterDayOff (ObservableList<RosterDayOff> itemsSelected);
 public void updateRosterDayOff(RosterDayOff  rdodata);
 public List<RosterDayOff> listRosterDayOffId();
 public List<RosterDayOff>listRosterDayOff();
 
 public void addLeaveData(LeaveData leavedata);
 public void removeLeaveData (ObservableList<LeaveData> itemsSelected);
 public void updateLeaveData(LeaveData  leavedata);
 public List<LeaveData> listLeaveDataId();
 public List<LeaveData>listLeaveData();
 
 public void addTrainingData(TrainingData trainingdata);
 public void removeTrainingData (ObservableList<TrainingData> itemsSelected);
 public void updateTrainingData(TrainingData  trainingdata);
 public List<TrainingData> listTrainingDataId();
 public List<TrainingData>listTrainingData();
 
 
 public void addCalendarData(CalendarData assignmentdata);
 public void removeCalendarData (ObservableList<CalendarData> itemsSelected);
 public void updateCalendarData(CalendarData  calendardata);
 public List<CalendarData> listCalendarDataId();
 public List<CalendarData>listCalendarData();
 
 
 public void addDepartment(Department department);
 public List<Department> listDepartment();
 public List<Department> listDepartmentId();
 public List<Department> listDepartmentcode();
 public void removeDepartment(ObservableList<Department> itemsSelected);
 public void updateDepartment(Department department);
 
 
 
 public void addShiftTypeDepartmentRequirement(ShiftTypeDepartmentRequirement shiftTypeDepartmentRequirement);
 public void removeShiftTypeDepartmentRequirement (ObservableList<ShiftTypeDepartmentRequirement> itemsSelected);
 public void updateShiftTypeDepartmentRequirement(ShiftTypeDepartmentRequirement  shiftTypeDepartmentRequirement);
 public List<ShiftTypeDepartmentRequirement> listShiftTypeDepartmentRequirementId();
 public List<ShiftTypeDepartmentRequirement>listShiftTypeDepartmentRequirement();
 
 public void addEmployeeDepartment(EmployeeDepartment employeeDepartment);
 public void removeEmployeeDepartment (ObservableList<EmployeeDepartment> itemsSelected);
 public void updateEmployeeDepartment(EmployeeDepartment  employeeDepartment);
 public List<EmployeeDepartment> listEmployeeDepartmentId();
 public List<EmployeeDepartment>listEmployeeDepartment();
}
