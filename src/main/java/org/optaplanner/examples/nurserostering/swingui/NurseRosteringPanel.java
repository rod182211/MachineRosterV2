package org.optaplanner.examples.nurserostering.swingui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import static java.time.temporal.ChronoUnit.DAYS;
import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang3.tuple.Pair;
import org.optaplanner.examples.nurserostering.domain.CoverRequirements;
import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.NurseRoster;
import org.optaplanner.examples.nurserostering.domain.NurseRosterParametrization;
import org.optaplanner.examples.nurserostering.domain.Shift;
import org.optaplanner.examples.nurserostering.domain.ShiftAssignment;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;
import org.optaplanner.examples.nurserostering.domain.ShiftType;

import org.optaplanner.examples.nurserostering.domain.Skill;
import org.optaplanner.examples.nurserostering.domain.contract.Contract;
import org.optaplanner.examples.nurserostering.domain.pattern.Pattern;

import org.optaplanner.examples.nurserostering.domain.request.DayOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.DayOnRequest;
import org.optaplanner.examples.nurserostering.domain.request.HolidayRequest;
import org.optaplanner.examples.nurserostering.domain.request.LeaveRequest;
import org.optaplanner.examples.nurserostering.domain.request.RosterDay;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOffRequest;
import org.optaplanner.examples.nurserostering.domain.request.ShiftOnRequest;
import org.optaplanner.examples.nurserostering.domain.request.TrainingRequest;
import org.optaplanner.examples.pool.DayOffDate;

import org.optaplanner.examples.pool.DayOnDate;
import org.optaplanner.examples.pool.HolidaysData;
import org.optaplanner.examples.pool.LeaveData;
import org.optaplanner.examples.pool.RosterDayOff;
import org.optaplanner.examples.pool.ShiftOffDate;
import org.optaplanner.examples.pool.ShiftOnDate;
import org.optaplanner.examples.pool.TrainingData;
import org.optaplanner.database.RosterService;
import org.optaplanner.database.RosterServiceImpl;
import org.optaplanner.examples.common.swingui.SolutionPanel;

public class NurseRosteringPanel extends SolutionPanel<NurseRoster> {

	public static final String LOGO_PATH = "/org/optaplanner/examples/nurserostering/swingui/nurseRosteringLogo.png";

	protected Map<LocalDate, ShiftDate> shiftDateMap;
	protected Map<ShiftDate, LocalDate> localDateMap;
	protected Map<String, Skill> skillMap;
	protected Map<String, ShiftType> shiftTypeMap;
	protected Map<Pair<LocalDate, String>, Shift> dateAndShiftTypeToShiftMap;
	protected Map<Pair<DayOfWeek, ShiftType>, List<Shift>> dayOfWeekAndShiftTypeToShiftListMap;
	protected Map<String, Pattern> patternMap;
	protected Map<String, Contract> contractMap;
	protected Map<String, Employee> employeeMap;
//protected Map<ShiftAssignment, Integer> frequencyMap = new HashMap<>();
	// private final ImageIcon employeeIcon;
	private RosterService rosterService = new RosterServiceImpl();
	private final ImageIcon deleteEmployeeIcon;

	private JPanel employeeListPanel;
	private JTextField planningWindowStartField;
	private AbstractAction advancePlanningWindowStartAction;
	private EmployeePanel unassignedPanel;
	private Map<Employee, EmployeePanel> employeeToPanelMap;



	

	public NurseRosteringPanel() {
		// employeeIcon = new ImageIcon(getClass().getResource("employee.png"));
		deleteEmployeeIcon = new ImageIcon(getClass().getResource("deleteEmployee.png"));
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		createEmployeeListPanel();
		JPanel headerPanel = createHeaderPanel();
		layout.setHorizontalGroup(
				layout.createParallelGroup().addComponent(headerPanel).addComponent(employeeListPanel));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addComponent(employeeListPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
						GroupLayout.PREFERRED_SIZE));
	}
	// Removed ICON TODO replaced with what I want
	// public ImageIcon getEmployeeIcon() {
	// return employeeIcon;
	// }

	public ImageIcon getDeleteEmployeeIcon() {
		return deleteEmployeeIcon;
	}

	private JPanel createHeaderPanel() {
		JPanel headerPanel = new JPanel(new BorderLayout(20, 0));
		JPanel planningWindowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		planningWindowPanel.add(new JLabel("Planning window start:"));
		planningWindowStartField = new JTextField(10);
		planningWindowStartField.setEditable(false);
		planningWindowPanel.add(planningWindowStartField);
		advancePlanningWindowStartAction = new AbstractAction("Advance 14 days ") {

			@Override
			public void actionPerformed(ActionEvent e) {
				advancePlanningWindowStart();
			}
		};
		advancePlanningWindowStartAction.setEnabled(false);
		planningWindowPanel.add(new JButton(advancePlanningWindowStartAction));
		headerPanel.add(planningWindowPanel, BorderLayout.WEST);
		JLabel shiftTypeExplanation = new JLabel("E = Early shift, D = Day, L = Late shift,N = Night");
		headerPanel.add(shiftTypeExplanation, BorderLayout.CENTER);
		return headerPanel;
	}

	private void createEmployeeListPanel() {
		employeeListPanel = new JPanel();
		employeeListPanel.setLayout(new BoxLayout(employeeListPanel, BoxLayout.Y_AXIS));
		unassignedPanel = new EmployeePanel(this, Collections.<ShiftDate>emptyList(), Collections.<Shift>emptyList(),
				null);
		employeeListPanel.add(unassignedPanel);
		employeeToPanelMap = new LinkedHashMap<>();
		employeeToPanelMap.put(null, unassignedPanel);
	}

	@Override
	public void resetPanel(NurseRoster nurseRoster) {
		for (EmployeePanel employeePanel : employeeToPanelMap.values()) {
			if (employeePanel.getEmployee() != null) {
				employeeListPanel.remove(employeePanel);
			}
		}
		employeeToPanelMap.clear();
		employeeToPanelMap.put(null, unassignedPanel);
		unassignedPanel.clearShiftAssignments();
		preparePlanningEntityColors(nurseRoster.getShiftAssignmentList());
		List<ShiftDate> shiftDateList = nurseRoster.getShiftDateList();
		List<Shift> shiftList = nurseRoster.getShiftList();
		unassignedPanel.setShiftDateListAndShiftList(shiftDateList, shiftList);
		updatePanel(nurseRoster);
		advancePlanningWindowStartAction.setEnabled(true);
		planningWindowStartField
				.setText(nurseRoster.getNurseRosterParametrization().getPlanningWindowStart().getLabel());
	}

	@Override
	public void updatePanel(NurseRoster nurseRoster) {
		preparePlanningEntityColors(nurseRoster.getShiftAssignmentList());
		List<ShiftDate> shiftDateList = nurseRoster.getShiftDateList();
		List<Shift> shiftList = nurseRoster.getShiftList();
		List<LocalDate> allDates = null;
		Set<Employee> deadEmployeeSet = new LinkedHashSet<>(employeeToPanelMap.keySet());
		deadEmployeeSet.remove(null);
		for (Employee employee : nurseRoster.getEmployeeList()) {
			deadEmployeeSet.remove(employee);
			EmployeePanel employeePanel = employeeToPanelMap.get(employee);
			if (employeePanel == null) {
				employeePanel = new EmployeePanel(this, shiftDateList, shiftList, employee);
				employeeListPanel.add(employeePanel);
				employeeToPanelMap.put(employee, employeePanel);
			}
			employeePanel.clearShiftAssignments();
		}
		unassignedPanel.clearShiftAssignments();
		for (ShiftAssignment shiftAssignment : nurseRoster.getShiftAssignmentList()) {
			Employee employee = shiftAssignment.getEmployee();
			EmployeePanel employeePanel = employeeToPanelMap.get(employee);
			employeePanel.addShiftAssignment(shiftAssignment);
		}
		for (Employee deadEmployee : deadEmployeeSet) {
			EmployeePanel deadEmployeePanel = employeeToPanelMap.remove(deadEmployee);
			employeeListPanel.remove(deadEmployeePanel);
		}
		for (EmployeePanel employeePanel : employeeToPanelMap.values()) {
			employeePanel.update();
		}
	}

	@Override
	public boolean isIndictmentHeatMapEnabled() {
		return true;
	}

	private <PatternList> void advancePlanningWindowStart() {
		logger.info("Advancing planningWindowStart.");
		if (solutionBusiness.isSolving()) {
			JOptionPane.showMessageDialog(this.getTopLevelAncestor(),
					"The GUI does not support this action yet during solving."
							+ "\nTerminate solving first and try again.",
					"Unsupported in GUI", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		doProblemFactChange(scoreDirector -> {
			NurseRoster nurseRoster = scoreDirector.getWorkingSolution();
			NurseRosterParametrization nurseRosterParametrization = nurseRoster.getNurseRosterParametrization();
			List<ShiftDate> shiftDateList = nurseRoster.getShiftDateList();
			Shift oldLastShift = nurseRoster.getShiftList().get(nurseRoster.getShiftList().size() - 1);
			long shiftId = oldLastShift.getId() + 1L;
			int shiftIndex = oldLastShift.getIndex() + 1;
			ShiftDate oldLastShiftDate = shiftDateList.get(shiftDateList.size() - 1);
			long shiftDateId = (oldLastShiftDate.getId() + 1L);
			int shiftDayIndex = (oldLastShiftDate.getDayIndex() + 1);

			scoreDirector.beforeProblemPropertyChanged(nurseRosterParametrization);

			// Update to get the first day along with adding 14 days to the run
			LocalDate startDate = (oldLastShiftDate.getDate().plusDays(1));
			LocalDate endDate = (oldLastShiftDate.getDate().plusDays(14));
			int maxDayIndex = Math.toIntExact(DAYS.between(startDate, endDate));
			int shiftDateSize = maxDayIndex + 1;
			List<ShiftDate> newshiftdateList = new ArrayList<>(shiftDateSize);
			shiftDateMap = new HashMap<>(shiftDateSize);
			LocalDate date = startDate;
			for (int i = 0; i < shiftDateSize; i++) {
				ShiftDate shiftDate = new ShiftDate();
				shiftDate.setId(shiftDateId);
				shiftDate.setDayIndex(shiftDayIndex);
				shiftDate.setDate(date);
				shiftDate.setShiftList(new ArrayList<>());
				shiftDateMap.put(date, shiftDate);
				shiftDateId++;
				shiftDayIndex++;
				date = date.plusDays(1);
				nurseRoster.getShiftDateList().add(shiftDate);
				newshiftdateList.add(shiftDate);
				scoreDirector.afterProblemFactAdded(shiftDate);
			}
		
			
			List<Contract> contractElementList = (List<Contract>)nurseRoster.getContractList();

			List<Contract> contractList = new ArrayList<>(
					contractElementList.size());

			contractMap = new HashMap<>(contractElementList.size());


			List<Employee> employeeElementList = (List<Employee>) nurseRoster.getEmployeeList();
			List<Employee> employeeList = new ArrayList<>(
					employeeElementList.size());
			employeeMap = new HashMap<>(employeeElementList.size());
			for (Employee element : employeeElementList) {
				long id = element.getId();
				String name = element.getName();
				String code = element.getCode();
				Contract c = scoreDirector.lookUpWorkingObject(element.getContract());
			//	Contract c = contractMap.get(element.getContract().getCode());
				Employee employee = new Employee();
				employee.setId(id);
				employee.setName(name);
				employee.setCode(code);
				employee.setContract(c);
				Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
				employeeList.add(workingEmployee);
				employeeMap.put(workingEmployee.getName(), workingEmployee);
				
			}
			/*ShiftTypeSkillRequirement oldshifttypeskill = nurseRoster.getShiftTypeSkillRequirementList()
							.get(nurseRoster.getShiftTypeSkillRequirementList().size() - 1);
				long shiftTypeSkillRequirementId =  oldshifttypeskill.getId() + 1L;
			List<ShiftTypeSkillRequirement> coverRequirementElementList = (List<ShiftTypeSkillRequirement>) rosterService
					.listShiftTypeSkillRequirement();*/
			List<ShiftType> shiftTypeElementList = (List<ShiftType>) nurseRoster.getShiftTypeList();
			List<ShiftType> shiftTypeList = new ArrayList<>(shiftTypeElementList.size());
			shiftTypeMap = new HashMap<>(shiftTypeElementList.size());
			int index = 0;
			/*
			 * List<ShiftTypeSkillRequirement> shiftTypeSkillRequirementList = new
			 * ArrayList<>( shiftTypeElementList.size() * 2);
			 */
			for (ShiftType shiftelement : shiftTypeElementList) {
				ShiftType shiftType = new ShiftType();
				long Id = shiftelement.getId();
				shiftType.setId(Id);
				shiftType.setCode(shiftelement.getCode());
				shiftType.setIndex(index);
				String startTimeString = shiftelement.getStartTimeString();
				shiftType.setStartTimeString(startTimeString);
				String endTimeString = shiftelement.getEndTimeString();
				shiftType.setEndTimeString(endTimeString);
				shiftType.setNight(startTimeString.compareTo(endTimeString) > 0);
				shiftType.setDescription(shiftelement.getDescription());
				ShiftType shiftTypenew = scoreDirector.lookUpWorkingObject(shiftType);
				shiftTypeList.add(shiftTypenew);
				if (shiftTypeMap.containsKey(shiftTypenew.getCode())) {
					throw new IllegalArgumentException(
							"There are 2 shiftTypes with the same code (" + shiftTypenew.getCode() + ").");
				}
				shiftTypeMap.put(shiftTypenew.getCode(), shiftTypenew);

				index++;
			}
			/*for (ShiftTypeSkillRequirement skillElement : coverRequirementElementList) {
				ShiftTypeSkillRequirement shiftTypeSkillRequirement = new ShiftTypeSkillRequirement();
				shiftTypeSkillRequirement.setId(shiftTypeSkillRequirementId);
				ShiftType type = skillElement.getShiftType();
				shiftTypeSkillRequirement.setShiftType(type);
				Skill skill = skillElement.getSkill();
				Skill skillupdate = scoreDirector.lookUpWorkingObject(skill);
			//	scoreDirector.afterProblemFactAdded(shiftTypeSkillRequirement);
				if (skill == null) {
					throw new IllegalArgumentException("The skill (" + skillElement.getSkill().getCode()
							+ ") of shiftType (" + type.getCode() + ") does not exist.");
				}
				shiftTypeSkillRequirement.setSkill(skillupdate);
				shiftTypeSkillRequirementList.add(shiftTypeSkillRequirement);
				shiftTypeSkillRequirementId++;
			}*/

			nurseRoster.setShiftTypeList(shiftTypeList);
			//nurseRoster.setShiftTypeSkillRequirementList(shiftTypeSkillRequirementList);

			int shiftListSize = shiftDateMap.size() * shiftTypeList.size();

			List<Shift> shiftList1 = new ArrayList<>(shiftListSize);
			dateAndShiftTypeToShiftMap = new HashMap<>(shiftListSize);
			dayOfWeekAndShiftTypeToShiftListMap = new HashMap<>(7 * shiftTypeList.size());

			for (ShiftDate shiftDate : newshiftdateList) {
				for (ShiftType shiftType : shiftTypeList) {
					Shift shift = new Shift();
					shift.setId(shiftId);
					shift.setShiftDate(shiftDate);
					shiftDate.getShiftList().add(shift);
					ShiftType type = scoreDirector.lookUpWorkingObject(shiftType);
					shift.setShiftType(type);
					shift.setIndex(shiftIndex);
					shift.setRequiredEmployeeSize(0); // Filled in later
					shiftList1.add(shift);
					dateAndShiftTypeToShiftMap.put(Pair.of(shiftDate.getDate(), type.getCode()), shift);
					addShiftToDayOfWeekAndShiftTypeToShiftListMap(shiftDate, type, shift);
					shiftId++;
					shiftIndex++;
					nurseRoster.getShiftList().add(shift);
					scoreDirector.afterProblemFactAdded(shift);

				}

			}

			List<DayOffRequest> dayOffRequestList;

			List<DayOffDate> dayOffElementList = rosterService.listDayOffDate();
			if (dayOffElementList.size() == 0) {

			}
			// In case there has not been a request yet
			else if (nurseRoster.getDayOffRequestList().size() == 0) {
				long dayoffId = 1l;
				dayOffRequestList = new ArrayList<>(dayOffElementList.size());
				for (DayOffDate element : dayOffElementList) {
					DayOffRequest dayOffRequest = new DayOffRequest();
					dayoffId++;
					dayOffRequest.setId(dayoffId);
					int weight = element.getWeight();
					LocalDate shiftDate = element.getDate();
					ShiftDate dateoff = shiftDateMap.get(shiftDate);
					Employee employee = element.getEmployee();
					Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
					dayOffRequest.setWeight(weight);
					dayOffRequest.setEmployee(workingEmployee);
					dayOffRequest.setShiftDate(dateoff);
					dayOffRequestList.add(dayOffRequest);
					workingEmployee.getDayOffRequestMap().put(dateoff, dayOffRequest);
					nurseRoster.getDayOffRequestList().add(dayOffRequest);

				}
			}

			else {
				DayOffRequest oldLastDayOffdate = nurseRoster.getDayOffRequestList()
						.get(nurseRoster.getDayOffRequestList().size() - 1);
				long dayoffId = (oldLastDayOffdate.getId() + 1L);
				dayOffRequestList = new ArrayList<>(dayOffElementList.size());
				for (DayOffDate element : dayOffElementList) {
					DayOffRequest dayOffRequest = new DayOffRequest();
					dayoffId++;
					dayOffRequest.setId(dayoffId);
					int weight = element.getWeight();
					LocalDate shiftDate = element.getDate();
					ShiftDate dateoff = shiftDateMap.get(shiftDate);
					Employee employee = element.getEmployee();
					Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
					dayOffRequest.setWeight(weight);
					dayOffRequest.setEmployee(workingEmployee);
					dayOffRequest.setShiftDate(dateoff);
					dayOffRequestList.add(dayOffRequest);
					workingEmployee.getDayOffRequestMap().put(dateoff, dayOffRequest);
					nurseRoster.getDayOffRequestList().add(dayOffRequest);
				}
			}

			List<DayOnRequest> dayOnRequestList;
			List<DayOnDate> dayOnElementList1 = rosterService.listDayOnDate();
			if (dayOnElementList1.size() == 0) {
			} else if (nurseRoster.getDayOnRequestList().size() == 0) {
				long dayonId = 1l;
				dayOnRequestList = new ArrayList<>(dayOnElementList1.size());
				for (DayOnDate element : dayOnElementList1) {
					DayOnRequest dayOnRequest = new DayOnRequest();
					int weight = element.getWeight();
					LocalDate localshiftDate = element.getDate();
					ShiftDate dateon = shiftDateMap.get(localshiftDate);
					Employee employee = element.getEmployee();
					Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
					dayonId++;
					dayOnRequest.setId(dayonId);
					dayOnRequest.setWeight(weight);
					dayOnRequest.setEmployee(workingEmployee);
					dayOnRequest.setShiftDate(dateon);
					dayOnRequestList.add(dayOnRequest);
					workingEmployee.getDayOnRequestMap().put(dateon, dayOnRequest);
					nurseRoster.getDayOnRequestList().add(dayOnRequest);
				}
			}

			else {
				DayOnRequest oldLastDayOndate = nurseRoster.getDayOnRequestList()
						.get(nurseRoster.getDayOnRequestList().size() - 1);
				long dayonId = (oldLastDayOndate.getId() + 1L);
				dayOffRequestList = new ArrayList<>(dayOffElementList.size());
				dayOnRequestList = new ArrayList<>(dayOnElementList1.size());
				for (DayOnDate element : dayOnElementList1) {
					DayOnRequest dayOnRequest = new DayOnRequest();
					int weight = element.getWeight();
					LocalDate localshiftDate = element.getDate();
					ShiftDate dateon = shiftDateMap.get(localshiftDate);
					Employee employee = element.getEmployee();
					Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
					dayonId++;
					dayOnRequest.setId(dayonId);
					dayOnRequest.setWeight(weight);
					dayOnRequest.setEmployee(workingEmployee);
					dayOnRequest.setShiftDate(dateon);
					dayOnRequestList.add(dayOnRequest);
					workingEmployee.getDayOnRequestMap().put(dateon, dayOnRequest);
					nurseRoster.getDayOnRequestList().add(dayOnRequest);
				}
			}

			List<LocalDate> allDates = new ArrayList<>();
			List<HolidayRequest> holidayRequestList;
			List<HolidaysData> holidayElementList = (List<HolidaysData>) rosterService.listHolidaysData();
			if (holidayElementList.size() == 0) {

			} else if (nurseRoster.getHolidayRequestList().size() == 0) {
				long holidayId = 1l;
				holidayRequestList = new ArrayList<>(holidayElementList.size());
				for (HolidaysData element : holidayElementList) {
					int weight = element.getWeight();
					Employee employee = element.getEmployee();
					Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
					LocalDate startdate = element.getStartdate();
					LocalDate enddate = element.getEnddate();
					if (startdate.isAfter(enddate)) {
						throw new IllegalStateException("start date must be before or equal to end date");
					}
					// Get all the dates between First and Last Date
					while (!startdate.isAfter(enddate)) {
						allDates.add(startdate);
						startdate = startdate.plusDays(1);
						HolidayRequest holidayRequest = new HolidayRequest();
						holidayRequest.setId(holidayId);
						holidayId++;
						holidayRequest.setEmployee(workingEmployee);
						ShiftDate firstDate = shiftDateMap.get(startdate.minusDays(1));
						holidayRequest.setStartshiftDate(firstDate);
						holidayRequest.setWeight(weight);
						holidayRequestList.add(holidayRequest);
						workingEmployee.getHolidayRequestMap().put(firstDate, holidayRequest);
						nurseRoster.getHolidayRequestList().add(holidayRequest);
					}
				}
			}

			else {
				List<LocalDate> allDates1 = new ArrayList<>();
				HolidayRequest oldLastholiday = nurseRoster.getHolidayRequestList()
						.get(nurseRoster.getHolidayRequestList().size() - 1);
				long holidayId = (oldLastholiday.getId() + 1L);
				holidayRequestList = new ArrayList<>(holidayElementList.size());
				for (HolidaysData element : holidayElementList) {
					int weight = element.getWeight();
					Employee employee = element.getEmployee();
					Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
					LocalDate startdate1 = element.getStartdate();
					LocalDate enddate = element.getEnddate();
					if (startdate1.isAfter(enddate)) {
						throw new IllegalStateException("start date must be before or equal to end date");
					}
					while (!startdate1.isAfter(enddate)) {
						allDates1.add(startdate1);
						startdate1 = startdate1.plusDays(1);
						ShiftDate firstDate1 = shiftDateMap.get(startdate1.minusDays(1));
						HolidayRequest holidayRequest = new HolidayRequest();
						holidayRequest.setId(holidayId);
						holidayId++;
						holidayRequest.setEmployee(workingEmployee);
						holidayRequest.setStartshiftDate(firstDate1);
						holidayRequest.setWeight(weight);
						holidayRequestList.add(holidayRequest);
						workingEmployee.getHolidayRequestMap().put(firstDate1, holidayRequest);
						nurseRoster.getHolidayRequestList().add(holidayRequest);
					}
				}

			}
			List<ShiftOffRequest> shiftOffRequestList;
			List<ShiftOffDate> shiftOffElementList = (List<ShiftOffDate>) rosterService.listShiftOffDate();
			shiftOffRequestList = new ArrayList<>(shiftOffElementList.size());
			for (ShiftOffDate element : shiftOffElementList) {
				ShiftOffRequest shiftOffRequest = new ShiftOffRequest();
				long ShiftonId = element.getId();
				int weight = element.getWeight();
				Employee employee = element.getEmployee();
				Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
				LocalDate date1 = element.getDate();
				String shiftcode = element.getShiftType().getCode();
				Shift shift = dateAndShiftTypeToShiftMap.get(Pair.of(date1, shiftcode));
				shiftOffRequest.setId(ShiftonId);
				shiftOffRequest.setEmployee(workingEmployee);
				shiftOffRequest.setShift(shift);
				shiftOffRequest.setWeight(weight);
				shiftOffRequestList.add(shiftOffRequest);
				workingEmployee.getShiftOffRequestMap().put(shift, shiftOffRequest);
				nurseRoster.setShiftOffRequestList(shiftOffRequestList);
			}
			
			
			List<ShiftOnRequest> shiftOnRequestList;
			List<ShiftOnDate> shiftOnElementList = (List<ShiftOnDate>) rosterService.listShiftOnDate();
			shiftOnRequestList = new ArrayList<>(shiftOnElementList.size());
			for (ShiftOnDate element : shiftOnElementList) {
				ShiftOnRequest shiftOnRequest = new ShiftOnRequest();
				long ShiftonId = element.getId();
				int weight = element.getWeight();
				Employee employee = element.getEmployee();
				Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
				LocalDate date1 = element.getDate();
				String shiftcode = element.getShiftType().getCode();
				Shift shift = dateAndShiftTypeToShiftMap.get(Pair.of(date1, shiftcode));
				shiftOnRequest.setId(ShiftonId);
				shiftOnRequest.setEmployee(workingEmployee);
				shiftOnRequest.setShift(shift);
				shiftOnRequest.setWeight(weight);
				shiftOnRequestList.add(shiftOnRequest);
				workingEmployee.getShiftOnRequestMap().put(shift, shiftOnRequest);
				nurseRoster.setShiftOnRequestList(shiftOnRequestList);

			}
			
			List<RosterDay> rosterOffRequestList;
			List<RosterDayOff> rosterOffElementList = (List<RosterDayOff>) rosterService
					.listRosterDayOff();
			rosterOffRequestList = new ArrayList<>(rosterOffElementList.size());
			
			for (RosterDayOff element : rosterOffElementList) {

				long Id = element.getId();
			
				LocalDate date1 = element.getDate();
				Employee employee = element.getEmployee();
				Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
				ShiftDate shiftDate = shiftDateMap.get(date1);
				String shiftcode = "ADO";
				Shift shift = dateAndShiftTypeToShiftMap
						.get(Pair.of(date1, shiftcode));
				RosterDay rosterOff = new RosterDay();
				rosterOff.setId(Id);
				rosterOff.setShift(shift);
				rosterOff.setWeight(10);
				rosterOff.setEmployee(workingEmployee);
				rosterOff.setShiftDate(shiftDate);
				if(shiftDate != null) {
					shift.setRequiredEmployeeSize(
							shift.getRequiredEmployeeSize() + 1);
					}
				rosterOffRequestList.add(rosterOff);
				workingEmployee.getRosterdayMap().put(shift, rosterOff);
				nurseRoster.setRosterOffRequestList(rosterOffRequestList);

			}
			
			
			
			List<TrainingRequest> trainingRequestList;
			List<TrainingData> trainingElementList = (List<TrainingData>) rosterService.listTrainingData();
					

			trainingRequestList = new ArrayList<>(trainingElementList.size());
			
			for (TrainingData element : trainingElementList) {

				long Id = element.getId();
			
				LocalDate date1 = element.getDate();
				Employee employee = element.getEmployee();
				Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
				ShiftDate shiftDate = shiftDateMap.get(date1);
				String shiftcode = element.getShiftType();
				Shift shift1 = dateAndShiftTypeToShiftMap.get(Pair.of(date1, shiftcode));
				TrainingRequest training = new TrainingRequest();
				training.setId(Id);
				training.setShift(shift1);
				training.setWeight(10);
				training.setEmployee(workingEmployee);
				training.setShiftDate(shiftDate);
				if(shift1 != null && shiftDate != null) {
					shift1.setRequiredEmployeeSize(
							shift1.getRequiredEmployeeSize() + 1);
					}
				trainingRequestList.add(training);
				workingEmployee.getTrainingRequestMap().put(shift1, training);
				nurseRoster.setTrainingRequestList(trainingRequestList);

			}
			
			
			List<LocalDate> allleaveDates = new ArrayList<>();
			List<LeaveRequest> leaveRequestList;
			
			List<LeaveData> leaveElementList = (List<LeaveData>) rosterService
					.listLeaveData();
			leaveRequestList = new ArrayList<>(leaveElementList.size());
			if (leaveElementList.size() == 0) {

			}
		 else if (nurseRoster.getLeaveRequestList().size() == 0) {
			long Id = 1l;
			for (LeaveData element : leaveElementList) {
							
				Employee employee = element.getEmployee();
				Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
				LocalDate startdate = element.getStartdate();
				LocalDate enddate = element.getEnddate();
				String shiftcode = "Leave";
				
				if (startdate.isAfter(enddate)) {
					throw new IllegalStateException(
							"start date must be before or equal to end date");
				}

				while (!startdate.isAfter(enddate)) {
					allleaveDates.add(startdate);
					startdate= startdate.plusDays(1);
					
					LeaveRequest leaveRequest = new LeaveRequest();
					Id++;
					ShiftDate firstDate = shiftDateMap.get(startdate.minusDays(1));
					LocalDate pairdate = startdate.minusDays(1);
					Shift shift = dateAndShiftTypeToShiftMap
							.get(Pair.of(pairdate, shiftcode));
					leaveRequest.setId(Id);
					leaveRequest.setShift(shift);
					leaveRequest.setWeight(10);
					leaveRequest.setEmployee(workingEmployee);
					leaveRequest.setStartshiftDate(firstDate);
					if(firstDate != null) {
					shift.setRequiredEmployeeSize(
					shift.getRequiredEmployeeSize() + 1);
						}
					leaveRequestList.add(leaveRequest);
					workingEmployee.getLeaveMap().put(shift, leaveRequest);
					
				}
			

			nurseRoster.setLeaveRequestList(leaveRequestList);
		}
		}
		 else {
				
				LeaveRequest oldLastleave = nurseRoster.getLeaveRequestList()
						.get(nurseRoster.getLeaveRequestList().size() - 1);
				long leaveId = (oldLastleave.getId() + 1L);
			for (LeaveData element : leaveElementList) {
				
				Employee employee = element.getEmployee();
				Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
				LocalDate startdate = element.getStartdate();
				LocalDate enddate = element.getEnddate();
				String shiftcode = "Leave";
				
				if (startdate.isAfter(enddate)) {
					throw new IllegalStateException(
							"start date must be before or equal to end date");
				}

				while (!startdate.isAfter(enddate)) {
					allleaveDates.add(startdate);
					startdate= startdate.plusDays(1);
					
					LeaveRequest leaveRequest = new LeaveRequest();
					ShiftDate firstDate = shiftDateMap.get(startdate.minusDays(1));
					LocalDate pairdate = startdate.minusDays(1);
					Shift shift = dateAndShiftTypeToShiftMap
							.get(Pair.of(pairdate, shiftcode));
					leaveRequest.setId(leaveId);
					leaveId++;
					leaveRequest.setShift(shift);
					leaveRequest.setWeight(10);
					leaveRequest.setEmployee(workingEmployee);
					leaveRequest.setStartshiftDate(firstDate);
					if(firstDate != null) {
					shift.setRequiredEmployeeSize(
					shift.getRequiredEmployeeSize() + 1);
						}
					leaveRequestList.add(leaveRequest);
					workingEmployee.getLeaveMap().put(shift, leaveRequest);
					
				}
			

			nurseRoster.setLeaveRequestList(leaveRequestList);
		}
		 }
			List<CoverRequirements> coverRequirementElementList1 = (List<CoverRequirements>) rosterService
					.listCoverRequirements();
			
			for (CoverRequirements element : coverRequirementElementList1) {
				String type = element.getShiftType().getCode();
				ShiftType shiftTypen = shiftTypeMap.get(type);
				//ShiftType typeshift = scoreDirector.lookUpWorkingObject(shiftTypen);
				DayOfWeek day = element.getDayOfWeek();
				int req = element.getRequiredEmployeesize();
				Pair<DayOfWeek, ShiftType> key = Pair.of(day, shiftTypen);
				List<Shift> shiftList = dayOfWeekAndShiftTypeToShiftListMap.get(key);

				for (Shift shift : shiftList) {
					shift.setRequiredEmployeeSize(shift.getRequiredEmployeeSize() + req);
				}
			}
			List<ShiftAssignment> shiftAssignmentList = new ArrayList<>(shiftList1.size());
			long shiftAssignmentId = nurseRoster.getShiftAssignmentList()
					.get(nurseRoster.getShiftAssignmentList().size() - 1).getId() + 1L;
			for (Shift shift : shiftList1) {
				for (int i = 0; i < shift.getRequiredEmployeeSize(); i++) {
					ShiftAssignment newShiftAssignment = new ShiftAssignment();
					newShiftAssignment.setId(shiftAssignmentId);
					shiftAssignmentId++;
					newShiftAssignment.setShift(shift);
					newShiftAssignment.setIndexInShift(i);
					shiftAssignmentList.add(newShiftAssignment);
					nurseRoster.getShiftAssignmentList().add(newShiftAssignment);
					scoreDirector.afterEntityAdded(newShiftAssignment);
				}
			}
			// This should move the planning window
			nurseRosterParametrization.setFirstShiftDate(newshiftdateList.get(0));
			nurseRosterParametrization.setLastShiftDate(newshiftdateList.get(newshiftdateList.size() - 1));
			nurseRosterParametrization.setPlanningWindowStart(newshiftdateList.get(0));
			nurseRoster.setNurseRosterParametrization(nurseRosterParametrization);
			scoreDirector.afterProblemPropertyChanged(nurseRosterParametrization);
		

		}, true);
	}


	private void addShiftToDayOfWeekAndShiftTypeToShiftListMap(ShiftDate shiftDate, ShiftType shiftType, Shift shift) {
		Pair<DayOfWeek, ShiftType> key = Pair.of(shiftDate.getDayOfWeek(), shiftType);
		List<Shift> dayOfWeekAndShiftTypeToShiftList = dayOfWeekAndShiftTypeToShiftListMap.computeIfAbsent(key,
				k -> new ArrayList<>((shiftDateMap.size() + 6) / 7));
		dayOfWeekAndShiftTypeToShiftList.add(shift);
	}

	public void deleteEmployee(final Employee employee) {
		logger.info("Scheduling delete of employee ({}).", employee);
		doProblemFactChange(scoreDirector -> {
			NurseRoster nurseRoster = scoreDirector.getWorkingSolution();
			Employee workingEmployee = scoreDirector.lookUpWorkingObject(employee);
			if (workingEmployee == null) {
				// The employee has already been deleted (the UI asked to
				// changed the same
				// employee twice), so do nothing
				return;
			}

			// First remove the problem fact from all planning entities that use
			// it
			for (ShiftAssignment shiftAssignment : nurseRoster.getShiftAssignmentList()) {
				if (shiftAssignment.getEmployee() == workingEmployee) {
					scoreDirector.beforeVariableChanged(shiftAssignment, "employee");
					shiftAssignment.setEmployee(null);
					scoreDirector.afterVariableChanged(shiftAssignment, "employee");
				}
			}
			// A SolutionCloner does not clone problem fact lists (such as
			// employeeList)
			// Shallow clone the employeeList so only workingSolution is
			// affected, not
			// bestSolution or guiSolution
			ArrayList<Employee> employeeList = new ArrayList<>(nurseRoster.getEmployeeList());
			nurseRoster.setEmployeeList(employeeList);
			// Remove it the problem fact itself
			scoreDirector.beforeProblemFactRemoved(workingEmployee);
			employeeList.remove(workingEmployee);
			scoreDirector.afterProblemFactRemoved(workingEmployee);

			scoreDirector.triggerVariableListeners();

		});
	}

	public void moveShiftAssignmentToEmployee(ShiftAssignment shiftAssignment, Employee toEmployee) {
		solutionBusiness.doChangeMove(shiftAssignment, "employee", toEmployee);
		solverAndPersistenceFrame.resetScreen();
	}

}