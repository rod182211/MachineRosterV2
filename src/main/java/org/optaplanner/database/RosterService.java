package org.optaplanner.database;

import java.util.List;

import org.optaplanner.examples.nurserostering.domain.Skill;

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
import org.optaplanner.examples.nurserostering.domain.SkillProficiency;








public interface  RosterService {
	
	
    public void addEmployee(Employee employee);
    public List<Employee> listEmployee();
    public void removeEmployee(Employee itemsSelected);
    public void updateEmployee(Employee employee);
    public void insertEmployee(Employee employee);
    public List<Employee> listEmployeename();
    public List<Employee> listEmployeeId(long empid);
    
    public void addSkill(Skill skills);
    public List<Skill> listSkill();
    public List<Skill> listSkillId();
    public List<Skill> listSkillcode();
    public void removeSkill(ObservableList<Skill> itemsSelected);
    public void updateSkill(Skill skills);
    
    public void addShiftType(ShiftType shifttype);
    public List<ShiftType > listShiftType();
    public List<ShiftType> listShiftTypeId();
    public List<ShiftType> listShiftTypecode();
    public void removeShiftType(ObservableList<ShiftType> itemsSelected);
    public void updateShiftType(ShiftType shifttype);
    
    public void addContract(Contract contract);
    public List<Contract> listContract();
    public List<Contract> listContractId();
    public void removeContract(ObservableList<Contract> itemsSelected);
    public void updateContract(Contract contract);
    public List<Contract> listContractcode();
    
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
          
	/*
	 * public void addShiftTypeSkillRequirement(ShiftTypeSkillRequirement
	 * skillrequirement); public List<ShiftTypeSkillRequirement>
	 * listShiftTypeSkillRequirement(); public List<ShiftTypeSkillRequirement>
	 * listShiftTypeSkillRequirementId(); public void
	 * removeShiftTypeSkillRequirement(ObservableList<ShiftTypeSkillRequirement>
	 * itemsSelected); public void
	 * updateShiftTypeSkillRequirement(ShiftTypeSkillRequirement skillrequirement);
	 * public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirementcode();
	 * public List<ShiftTypeSkillRequirement> listShiftTypeSkillRequirementday();
	 */
    
    public void addBooleanContractLine(BooleanContractLine booleandata);
    public List<BooleanContractLine> listBooleanContractLine();
    public List<BooleanContractLine> listBooleanContractLineId();
    public void removeBooleanContractLine(ObservableList<BooleanContractLine> itemsSelected);
    public void updateBooleanContractLine(BooleanContractLine booleandata);
    
    public void addMinMaxContractLine(MinMaxContractLine minmaxdata);
    public List<MinMaxContractLine> listMinMaxContractLine();
    public List<MinMaxContractLine> listMinMaxContractLineId();
    public void removeMinMaxContractLine(ObservableList<MinMaxContractLine> itemsSelected);
    public void updateMinMaxContractLine(MinMaxContractLine minmaxdata);
    
    public void addPatternContractLine(PatternContractLine patterndata);
    public List<PatternContractLine> listPatternContractLine();
    public List<PatternContractLine> listPatternContractLineId();
    public List<PatternContractLine> listPatternContractLinecode();
    public void removePatternContractLine(ObservableList<PatternContractLine> itemsSelected);
    public void updatePatternContractLine(PatternContractLine patterndata);
    public void deletePatternContractLine(PatternContractLine patterndata);
    
    public void addDayOnRequest(DayOnRequest dayondata);
    public List<DayOnRequest> listDayOnRequest();
    public List<DayOnRequest> listDayOnRequestId();
    public void removeDayOnRequest(ObservableList<DayOnRequest> itemsSelected);
    public void updateDayOnRequest(DayOnRequest dayondata);
    
    public void addDayOffRequest(DayOffRequest dayoffdata);
    public List<DayOffRequest> listDayOffRequest ();
    public List<DayOffRequest> listDayOffRequestId();
    public void removeDayOffRequest(ObservableList<DayOffRequest> itemsSelected);
    public void updateDayOffRequest(DayOffRequest dayoffdata);
    
    public void addShiftOnRequest(ShiftOnRequest shiftondata);
    public List<ShiftOnRequest> listShiftOnRequest ();
    public List<ShiftOnRequest> listShiftOnRequestId();
    public void removeShiftOnRequest(ObservableList<ShiftOnRequest> itemsSelected);
    public void updateShiftOnRequest(ShiftOnRequest shiftondata);
    
    public void addShiftOffRequest(ShiftOffRequest shiftoffdata);
    public List<ShiftOffRequest> listShiftOffRequest();
    public List<ShiftOffRequest> listShiftOffRequestId();
    public void removeShiftOffRequest(ObservableList<ShiftOffRequest> itemsSelected);
    public void updateShiftOffRequest(ShiftOffRequest shiftoffdata);
    
    
    public void addWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern workbeforedata);
    public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePattern ();
    public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePatternId();
    public void removeWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern itemsSelected);
    public void updateWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern workbeforedata);
    public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePatterncode();
    
    public void addShiftType2DaysPattern(ShiftType2DaysPattern shift2daydata);
    public List<ShiftType2DaysPattern> listShiftType2DaysPattern();
    public List<ShiftType2DaysPattern> listShiftType2DaysPatternId();
    public void removeShiftType2DaysPattern(ShiftType2DaysPattern itemsSelected);
    public void updateShiftType2DaysPattern(ShiftType2DaysPattern shift2daydata);
    public List<ShiftType2DaysPattern> listShiftType2DaysPatterncode();
    
    public void addShiftType3DaysPattern(ShiftType3DaysPattern shift3daydata);
    public List<ShiftType3DaysPattern> listShiftType3DaysPattern();
    public List<ShiftType3DaysPattern> listShiftType3DaysPatternId();
    public void removeShiftType3DaysPattern(ShiftType3DaysPattern itemsSelected);
    public void updateShiftType3DaysPattern(ShiftType3DaysPattern shift3daydata);
    
    public void addFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern freeday);
    public List<FreeBefore2DaysWithAWorkDayPattern> listFreeBefore2DaysWithAWorkDayPattern();
    public List<FreeBefore2DaysWithAWorkDayPattern> listFreeBefore2DaysWithAWorkDayPatternId();
    public void removeFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern itemsSelected);
    public void updateFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern freeday);
    
    public void addContractLine(ContractLine contractline);
    public List<ContractLine> listContractLine();
    public List<ContractLine> listContractLineId();
    public List<ContractLine> listContractLinecode();
    public void removeContractLine(ObservableList<ContractLine> itemsSelected);
    public void updateContractLine(ContractLine contractline);
    
    public void addSkillProficiency(SkillProficiency skillprof);
    public List<SkillProficiency> listSkillProficiency();
    public void removeSkillProficiency(SkillProficiency itemsSelected);
    public void mergeSkillProficiency(SkillProficiency employee);
    public void insertSkillProficiency(SkillProficiency employee);
    public List<SkillProficiency> listSkillProficiencyId();
    public List<SkillProficiency> listSkillProficiencycode();
    public List<SkillProficiency> listSkillProficiencyempId();
    
    public void addShift(Shift shift);
    public List<Shift > listShift();
    public List<Shift> listShiftId();
    public List<Shift> listShiftcode();
    public void removeShift(ObservableList<Shift> itemsSelected);
    public void updateShift(Shift shift);
    
    public void addShiftDate(ShiftDate shiftDate);
    public List<ShiftDate> listShiftDate();
    public List<ShiftDate> listShiftDateId();
    public List<ShiftDate> listShiftDatecode();
    public void removeShiftDate(ObservableList<ShiftDate> itemsSelected);
    public void updateShiftDate(ShiftDate shiftDate);
    
    public void addCoverRequirements(CoverRequirements cover);
    public List<CoverRequirements> listCoverRequirements();
    public List<CoverRequirements> listCoverRequirementsId();
    public List<CoverRequirements> listCoverRequirementscode();
    public void removeCoverRequirements(ObservableList<CoverRequirements> itemsSelected);
    public void updateCoverRequirements(CoverRequirements cover);
    
    public List<ShiftAssignment> listShiftAssignment();
    
    public void addDayOffDate(DayOffDate dayoffdata);
    public List<DayOffDate> listDayOffDate ();
    public List<DayOffDate> listDayOffDateId();
    public void removeDayOffDate(ObservableList<DayOffDate> itemsSelected);
    public void updateDayOffDate(DayOffDate dayoffdata);
    
    public void addDayOnDate(DayOnDate dayondata);
    public List<DayOnDate> listDayOnDate ();
    public List<DayOnDate> listDayOnDateId();
    public void removeDayOnDate(ObservableList<DayOnDate> itemsSelected);
    public void updateDayOnDate(DayOnDate dayondata);
    
    public void addShiftOnDate(ShiftOnDate shiftondata);
    public List<ShiftOnDate> listShiftOnDate ();
    public List<ShiftOnDate> listShiftOnDateId();
    public void removeShiftOnDate(ObservableList<ShiftOnDate> itemsSelected);
    public void updateShiftOnDate(ShiftOnDate shiftondata);
    
    public void addShiftOffDate(ShiftOffDate shiftoffdata);
    public List<ShiftOffDate> listShiftOffDate ();
    public List<ShiftOffDate> listShiftOffDateId();
    public void removeShiftOffDate(ObservableList<ShiftOffDate> itemsSelected);
    public void updateShiftOffDate(ShiftOffDate shiftoffdata);


    public void addHolidaysData(HolidaysData holidaydata);
    public List<HolidaysData> listHolidaysData ();
    public List<HolidaysData> listHolidaysDataId();
    public void removeHolidaysData(ObservableList<HolidaysData> itemsSelected);
    public void updateHolidaysData(HolidaysData holidaydata);
    
    
    public void addRosterDayOff(RosterDayOff rdodata);
    public List<RosterDayOff> listRosterDayOff ();
    public List<RosterDayOff> listRosterDayOffId();
    public void removeRosterDayOff(ObservableList<RosterDayOff> itemsSelected);
    public void updateRosterDayOff(RosterDayOff rdodata);
    
    

    public void addLeaveData(LeaveData leavedata);
    public List<LeaveData> listLeaveData ();
    public List<LeaveData> listLeaveDataId();
    public void removeLeaveData(ObservableList<LeaveData> itemsSelected);
    public void updateLeaveData(LeaveData leavedata);
    
    public void addTrainingData(TrainingData trainingdata);
    public List<TrainingData> listTrainingData ();
    public List<TrainingData> listTrainingDataId();
    public void removeTrainingData(ObservableList<TrainingData> itemsSelected);
    public void updateTrainingData(TrainingData trainingdata);
    
    
    public void addCalendarData(CalendarData assignmentdata);
    public List<CalendarData> listCalendarData ();
    public List<CalendarData> listCalendarDataId();
    public void removeCalendarData(ObservableList<CalendarData> calendardata);
    public void updateCalendarData(CalendarData calendardata);
    
    public void addWorkEarlyPattern(WorkEarlyPattern workbeforedata);
    public List<WorkEarlyPattern> listWorkEarlyPattern ();
    public List<WorkEarlyPattern> listWorkEarlyPatternId();
    public void removeWorkEarlyPattern(ObservableList<WorkEarlyPattern> itemsSelected);
    public void updateWorkEarlyPattern(WorkEarlyPattern workbeforedata);
    public List<WorkEarlyPattern> listWorkEarlyPatterncode();
    
    public void addMachine(Machine department);
    public List<Machine > listMachine();
    public List<Machine> listMachineId();
    public List<Machine> listMachinecode();
    public void removeMachine(ObservableList<Machine> itemsSelected);
    public void updateMachine(Machine department);
    
    public void addShiftTypeMachineRequirement(ShiftTypeMachineRequirement shiftTypeMachineRequirements);
    public List<ShiftTypeMachineRequirement> listShiftTypeMachineRequirement();
    public List<ShiftTypeMachineRequirement> listShiftTypeMachineRequirementId();
    public void removeShiftTypeMachineRequirement(ObservableList<ShiftTypeMachineRequirement> itemsSelected);
    public void updateShiftTypeMachineRequirement(ShiftTypeMachineRequirement shiftTypeMachineRequirements);
    
    public void addEmployeeMachine(EmployeeMachine employeeMachine);
    public List<EmployeeMachine> listEmployeeMachine();
    public List<EmployeeMachine> listEmployeeMachineId();
    public void removeEmployeeMachine(EmployeeMachine itemsSelected);
    public void mergeEmployeeMachine(EmployeeMachine employeeMachine);
    
    public void addMachineTypeSkillsRequirement(MachineTypeSkillsRequirement shiftTypeMachineRequirements);
    public List<MachineTypeSkillsRequirement> listMachineTypeSkillsRequirement();
    public List<MachineTypeSkillsRequirement> listMachineTypeSkillsRequirementId();
    public void removeMachineTypeSkillsRequirement(ObservableList<MachineTypeSkillsRequirement> itemsSelected);
    public void updateMachineTypeSkillsRequirement(MachineTypeSkillsRequirement shiftTypeMachineRequirements);
}
