package org.optaplanner.database;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import org.optaplanner.examples.nurserostering.domain.CoverRequirements;
import org.optaplanner.examples.nurserostering.domain.Machine;
import org.optaplanner.examples.nurserostering.domain.MachineTypeSkillsRequirement;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.EmployeeMachine;
import org.optaplanner.examples.nurserostering.domain.NurseRoster;
import org.optaplanner.examples.nurserostering.domain.NurseRosterParametrization;
import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.domain.ShiftAssignment;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;
import org.optaplanner.examples.nurserostering.domain.ShiftType;
import org.optaplanner.examples.nurserostering.domain.ShiftTypeMachineRequirement;
//import org.optaplanner.examples.nurserostering.domain.ShiftTypeSkillRequirement;
import org.optaplanner.examples.nurserostering.domain.Skill;
import org.optaplanner.examples.nurserostering.domain.SkillProficiency;
import org.optaplanner.examples.nurserostering.domain.WeekendDefinition;
import org.optaplanner.examples.nurserostering.domain.contract.BooleanContractLine;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.optaplanner.examples.nurserostering.domain.contract.ContractLine;
import org.optaplanner.examples.nurserostering.domain.contract.ContractLineType;
import org.optaplanner.examples.nurserostering.domain.contract.MinMaxContractLine;
import org.optaplanner.examples.nurserostering.domain.contract.PatternContractLine;
import org.optaplanner.examples.nurserostering.domain.pattern.FreeBefore2DaysWithAWorkDayPattern;
import org.optaplanner.examples.nurserostering.domain.pattern.Pattern;
import org.optaplanner.examples.nurserostering.domain.pattern.ShiftType2DaysPattern;
import org.optaplanner.examples.nurserostering.domain.pattern.ShiftType3DaysPattern;
import org.optaplanner.examples.nurserostering.domain.pattern.WorkBeforeFreeSequencePattern;
import org.optaplanner.examples.nurserostering.domain.pattern.WorkEarlyPattern;
import org.optaplanner.examples.nurserostering.domain.request.DayOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.DayOnRequest;
import org.optaplanner.examples.nurserostering.domain.request.HolidayRequest;
import org.optaplanner.examples.nurserostering.domain.request.LeaveRequest;
import org.optaplanner.examples.nurserostering.domain.request.RosterDay;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOnRequest;
import org.optaplanner.examples.nurserostering.domain.request.TrainingRequest;
import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.pool.CalendarData;
import org.optaplanner.examples.pool.DayOffDate;
import org.optaplanner.examples.pool.DayOnDate;
import org.optaplanner.examples.pool.HolidaysData;
import org.optaplanner.examples.pool.LeaveData;
import org.optaplanner.examples.pool.RosterDayOff;
import org.optaplanner.examples.pool.RosterParametrizationData;
import org.optaplanner.examples.pool.ShiftOffDate;
import org.optaplanner.examples.pool.ShiftOnDate;
import org.optaplanner.examples.pool.TrainingData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.hibernate.Session;

public class DataLogic {

	protected Map<LocalDate, ShiftDate> shiftDateMap;
	protected Map<String, Skill> skillMap;
	protected Map<String, Machine> machineMap;
	protected Map<String, ShiftType> shiftTypeMap;
	protected Map<Pair<LocalDate, String>, Shift> dateAndShiftTypeToShiftMap;
	protected Map<Pair<DayOfWeek, ShiftType>, List<Shift>> dayOfWeekAndShiftTypeToShiftListMap;
	protected Map<String, Pattern> patternMap;
	protected Map<Employee, Skill> employeeSkillMap;
	protected Map<String, Contract> contractMap;
	protected Map<String, Employee> employeeMap;
	private RosterService rosterService = new RosterServiceImpl();
	private static Session session;

	public NurseRoster readSolution() {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		NurseRoster nurseRoster = new NurseRoster();
		nurseRoster.setId(0L);
		RosterParametrizationData paramcode = (RosterParametrizationData) session.get(RosterParametrizationData.class,
				0);
		String nurserostername = (paramcode.getCode());
		nurseRoster.setCode(nurserostername);
		generateShiftDateList(nurseRoster, paramcode.getStartDate(), paramcode.getEndDate());
		session.close();
		generateNurseRosterInfo(nurseRoster);
		readSkillList(nurseRoster);
		readMachineList(nurseRoster);
		readShiftTypeList(nurseRoster);
		readMachineTypeSkills(nurseRoster);
		readMachineShiftType(nurseRoster);
		generateShiftList(nurseRoster);
		readPatternList(nurseRoster);
		readContractList(nurseRoster);
		readEmployeeList(nurseRoster);
		readRequiredEmployeeSizes(nurseRoster);
		readDayOffRequestList(nurseRoster);
		readDayOnRequestList(nurseRoster);
		readShiftOffRequestList(nurseRoster);
		readShiftOnRequestList(nurseRoster);
		readHolidayRequestList(nurseRoster);
		readLeaveRequest(nurseRoster);
		readRosterDayRequest(nurseRoster);
		readTrainingRequest(nurseRoster);
		createShiftAssignmentList(nurseRoster);

		return nurseRoster;
	}

	private void generateShiftDateList(NurseRoster nurseRoster, LocalDate FirstshiftDate, LocalDate LastshiftDate) {

		if (FirstshiftDate.compareTo(LastshiftDate) >= 0) {
			throw new IllegalStateException(
					"The startDate (" + FirstshiftDate + " must be before endDate (" + LastshiftDate + ").");
		}
		int maxDayIndex = Math.toIntExact(DAYS.between(FirstshiftDate, LastshiftDate));
		int shiftDateSize = maxDayIndex + 1;

		List<ShiftDate> shiftDateList = new ArrayList<>(shiftDateSize);
		shiftDateMap = new HashMap<>(shiftDateSize);
		long id = 0L;
		int dayIndex = 0;
		LocalDate date = FirstshiftDate;
		for (int i = 0; i < shiftDateSize; i++) {
			ShiftDate shiftDate = new ShiftDate();
			shiftDate.setId(id);
			shiftDate.setDayIndex(dayIndex);
			shiftDate.setDate(date);
			shiftDate.setShiftList(new ArrayList<>());
			shiftDateList.add(shiftDate);
			shiftDateMap.put(date, shiftDate);
			id++;
			dayIndex++;
			date = date.plusDays(1);
		}

		nurseRoster.setShiftDateList(shiftDateList);
	}

	private void generateNurseRosterInfo(NurseRoster nurseRoster) {
		List<ShiftDate> shiftDateList = nurseRoster.getShiftDateList();
		NurseRosterParametrization nurseRosterParametrization = new NurseRosterParametrization();
		nurseRosterParametrization.setId(0L);
		nurseRosterParametrization.setFirstShiftDate(shiftDateList.get(0));
		nurseRosterParametrization.setLastShiftDate(shiftDateList.get(shiftDateList.size() - 1));
		nurseRosterParametrization.setPlanningWindowStart(shiftDateList.get(0));
		nurseRoster.setNurseRosterParametrization(nurseRosterParametrization);
	}

	private void readSkillList(NurseRoster nurseRoster) {
		List<Skill> skillList;
		List<Skill> skillElementList = (List<Skill>) rosterService.listSkill();
		skillList = new ArrayList<>(skillElementList.size());
		skillMap = new HashMap<>(skillElementList.size());

		for (Skill element : skillElementList) {

			Skill skill = new Skill();
			long id = element.getId();
			skill.setId(id);
			skill.setCode(element.getCode());
			skillList.add(skill);
			if (skillMap.containsKey(skill.getCode())) {
				throw new IllegalArgumentException("There are 2 skills with the same code (" + skill.getCode() + ").");
			}
			skillMap.put(skill.getCode(), skill);

		}

		nurseRoster.setSkillList(skillList);

	}

	private void readMachineList(NurseRoster nurseRoster) {
		List<Machine> departmentList;

		List<Machine> departmentElementList = (List<Machine>) rosterService.listMachine();
		departmentList = new ArrayList<>(departmentElementList.size());
		machineMap = new HashMap<>(departmentElementList.size());

		for (Machine element : departmentElementList) {
			long Id = element.getId();
			Machine department = new Machine();
			department.setId(Id);
			department.setCode(element.getCode());
			departmentList.add(department);
			if (machineMap.containsKey(department.getCode())) {
				throw new IllegalArgumentException(
						"There are 2 departments with the same code (" + department.getCode() + ").");
			}
			machineMap.put(department.getCode(), department);

		}

		nurseRoster.setMachineList(departmentList);

	}

	private void readShiftTypeList(NurseRoster nurseRoster) {

		List<ShiftType> shiftTypeElementList = (List<ShiftType>) rosterService.listShiftType();
		List<ShiftType> shiftTypeList = new ArrayList<>(shiftTypeElementList.size());
		shiftTypeMap = new HashMap<>(shiftTypeElementList.size());
		long id = 0L;
		int index = 0;
		for (ShiftType element : shiftTypeElementList) {

			ShiftType shiftType = new ShiftType();
			shiftType.setId(id);
			shiftType.setCode(element.getCode());
			shiftType.setIndex(index);
			String startTimeString = element.getStartTimeString();
			shiftType.setStartTimeString(startTimeString);
			String endTimeString = element.getEndTimeString();
			shiftType.setEndTimeString(endTimeString);
			shiftType.setNight(startTimeString.compareTo(endTimeString) > 0);
			shiftType.setDescription(element.getDescription());

			shiftTypeList.add(shiftType);
			if (shiftTypeMap.containsKey(shiftType.getCode())) {
				throw new IllegalArgumentException(
						"There are 2 shiftTypes with the same code (" + shiftType.getCode() + ").");
			}
			shiftTypeMap.put(shiftType.getCode(), shiftType);
			id++;
			index++;
		}
		nurseRoster.setShiftTypeList(shiftTypeList);
	}
	private void readMachineTypeSkills(NurseRoster nurseRoster) {
		List<MachineTypeSkillsRequirement> coverRequirementElementList = (List<MachineTypeSkillsRequirement>) rosterService
				.listMachineTypeSkillsRequirement();
		List<MachineTypeSkillsRequirement> machineTypeSkillsRequirementList = new ArrayList<>(
				coverRequirementElementList.size() * 2);
		long machineTypeSkillRequirementId = 0L;
		for (MachineTypeSkillsRequirement skillElement : coverRequirementElementList) {
			MachineTypeSkillsRequirement machineTypeSkillsRequirement = new MachineTypeSkillsRequirement();
			machineTypeSkillsRequirement.setId(machineTypeSkillRequirementId);

			Machine wanted = machineMap.get(skillElement.getMachine().getCode());
			machineTypeSkillsRequirement.setMachine(wanted);
			Skill skill = skillMap.get(skillElement.getSkill().getCode());
			machineTypeSkillsRequirement.setSkill(skill);
			ShiftType type = shiftTypeMap.get(skillElement.getShiftType().getCode());
			machineTypeSkillsRequirement.setShiftType(type);
			machineTypeSkillsRequirementList.add(machineTypeSkillsRequirement);
			machineTypeSkillRequirementId++;
		}
		nurseRoster.setMachineTypeSkillsRequirementList(machineTypeSkillsRequirementList);
	}

	private void readMachineShiftType(NurseRoster nurseRoster) {
		List<ShiftTypeMachineRequirement> coverElementList = (List<ShiftTypeMachineRequirement>) rosterService
				.listShiftTypeMachineRequirement();
		List<ShiftTypeMachineRequirement> shiftTypeMachineRequirementList = new ArrayList<>(
				coverElementList.size() * 2);
		long ShiftTypeMachineRequirementId = 0L;
		for (ShiftTypeMachineRequirement skillElement1 : coverElementList) {
			ShiftTypeMachineRequirement ShiftTypeMachineRequirement = new ShiftTypeMachineRequirement();
			ShiftTypeMachineRequirement.setId(ShiftTypeMachineRequirementId);
			Machine depart = machineMap.get(skillElement1.getMachine().getCode());
			ShiftTypeMachineRequirement.setMachine(depart);
			ShiftType shiftTypereq = shiftTypeMap.get(skillElement1.getShiftType().getCode());
			ShiftTypeMachineRequirement.setShiftType(shiftTypereq);
			shiftTypeMachineRequirementList.add(ShiftTypeMachineRequirement);
			ShiftTypeMachineRequirementId++;

		}

		nurseRoster.setShiftTypeMachineRequirementList(shiftTypeMachineRequirementList);
	}

	private void generateShiftList(NurseRoster nurseRoster) {
		List<ShiftType> shiftTypeList = nurseRoster.getShiftTypeList();
		int shiftListSize = shiftDateMap.size() * shiftTypeList.size();
		List<Shift> shiftList = new ArrayList<>(shiftListSize);
		dateAndShiftTypeToShiftMap = new HashMap<>(shiftListSize);
		dayOfWeekAndShiftTypeToShiftListMap = new HashMap<>(7 * shiftTypeList.size());
		long id = 0;
		int index = 0;
		for (ShiftDate shiftDate : nurseRoster.getShiftDateList()) {
			for (ShiftType shiftType : shiftTypeList) {
				Shift shift = new Shift();
				shift.setId(id);
				shift.setShiftDate(shiftDate);
				shiftDate.getShiftList().add(shift);
				shift.setShiftType(shiftType);
				shift.setIndex(index);
				shift.setRequiredEmployeeSize(0); // Filled in later
				shiftList.add(shift);
				dateAndShiftTypeToShiftMap.put(Pair.of(shiftDate.getDate(), shiftType.getCode()), shift);
				addShiftToDayOfWeekAndShiftTypeToShiftListMap(shiftDate, shiftType, shift);
				id++;
				index++;

			}

		}

		nurseRoster.setShiftList(shiftList);

	}

	private void addShiftToDayOfWeekAndShiftTypeToShiftListMap(ShiftDate shiftDate, ShiftType shiftType, Shift shift) {
		Pair<DayOfWeek, ShiftType> key = Pair.of(shiftDate.getDayOfWeek(), shiftType);
		List<Shift> dayOfWeekAndShiftTypeToShiftList = dayOfWeekAndShiftTypeToShiftListMap.computeIfAbsent(key,
				k -> new ArrayList<>((shiftDateMap.size() + 6) / 7));
		dayOfWeekAndShiftTypeToShiftList.add(shift);
	}

	private void readPatternList(NurseRoster nurseRoster) {

		List<Pattern> patternList;
		List<Pattern> patternElementList = (List<Pattern>) rosterService.listPattern();
		patternList = new ArrayList<>(patternElementList.size());
		patternMap = new HashMap<>(patternElementList.size());

		List<FreeBefore2DaysWithAWorkDayPattern> FreeElementList = (List<FreeBefore2DaysWithAWorkDayPattern>) rosterService
				.listFreeBefore2DaysWithAWorkDayPattern();

		FreeBefore2DaysWithAWorkDayPattern pattern = new FreeBefore2DaysWithAWorkDayPattern();
		for (FreeBefore2DaysWithAWorkDayPattern freeelement : FreeElementList) {
			DayOfWeek DayOfWeek = freeelement.getFreeDayOfWeek();
			long Id = freeelement.getId();
			String code = freeelement.getCode();
			int weight = freeelement.getWeight();
			pattern.setId(Id);
			pattern.setCode(code);
			pattern.setWeight(weight);
			pattern.setFreeDayOfWeek(DayOfWeek);
			patternList.add(pattern);
			patternMap.put(pattern.getCode(), pattern);

		}

		List<WorkBeforeFreeSequencePattern> workbElementList = (List<WorkBeforeFreeSequencePattern>) rosterService
				.listWorkBeforeFreeSequencePattern();

		for (WorkBeforeFreeSequencePattern workbelement : workbElementList) {
			WorkBeforeFreeSequencePattern pattern1 = new WorkBeforeFreeSequencePattern();
			String code = workbelement.getCode();
			long Id = workbelement.getId();
			int weight = workbelement.getWeight();
			int freeDayLength = workbelement.getFreeDayLength();
			// I am using NUll
			// DayOfWeek dayOfWeek = workbelement.getWorkDayOfWeek();
			ShiftType type = shiftTypeMap.get(workbelement.getWorkShiftType().getCode());
			pattern1.setId(Id);
			pattern1.setCode(code);
			pattern1.setWeight(weight);
			pattern1.setFreeDayLength(freeDayLength);
			pattern1.setWorkDayOfWeek(null);
			pattern1.setWorkShiftType(type);
			patternList.add(pattern1);
			patternMap.put(pattern1.getCode(), pattern1);

		}

		List<ShiftType2DaysPattern> twodaysElementList = (List<ShiftType2DaysPattern>) rosterService
				.listShiftType2DaysPattern();

		for (ShiftType2DaysPattern twodayselement : twodaysElementList) {

			ShiftType2DaysPattern pattern2 = new ShiftType2DaysPattern();
			long Id = twodayselement.getId();
			String code = twodayselement.getCode();
			int weight = twodayselement.getWeight();
			String shift1 = twodayselement.getDayIndex0ShiftType().getCode();
			String shift2 = twodayselement.getDayIndex1ShiftType().getCode();
			ShiftType type1 = shiftTypeMap.get(shift1);
			ShiftType type2 = shiftTypeMap.get(shift2);
			pattern2.setId(Id);
			pattern2.setCode(code);
			pattern2.setWeight(weight);
			pattern2.setDayIndex0ShiftType(type1);
			pattern2.setDayIndex1ShiftType(type2);

			patternList.add(pattern2);
			patternMap.put(pattern2.getCode(), pattern2);

		}

		List<ShiftType3DaysPattern> threedaysElementList = (List<ShiftType3DaysPattern>) rosterService
				.listShiftType3DaysPattern();
		for (ShiftType3DaysPattern threedayselement : threedaysElementList) {

			ShiftType3DaysPattern pattern3 = new ShiftType3DaysPattern();
			long Id = threedayselement.getId();
			String code = threedayselement.getCode();
			int weight = threedayselement.getWeight();
			String type1 = threedayselement.getDayIndex0ShiftType().getCode();
			String type2 = threedayselement.getDayIndex1ShiftType().getCode();
			String type3 = threedayselement.getDayIndex2ShiftType().getCode();
			ShiftType one = shiftTypeMap.get(type1);
			ShiftType two = shiftTypeMap.get(type2);
			ShiftType three = shiftTypeMap.get(type3);
			pattern3.setId(Id);
			pattern3.setCode(code);
			pattern3.setWeight(weight);
			pattern3.setDayIndex0ShiftType(one);
			pattern3.setDayIndex1ShiftType(two);
			pattern3.setDayIndex2ShiftType(three);

			patternList.add(pattern3);
			patternMap.put(pattern3.getCode(), pattern3);

		}
		List<WorkEarlyPattern> workbelementList = (List<WorkEarlyPattern>) rosterService.listWorkEarlyPattern();

		for (WorkEarlyPattern workbelement : workbelementList) {
			WorkEarlyPattern pattern4 = new WorkEarlyPattern();
			String code = workbelement.getCode();
			long Id = workbelement.getId();
			int weight = workbelement.getWeight();
			int shiftLength = workbelement.getShiftLength();
			// I am using NUll
			// DayOfWeek dayOfWeek = workbelement.getWorkDayOfWeek();
			ShiftType type = shiftTypeMap.get(workbelement.getWorkShiftType().getCode());
			pattern4.setId(Id);
			pattern4.setCode(code);
			pattern4.setWeight(weight);
			pattern4.setShiftLength(shiftLength);
			pattern4.setWorkShiftType(type);
			patternList.add(pattern4);
			patternMap.put(pattern4.getCode(), pattern4);

		}

		nurseRoster.setPatternList(patternList);

	}

	private void readContractList(NurseRoster nurseRoster) {

		int contractLineTypeListSize = ContractLineType.values().length;

		List<Contract> contractElementList = (List<Contract>) rosterService.listContract();

		List<Contract> contractList = new ArrayList<>(contractElementList.size());

		contractMap = new HashMap<>(contractElementList.size());

		List<ContractLine> contractLineList = new ArrayList<>(contractElementList.size() * contractLineTypeListSize);

		List<PatternContractLine> patternContractLineList = new ArrayList<>(contractElementList.size() * 3);

		for (Contract element : contractElementList) {
			Contract contract = new Contract();
			long Id = element.getId();
			contract.setId(Id);
			contract.setCode(element.getCode());
			contract.setDescription(element.getDescription());
			WeekendDefinition weekend = element.getWeekendDefinition();
			contract.setWeekendDefinition(weekend);
			contract.setContractLineList(new ArrayList<ContractLine>());
			contractMap.put(contract.getCode(), contract);
			contractList.add(contract);
		}

		List<PatternContractLine> patterncontractElementList = (List<PatternContractLine>) rosterService
				.listPatternContractLine();
		for (PatternContractLine patterncontractselement : patterncontractElementList) {
			PatternContractLine patterncontractLine = new PatternContractLine();
			long count = patterncontractselement.getId();
			Pattern type = patternMap.get(patterncontractselement.getPattern().getCode());
			Contract c = contractMap.get(patterncontractselement.getContract().getCode());

			patterncontractLine.setId((long) count);
			patterncontractLine.setPattern(type);
			patterncontractLine.setContract(c);
			patternContractLineList.add(patterncontractLine);

		}

		nurseRoster.setPatternContractLineList(patternContractLineList);

		List<BooleanContractLine> booleanElementList = (List<BooleanContractLine>) rosterService
				.listBooleanContractLine();

		for (BooleanContractLine bolelement : booleanElementList) {
			BooleanContractLine contractLine = new BooleanContractLine();
			long Id = bolelement.getId();
			int weight = bolelement.getWeight();
			boolean enabled = bolelement.isEnabled();
			ContractLineType lineType = bolelement.getContractLineType();
			Contract c = contractMap.get(bolelement.getContract().getCode());

			contractLine.setId((long) Id);
			contractLine.setWeight(weight);
			contractLine.setEnabled(enabled);
			contractLine.setContractLineType(lineType);
			contractLine.setContract(c);
			c.getContractLineList().add(contractLine);
			contractLineList.add(contractLine);

		}

		List<MinMaxContractLine> minmaxElementList = (List<MinMaxContractLine>) rosterService.listMinMaxContractLine();

		for (MinMaxContractLine element : minmaxElementList) {
			MinMaxContractLine contractLine = new MinMaxContractLine();

			long Id = element.getId();
			int minWeight = element.getMinimumWeight();
			boolean minEn = element.isEnabled();
			int minVal = element.getMinimumValue();
			int maxWeight = element.getMaximumWeight();
			boolean maxEn = element.isMaximumEnabled();
			int maxVal = element.getMaximumValue();
			ContractLineType lineType = element.getContractLineType();
			Contract c = contractMap.get(element.getContract().getCode());
			contractLine.setId((long) Id);
			contractLine.setMinimumEnabled(minEn);
			contractLine.setMinimumValue(minVal);
			contractLine.setMinimumWeight(minWeight);
			contractLine.setMaximumEnabled(maxEn);
			contractLine.setMaximumValue(maxVal);
			contractLine.setMaximumWeight(maxWeight);
			contractLine.setContractLineType(lineType);
			contractLine.setContract(c);
			c.getContractLineList().add(contractLine);
			contractLineList.add(contractLine);

		}
		nurseRoster.setContractList(contractList);
		nurseRoster.setContractLineList(contractLineList);
	}

	private void readEmployeeList(NurseRoster nurseRoster) {

		List<Employee> employeeElementList = (List<Employee>) rosterService.listEmployee();

		List<Employee> employeeList = new ArrayList<>(employeeElementList.size());
		List<EmployeeMachine> employeeMachine1 = (List<EmployeeMachine>) rosterService.listEmployeeMachine();
		List<EmployeeMachine> employeeMachineList = new ArrayList<>(employeeElementList.size() * 2);
		List<SkillProficiency> skillProf = (List<SkillProficiency>) rosterService.listSkillProficiency();
		List<SkillProficiency> skillProficiencyList = new ArrayList<>(employeeElementList.size() * 2);
		employeeMap = new HashMap<>(employeeElementList.size());
		employeeSkillMap = new HashMap<>(employeeElementList.size());

		long employeeMachineId = 0L;
		long skillprofId = 0L;

		for (Employee element : employeeElementList) {

			Employee employee = new Employee();
			long Id = element.getId();
			employee.setId(Id);
			String name = element.getName();
			employee.setName(name);
			String code = element.getCode();
			employee.setCode(code);
			Contract c = contractMap.get(element.getContract().getCode());
			if (c == null) {
				throw new IllegalArgumentException("The contract (" + element.getContract().getCode()
						+ ") of employee (" + employee.getCode() + ") does not exist.");
			}
			employee.setContract(c);

			if (employeeMap.containsKey(employee.getCode())) {
				throw new IllegalArgumentException(
						"There are 2 employees with the same code (" + employee.getCode() + ").");
			}
			employeeMap.put(employee.getName(), employee);
			int estimatedRequestSize = (shiftDateMap.size() / employeeElementList.size()) + 1;
			employee.setDayOffRequestMap(new HashMap<>(estimatedRequestSize));
			employee.setDayOnRequestMap(new HashMap<>(estimatedRequestSize));
			employee.setShiftOffRequestMap(new HashMap<>(estimatedRequestSize));
			employee.setShiftOnRequestMap(new HashMap<>(estimatedRequestSize));
			employee.setHolidayRequestMap(new HashMap<>(estimatedRequestSize));
			employee.setLeaveMap(new HashMap<>(estimatedRequestSize));
			employee.setRosterdayMap(new HashMap<>(estimatedRequestSize));
			employee.setTrainingRequestMap(new HashMap<>(estimatedRequestSize));

			employeeList.add(employee);
		}

		for (EmployeeMachine machineelement : employeeMachine1) {
			EmployeeMachine employeeMachine = new EmployeeMachine();
			// long employeeMachineId = machineelement.getId();
			employeeMachine.setId(employeeMachineId);
			Employee depemployee = employeeMap.get(machineelement.getEmployee().getName());
			Machine machinetype = machineMap.get(machineelement.getMachine().getCode());
			employeeMachine.setEmployee(depemployee);
			employeeMachine.setMachine(machinetype);
			employeeMachineId++;
			employeeMachineList.add(employeeMachine);

		}

		for (SkillProficiency skillelement : skillProf) {
			SkillProficiency skillProficiency = new SkillProficiency();
			skillProficiency.setId(skillprofId);
			Employee skillemployee = employeeMap.get(skillelement.getEmployee().getName());
			skillProficiency.setEmployee(skillemployee);
			Skill skillprof = skillMap.get(skillelement.getSkill().getCode());
			skillProficiency.setSkill(skillprof);
			skillprofId++;
			skillProficiencyList.add(skillProficiency);

		}

		nurseRoster.setEmployeeList(employeeList);
		nurseRoster.setSkillProficiencyList(skillProficiencyList);
		nurseRoster.setEmployeeMachineList(employeeMachineList);
	}

	private void readDayOffRequestList(NurseRoster nurseRoster) {

		List<DayOffRequest> dayOffRequestList;
		List<DayOffDate> dayOffElementList = (List<DayOffDate>) rosterService.listDayOffDate();
		dayOffRequestList = new ArrayList<>(dayOffElementList.size());

		for (DayOffDate element : dayOffElementList) {

			long Id = element.getId();
			int weight = element.getWeight();
			LocalDate date1 = element.getDate();
			String empname = element.getEmployee().getName();
			Employee employee = employeeMap.get(empname);
			ShiftDate shiftDate = shiftDateMap.get(date1);
			DayOffRequest dayOffRequest = new DayOffRequest();
			dayOffRequest.setId(Id);
			dayOffRequest.setWeight(weight);
			dayOffRequest.setEmployee(employee);
			dayOffRequest.setShiftDate(shiftDate);
			dayOffRequestList.add(dayOffRequest);
			employee.getDayOffRequestMap().put(shiftDate, dayOffRequest);

		}

		nurseRoster.setDayOffRequestList(dayOffRequestList);

	}

	private void readDayOnRequestList(NurseRoster nurseRoster) {
		List<DayOnRequest> dayOnRequestList;
		List<DayOnDate> dayOnElementList = (List<DayOnDate>) rosterService.listDayOnDate();
		dayOnRequestList = new ArrayList<>(dayOnElementList.size());

		for (DayOnDate element : dayOnElementList) {

			long Id = element.getId();
			int weight = element.getWeight();
			LocalDate date1 = element.getDate();
			String empname = element.getEmployee().getName();
			Employee employee = employeeMap.get(empname);
			ShiftDate shiftDate = shiftDateMap.get(date1);
			DayOnRequest dayOnRequest = new DayOnRequest();
			dayOnRequest.setId(Id);
			dayOnRequest.setWeight(weight);
			dayOnRequest.setEmployee(employee);
			dayOnRequest.setShiftDate(shiftDate);
			dayOnRequestList.add(dayOnRequest);
			employee.getDayOnRequestMap().put(shiftDate, dayOnRequest);

		}

		nurseRoster.setDayOnRequestList(dayOnRequestList);

	}

	private void readShiftOffRequestList(NurseRoster nurseRoster) {
		List<ShiftOffRequest> shiftOffRequestList;

		List<ShiftOffDate> shiftOffElementList = (List<ShiftOffDate>) rosterService.listShiftOffDate();
		shiftOffRequestList = new ArrayList<>(shiftOffElementList.size());
		for (ShiftOffDate element : shiftOffElementList) {

			long Id = element.getId();
			String empID = element.getEmployee().getName();
			int weight = element.getWeight();
			Employee employee = employeeMap.get(empID);
			LocalDate date1 = element.getDate();
			String shiftcode = element.getShiftType().getCode();
			Shift shift = dateAndShiftTypeToShiftMap.get(Pair.of(date1, shiftcode));
			ShiftOffRequest shiftOffRequest = new ShiftOffRequest();
			shiftOffRequest.setId(Id);
			shiftOffRequest.setEmployee(employee);
			shiftOffRequest.setShift(shift);
			shiftOffRequest.setWeight(weight);
			shiftOffRequestList.add(shiftOffRequest);
			employee.getShiftOffRequestMap().put(shift, shiftOffRequest);

		}

		nurseRoster.setShiftOffRequestList(shiftOffRequestList);

	}

	private void readShiftOnRequestList(NurseRoster nurseRoster) {
		List<ShiftOnRequest> shiftOnRequestList;

		List<ShiftOnDate> shiftOnElementList = (List<ShiftOnDate>) rosterService.listShiftOnDate();
		shiftOnRequestList = new ArrayList<>(shiftOnElementList.size());
		for (ShiftOnDate element : shiftOnElementList) {

			long Id = element.getId();
			String empID = element.getEmployee().getName();
			int weight = element.getWeight();
			Employee employee = employeeMap.get(empID);
			LocalDate date1 = element.getDate();
			String shiftcode = element.getShiftType().getCode();
			Shift shift = dateAndShiftTypeToShiftMap.get(Pair.of(date1, shiftcode));
			ShiftOnRequest shiftOnRequest = new ShiftOnRequest();
			shiftOnRequest.setId(Id);
			shiftOnRequest.setEmployee(employee);
			shiftOnRequest.setShift(shift);
			shiftOnRequest.setWeight(weight);
			shiftOnRequestList.add(shiftOnRequest);
			employee.getShiftOnRequestMap().put(shift, shiftOnRequest);
		}

		nurseRoster.setShiftOnRequestList(shiftOnRequestList);
	}

	private void readHolidayRequestList(NurseRoster nurseRoster) {
		List<LocalDate> allDates = new ArrayList<>();
		List<HolidayRequest> holidayRequestList;
		long Id = 0L;
		List<HolidaysData> holidayElementList = (List<HolidaysData>) rosterService.listHolidaysData();
		holidayRequestList = new ArrayList<>(holidayElementList.size());
		for (HolidaysData element : holidayElementList) {

			int weight = element.getWeight();
			String empname = element.getEmployee().getName();
			Employee employee = employeeMap.get(empname);
			LocalDate startdate = element.getStartdate();
			LocalDate enddate = element.getEnddate();
			if (startdate.isAfter(enddate)) {
				throw new IllegalStateException("start date must be before or equal to end date");
			}

			while (!startdate.isAfter(enddate)) {
				allDates.add(startdate);
				startdate = startdate.plusDays(1);
				ShiftDate firstDate = shiftDateMap.get(startdate.minusDays(1));
				HolidayRequest holidayRequest = new HolidayRequest();
				Id++;
				holidayRequest.setId(Id);

				holidayRequest.setEmployee(employee);
				holidayRequest.setStartshiftDate(firstDate);

				holidayRequest.setWeight(weight);
				holidayRequestList.add(holidayRequest);

				employee.getHolidayRequestMap().put(firstDate, holidayRequest);
			}
		}

		nurseRoster.setHolidayRequestList(holidayRequestList);
	}

	private void readRosterDayRequest(NurseRoster nurseRoster) {
		List<RosterDay> rosterOffRequestList;
		List<RosterDayOff> rosterOffElementList = (List<RosterDayOff>) rosterService.listRosterDayOff();
		rosterOffRequestList = new ArrayList<>(rosterOffElementList.size());

		for (RosterDayOff element : rosterOffElementList) {
			long Id = element.getId();
			LocalDate date1 = element.getDate();
			String empname = element.getEmployee().getName();
			Employee employee = employeeMap.get(empname);
			ShiftDate shiftDate = shiftDateMap.get(date1);
			String shiftcode = "ADO";
			Shift shift = dateAndShiftTypeToShiftMap.get(Pair.of(date1, shiftcode));
			RosterDay rosterOff = new RosterDay();
			rosterOff.setId(Id);
			rosterOff.setShift(shift);
			rosterOff.setWeight(10);
			rosterOff.setEmployee(employee);
			rosterOff.setShiftDate(shiftDate);
			if (shiftDate != null) {
				shift.setRequiredEmployeeSize(shift.getRequiredEmployeeSize() + 1);
			}
			rosterOffRequestList.add(rosterOff);
			employee.getRosterdayMap().put(shift, rosterOff);
		}
		nurseRoster.setRosterOffRequestList(rosterOffRequestList);
	}

	private void readLeaveRequest(NurseRoster nurseRoster) {
		List<LocalDate> allleaveDates = new ArrayList<>();
		List<LeaveRequest> leaveRequestList;
		List<LeaveData> leaveElementList = (List<LeaveData>) rosterService.listLeaveData();
		leaveRequestList = new ArrayList<>(leaveElementList.size());

		long Id = 1l;
		for (LeaveData element : leaveElementList) {

			String empname = element.getEmployee().getName();
			Employee employee = employeeMap.get(empname);
			LocalDate startdate = element.getStartdate();
			LocalDate enddate = element.getEnddate();
			String shiftcode = "Leave";

			if (startdate.isAfter(enddate)) {
				throw new IllegalStateException("start date must be before or equal to end date");
			}

			while (!startdate.isAfter(enddate)) {
				allleaveDates.add(startdate);
				startdate = startdate.plusDays(1);

				LeaveRequest leaveRequest = new LeaveRequest();
				Id++;
				ShiftDate firstDate = shiftDateMap.get(startdate.minusDays(1));
				LocalDate pairdate = startdate.minusDays(1);
				Shift shift = dateAndShiftTypeToShiftMap.get(Pair.of(pairdate, shiftcode));
				leaveRequest.setId(Id);
				leaveRequest.setShift(shift);
				leaveRequest.setWeight(1);
				leaveRequest.setEmployee(employee);
				leaveRequest.setStartshiftDate(firstDate);
				if (firstDate != null) {
					shift.setRequiredEmployeeSize(shift.getRequiredEmployeeSize() + 1);
				}
				leaveRequestList.add(leaveRequest);
				employee.getLeaveMap().put(shift, leaveRequest);

			}

		}
		nurseRoster.setLeaveRequestList(leaveRequestList);
	}

	private void readTrainingRequest(NurseRoster nurseRoster) {

		List<TrainingRequest> trainingRequestList;
		List<TrainingData> trainingElementList = (List<TrainingData>) rosterService.listTrainingData();

		trainingRequestList = new ArrayList<>(trainingElementList.size());

		for (TrainingData element : trainingElementList) {

			long Id = element.getId();

			LocalDate date1 = element.getDate();
			String empname = element.getEmployee().getName();
			Employee employee = employeeMap.get(empname);
			ShiftDate shiftDate = shiftDateMap.get(date1);
			String shiftcode = element.getShiftType();
			Shift shift = dateAndShiftTypeToShiftMap.get(Pair.of(date1, shiftcode));
			TrainingRequest training = new TrainingRequest();
			training.setId(Id);
			training.setShift(shift);
			training.setWeight(10);
			training.setEmployee(employee);
			training.setShiftDate(shiftDate);
			if (shiftDate != null) {
				shift.setRequiredEmployeeSize(shift.getRequiredEmployeeSize() + 1);
			}
			trainingRequestList.add(training);
			employee.getTrainingRequestMap().put(shift, training);

		}

		nurseRoster.setTrainingRequestList(trainingRequestList);

	}

	private void readRequiredEmployeeSizes(NurseRoster nurseRoster) {

		List<CoverRequirements> coverRequirementElementList = (List<CoverRequirements>) rosterService
				.listCoverRequirements();
		for (CoverRequirements element : coverRequirementElementList) {
			String type = element.getShiftType().getCode();
			DayOfWeek day = element.getDayOfWeek();
			int req = element.getRequiredEmployeesize();
			ShiftType shiftType = shiftTypeMap.get(type);
			Pair<DayOfWeek, ShiftType> key = Pair.of(day, shiftType);

			List<Shift> shiftList = dayOfWeekAndShiftTypeToShiftListMap.get(key);

			for (Shift shift : shiftList) {
				shift.setRequiredEmployeeSize(shift.getRequiredEmployeeSize() + req);

			}
		}

	}

	private void createShiftAssignmentList(NurseRoster nurseRoster) {
		List<Shift> shiftList = nurseRoster.getShiftList();
		List<ShiftAssignment> shiftAssignmentList = new ArrayList<>(shiftList.size());
		long id = 0L;
		for (Shift shift : shiftList) {
			for (int i = 0; i < shift.getRequiredEmployeeSize(); i++) {
				ShiftAssignment shiftAssignment = new ShiftAssignment();
				shiftAssignment.setId(id);
				id++;
				shiftAssignment.setShift(shift);
				shiftAssignment.setIndexInShift(i);
				// Notice that we leave the PlanningVariable properties on null
				shiftAssignmentList.add(shiftAssignment);
			}
		}

		nurseRoster.setShiftAssignmentList(shiftAssignmentList);

	}

	// loads the database for use with the calendar and reporting
	public void createCalander(NurseRoster calendar) {

		List<ShiftAssignment> assignments = (List<ShiftAssignment>) calendar.getShiftAssignmentList();
		List<CalendarData> shiftAssignmentList = new ArrayList<>(assignments.size());
		ObservableList<CalendarData> calendardata = FXCollections.observableArrayList();
		for (ShiftAssignment assign : assignments) {
			long empid = (assign.getId());
			String employeename = assign.getEmployee().getName();
			String shiftType = assign.getShiftType().getCode();
			String shiftDescription = assign.getShiftType().getDescription();
			String startTime = assign.getShiftType().getStartTimeString();
			String endTime = assign.getShiftType().getEndTimeString();
			LocalDate shiftDate = assign.getShiftDate().getDate();
			Boolean isNight = assign.getShiftType().isNight();
			CalendarData asignmentdata = new CalendarData();
			asignmentdata.setEmployeename(employeename);
			asignmentdata.setEndTime(endTime);
			asignmentdata.setId(empid);
			asignmentdata.setNight(isNight);
			asignmentdata.setShiftDate(shiftDate);
			asignmentdata.setShiftDescription(shiftDescription);
			asignmentdata.setShiftType(shiftType);
			asignmentdata.setStartTIme(startTime);
			calendardata.add(asignmentdata);
			shiftAssignmentList.add(asignmentdata);
			rosterService.addCalendarData(asignmentdata);
		}

	}

}