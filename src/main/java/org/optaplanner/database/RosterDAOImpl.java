package org.optaplanner.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
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

public class RosterDAOImpl implements RosterDAO {

	private static Session session;

	@Override
	public void addEmployee(Employee employee) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();

		session.close();

	}

	@Override
	public List<Employee> listEmployee() {
		List<Employee> list = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		list = session.createQuery("from Employee").list();
		session.getTransaction().commit();

		session.close();
		return list;
	}

	@Override
	public void removeEmployee(Employee itemsSelected) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(itemsSelected);		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateEmployee(Employee employee) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<Employee> listEmployeename() {
		List<Employee> employeenamelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		employeenamelist = session.createQuery("select name from Employee").list();
		session.getTransaction().commit();

		session.close();
		return employeenamelist;
	}
	// not sure what I am doing with this yet. It is not adding another user

	@Override
	public void insertEmployee(Employee employee) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("insert into Employee (skillIdplus)");
		session.update(employee);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<Employee> listEmployeeId(long empid) {
		List<Employee> empidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		empidlist = session.createQuery("select empid from Employee ").list();
		session.getTransaction().commit();

		session.close();
		return empidlist;
	}

	@Override
	public List<Skill> listSkill() {
		List<Skill> skillslist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		skillslist = session.createQuery("from Skill").list();
		session.getTransaction().commit();

		session.close();
		return skillslist;
	}

	@Override
	public List<Skill> listSkillId() {
		List<Skill> skillsidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		skillsidlist = session.createQuery("select id from Skill").list();
		session.getTransaction().commit();

		session.close();
		return skillsidlist;
	}

	@Override
	public List<Skill> listSkillcode() {
		List<Skill> skillscodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		skillscodelist = session.createQuery("select code from Skill").list();
		session.getTransaction().commit();

		session.close();
		return skillscodelist;
	}

	@Override
	public void addSkill(Skill skills) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(skills);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeSkill(ObservableList<Skill> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (Skill idvalue : itemsSelected) {
			long id = idvalue.getId();
			Skill s = (Skill) session.load(Skill.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateSkill(Skill skills) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(skills);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<Contract> listContract() {
		List<Contract> contractlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		contractlist = session.createQuery("from Contract").list();
		session.getTransaction().commit();

		session.close();
		return contractlist;
	}

	@Override
	public List<Contract> listContractId() {
		List<Contract> contractidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		contractidlist = session.createQuery("select id from Contract").list();
		session.getTransaction().commit();

		session.close();
		return contractidlist;
	}

	@Override
	public void addContract(Contract contract) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(contract);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeContract(ObservableList<Contract> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (Contract idvalue : itemsSelected) {
			long id = idvalue.getId();
			Contract s = (Contract) session.load(Contract.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateContract(Contract contract) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(contract);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<Contract> listContractcode() {
		List<Contract> contractcodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		contractcodelist = session.createQuery("select code from Contract").list();
		session.getTransaction().commit();

		session.close();
		return contractcodelist;
	}

	@Override
	public void addRosterParametrizationData(RosterParametrizationData scheddates) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(scheddates);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<RosterParametrizationData> listRosterParametrizationData() {
		List<RosterParametrizationData> list = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		list = session.createQuery("from RosterParametrizationData").list();
		session.getTransaction().commit();

		session.close();
		return list;
	}

	@Override
	public void removeRosterParametrizationData(ObservableList<RosterParametrizationData> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (RosterParametrizationData idvalue : itemsSelected) {
			long id = idvalue.getId();
			RosterParametrizationData s = (RosterParametrizationData) session.load(RosterParametrizationData.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateRosterParametrizationData(RosterParametrizationData scheddates) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(scheddates);
		session.getTransaction().commit();

		session.close();
	}

	/*
	 * @Override public List<ShiftTypeSkillRequirement>
	 * listShiftTypeSkillRequirementId() { List<ShiftTypeSkillRequirement>
	 * shiftassignmentidlist = new ArrayList<>();
	 * 
	 * session = HibernateUtil.getSessionFactory().getCurrentSession();
	 * session.beginTransaction(); shiftassignmentidlist =
	 * session.createQuery("select id from ShiftTypeSkillRequirement").list();
	 * session.getTransaction().commit();
	 * 
	 * session.close(); return shiftassignmentidlist; }
	 */

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<ShiftTypeSkillRequirement>
	 * listShiftTypeSkillRequirementday() { List<ShiftTypeSkillRequirement>
	 * shiftassignmentdaylist = new ArrayList<>();
	 * 
	 * session = HibernateUtil.getSessionFactory().getCurrentSession();
	 * session.beginTransaction(); shiftassignmentdaylist =
	 * session.createQuery("select dayOfWeek from ShiftTypeSkillRequirement").list()
	 * ; session.getTransaction().commit();
	 * 
	 * session.close(); return shiftassignmentdaylist; }
	 * 
	 * @Override public void addShiftTypeSkillRequirement(ShiftTypeSkillRequirement
	 * shiftassignment) {
	 * 
	 * session = HibernateUtil.getSessionFactory().getCurrentSession();
	 * session.beginTransaction(); session.save(shiftassignment);
	 * session.getTransaction().commit();
	 * 
	 * session.close(); }
	 * 
	 * @Override public void
	 * removeShiftTypeSkillRequirement(ObservableList<ShiftTypeSkillRequirement>
	 * itemsSelected) {
	 * 
	 * session = HibernateUtil.getSessionFactory().getCurrentSession();
	 * session.beginTransaction(); for (ShiftTypeSkillRequirement idvalue :
	 * itemsSelected) { long id = idvalue.getId(); ShiftTypeSkillRequirement s =
	 * (ShiftTypeSkillRequirement) session.load(ShiftTypeSkillRequirement.class,
	 * id); session.delete(s); } session.getTransaction().commit();
	 * 
	 * session.close(); }
	 * 
	 * @Override public void
	 * updateShiftTypeSkillRequirement(ShiftTypeSkillRequirement shiftassignment) {
	 * 
	 * session = HibernateUtil.getSessionFactory().getCurrentSession();
	 * session.beginTransaction(); session.update(shiftassignment);
	 * session.getTransaction().commit();
	 * 
	 * session.close(); }
	 * 
	 * @Override public List<ShiftTypeSkillRequirement>
	 * listShiftTypeSkillRequirement() { List<ShiftTypeSkillRequirement>
	 * shiftassignmentlist = new ArrayList<>();
	 * 
	 * session = HibernateUtil.getSessionFactory().getCurrentSession();
	 * session.beginTransaction(); shiftassignmentlist =
	 * session.createQuery("from ShiftTypeSkillRequirement").list();
	 * session.getTransaction().commit();
	 * 
	 * session.close(); return shiftassignmentlist; }
	 * 
	 * @Override public List<ShiftTypeSkillRequirement>
	 * listShiftTypeSkillRequirementcode() { List<ShiftTypeSkillRequirement>
	 * assignmentcodelist = new ArrayList<>();
	 * 
	 * session = HibernateUtil.getSessionFactory().getCurrentSession();
	 * session.beginTransaction(); assignmentcodelist =
	 * session.createQuery("select code from ShiftTypeSkillRequirement").list();
	 * session.getTransaction().commit();
	 * 
	 * session.close(); return assignmentcodelist; }
	 */

	@Override
	public List<BooleanContractLine> listBooleanContractLine() {
		List<BooleanContractLine> booleandatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		booleandatalist = session.createQuery("from BooleanContractLine").list();
		session.getTransaction().commit();

		session.close();
		return booleandatalist;
	}

	@Override
	public List<BooleanContractLine> listBooleanContractLineId() {
		List<BooleanContractLine> booleandataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		booleandataidlist = session.createQuery("select id from BooleanContractLine").list();
		session.getTransaction().commit();

		session.close();
		return booleandataidlist;
	}

	@Override
	public void addBooleanContractLine(BooleanContractLine booleandata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(booleandata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeBooleanContractLine(ObservableList<BooleanContractLine> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (BooleanContractLine idvalue : itemsSelected) {
			long id = idvalue.getId();
			BooleanContractLine s = (BooleanContractLine) session.load(BooleanContractLine.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateBooleanContractLine(BooleanContractLine booleandata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(booleandata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<MinMaxContractLine> listMinMaxContractLine() {
		List<MinMaxContractLine> minmaxdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		minmaxdatalist = session.createQuery("from MinMaxContractLine").list();
		session.getTransaction().commit();

		session.close();
		return minmaxdatalist;
	}

	@Override
	public List<MinMaxContractLine> listMinMaxContractLineId() {
		List<MinMaxContractLine> minmaxdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		minmaxdataidlist = session.createQuery("select id from MinMaxContractLine").list();
		session.getTransaction().commit();

		session.close();
		return minmaxdataidlist;
	}

	@Override
	public void addMinMaxContractLine(MinMaxContractLine minmaxdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(minmaxdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeMinMaxContractLine(ObservableList<MinMaxContractLine> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (MinMaxContractLine idvalue : itemsSelected) {
			long id = idvalue.getId();
			MinMaxContractLine s = (MinMaxContractLine) session.load(MinMaxContractLine.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateMinMaxContractLine(MinMaxContractLine minmaxdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(minmaxdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<Pattern> listPattern() {
		List<Pattern> patternlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		patternlist = session.createQuery("from Pattern").list();
		session.getTransaction().commit();

		session.close();
		return patternlist;
	}

	@Override
	public List<Pattern> listPatternId() {
		List<Pattern> patterndataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		patterndataidlist = session.createQuery("select id from Pattern").list();
		session.getTransaction().commit();

		session.close();
		return patterndataidlist;
	}

	@Override
	public List<Pattern> listPatterncode() {
		List<Pattern> patterncodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		patterncodelist = session.createQuery("select code from Pattern").list();
		session.getTransaction().commit();

		session.close();
		return patterncodelist;
	}

	@Override
	public void addPattern(Pattern pattern) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(pattern);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removePattern(ObservableList<Pattern> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (Pattern idvalue : itemsSelected) {
			long id = idvalue.getId();
			Pattern s = (Pattern) session.load(Pattern.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}
	
	@Override
	public void deletePattern(Pattern itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(itemsSelected);
		
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updatePattern(Pattern pattern) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(pattern);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<DayOnRequest> listDayOnRequest() {
		List<DayOnRequest> dayondatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayondatalist = session.createQuery("from DayOnRequest").list();
		session.getTransaction().commit();

		session.close();
		return dayondatalist;
	}

	@Override
	public List<DayOnRequest> listDayOnReqestDataId() {
		List<DayOnRequest> dayondataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayondataidlist = session.createQuery("select id from DayOnRequest").list();
		session.getTransaction().commit();

		session.close();
		return dayondataidlist;
	}

	@Override
	public void addDayOnRequest(DayOnRequest dayondata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(dayondata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeDayOnRequest(ObservableList<DayOnRequest> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (DayOnRequest idvalue : itemsSelected) {
			long id = idvalue.getId();
			DayOnRequest s = (DayOnRequest) session.load(DayOnRequest.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateDayOnRequest(DayOnRequest dayondata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(dayondata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<DayOffRequest> listDayOffRequest() {
		List<DayOffRequest> dayoffdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdatalist = session.createQuery("from DayOffRequest").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdatalist;
	}

	@Override
	public List<DayOffRequest> listDayOffRequestId() {
		List<DayOffRequest> dayoffdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdataidlist = session.createQuery("select id from DayOffRequest").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdataidlist;
	}

	@Override
	public void addDayOffRequest(DayOffRequest dayoffdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(dayoffdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeDayOffRequest(ObservableList<DayOffRequest> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (DayOffRequest idvalue : itemsSelected) {
			long id = idvalue.getId();
			DayOffRequest s = (DayOffRequest) session.load(DayOffRequest.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateDayOffRequest(DayOffRequest dayoffdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(dayoffdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<ShiftOnRequest> listShiftOnRequest() {
		List<ShiftOnRequest> shiftonrequestdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftonrequestdatalist = session.createQuery("from ShiftOnRequest").list();
		session.getTransaction().commit();

		session.close();
		return shiftonrequestdatalist;
	}

	@Override
	public List<ShiftOnRequest> listShiftOnRequestId() {
		List<ShiftOnRequest> shiftonrequestdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftonrequestdataidlist = session.createQuery("select id from ShiftOnRequest").list();
		session.getTransaction().commit();

		session.close();
		return shiftonrequestdataidlist;
	}

	@Override
	public void addShiftOnRequest(ShiftOnRequest shiftondata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shiftondata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShiftOnRequest(ObservableList<ShiftOnRequest> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (ShiftOnRequest idvalue : itemsSelected) {
			long id = idvalue.getId();
			ShiftOnRequest s = (ShiftOnRequest) session.load(ShiftOnRequest.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateShiftOnRequest(ShiftOnRequest shiftondata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shiftondata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<ShiftOffRequest> listShiftOffRequest() {
		List<ShiftOffRequest> dayoffdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdatalist = session.createQuery("from ShiftOffRequest").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdatalist;
	}

	@Override
	public List<ShiftOffRequest> listShiftOffRequestId() {
		List<ShiftOffRequest> dayoffdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdataidlist = session.createQuery("select id from ShiftOffRequest").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdataidlist;
	}

	@Override
	public void addShiftOffRequest(ShiftOffRequest dayoffdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(dayoffdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShiftOffRequest(ObservableList<ShiftOffRequest> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (ShiftOffRequest idvalue : itemsSelected) {
			long id = idvalue.getId();
			ShiftOffRequest s = (ShiftOffRequest) session.load(ShiftOffRequest.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateShiftOffRequest(ShiftOffRequest dayoffdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(dayoffdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePattern() {
		List<WorkBeforeFreeSequencePattern> workbeforedatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		workbeforedatalist = session.createQuery("from WorkBeforeFreeSequencePattern").list();
		session.getTransaction().commit();

		session.close();
		return workbeforedatalist;
	}

	@Override
	public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePatternId() {
		List<WorkBeforeFreeSequencePattern> workbeforedataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		workbeforedataidlist = session.createQuery("select id from WorkBeforeFreeSequencePattern").list();
		session.getTransaction().commit();

		session.close();
		return workbeforedataidlist;
	}

	@Override
	public List<WorkBeforeFreeSequencePattern> listWorkBeforeFreeSequencePatterncode() {
		List<WorkBeforeFreeSequencePattern> workbeforedatacodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		workbeforedatacodelist = session.createQuery("select code from WorkBeforeFreeSequencePattern").list();
		session.getTransaction().commit();

		session.close();
		return workbeforedatacodelist;
	}

	@Override
	public void addWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern workbeforedata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(workbeforedata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern itemsSelected) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(itemsSelected);
		session.getTransaction().commit();
     	session.close();
	}

	@Override
	public void updateWorkBeforeFreeSequencePattern(WorkBeforeFreeSequencePattern workbeforedata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(workbeforedata);
		session.getTransaction().commit();

		session.close();
	}

	
	
	@Override
	public List<ShiftType2DaysPattern> listShiftType2DaysPattern() {
		List<ShiftType2DaysPattern> shift2daydatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shift2daydatalist = session.createQuery("from ShiftType2DaysPattern").list();
		session.getTransaction().commit();

		session.close();
		return shift2daydatalist;
	}

	@Override
	public List<ShiftType2DaysPattern> listShiftType2DaysPatternId() {
		List<ShiftType2DaysPattern> shift2daydataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shift2daydataidlist = session.createQuery("select id from ShiftType2DaysPattern").list();
		session.getTransaction().commit();

		session.close();
		return shift2daydataidlist;
	}

	@Override
	public List<ShiftType2DaysPattern> listShiftType2DaysPatterncode() {
		List<ShiftType2DaysPattern> shift2daydatacodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shift2daydatacodelist = session.createQuery("select code from ShiftType2DaysPattern").list();
		session.getTransaction().commit();

		session.close();
		return shift2daydatacodelist;
	}

	@Override
	public void addShiftType2DaysPattern(ShiftType2DaysPattern shift2daydata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shift2daydata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShiftType2DaysPattern(ShiftType2DaysPattern itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(itemsSelected);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateShiftType2DaysPattern(ShiftType2DaysPattern shift2daydata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shift2daydata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<ShiftType3DaysPattern> listShiftType3DaysPattern() {
		List<ShiftType3DaysPattern> shift3daydatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shift3daydatalist = session.createQuery("from ShiftType3DaysPattern").list();
		session.getTransaction().commit();

		session.close();
		return shift3daydatalist;
	}

	@Override
	public List<ShiftType3DaysPattern> listShiftType3DaysPatternId() {
		List<ShiftType3DaysPattern> shift3daydataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shift3daydataidlist = session.createQuery("select id from ShiftType3DaysPattern").list();
		session.getTransaction().commit();

		session.close();
		return shift3daydataidlist;
	}

	@Override
	public void addShiftType3DaysPattern(ShiftType3DaysPattern shift3daydata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shift3daydata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShiftType3DaysPattern(ShiftType3DaysPattern itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(itemsSelected);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateShiftType3DaysPattern(ShiftType3DaysPattern shift3daydata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shift3daydata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<FreeBefore2DaysWithAWorkDayPattern> listFreeBefore2DaysWithAWorkDayPattern() {
		List<FreeBefore2DaysWithAWorkDayPattern> freedaylist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		freedaylist = session.createQuery("from FreeBefore2DaysWithAWorkDayPattern").list();
		session.getTransaction().commit();

		session.close();
		return freedaylist;
	}

	@Override
	public List<FreeBefore2DaysWithAWorkDayPattern> listFreeBefore2DaysWithAWorkDayPatternId() {
		List<FreeBefore2DaysWithAWorkDayPattern> freedayidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		freedayidlist = session.createQuery("select id from FreeBefore2DaysWithAWorkDayPattern").list();
		session.getTransaction().commit();

		session.close();
		return freedayidlist;
	}

	@Override
	public void addFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern freeday) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(freeday);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeFreeBefore2DaysWithAWorkDayPattern(
		FreeBefore2DaysWithAWorkDayPattern itemsSelected) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(itemsSelected);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateFreeBefore2DaysWithAWorkDayPattern(FreeBefore2DaysWithAWorkDayPattern freeday) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(freeday);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<ShiftType> listShiftType() {
		List<ShiftType> shifttypelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shifttypelist = session.createQuery("from ShiftType").list();
		session.getTransaction().commit();

		session.close();
		return shifttypelist;
	}

	@Override
	public List<ShiftType> listShiftTypeId() {
		List<ShiftType> shifttypeidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shifttypeidlist = session.createQuery("select id from ShiftType").list();
		session.getTransaction().commit();

		session.close();
		return shifttypeidlist;
	}

	@Override
	public List<ShiftType> listShiftTypecode() {
		List<ShiftType> shifttypecodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shifttypecodelist = session.createQuery("select code from ShiftType").list();
		session.getTransaction().commit();

		session.close();
		return shifttypecodelist;
	}

	@Override
	public void addShiftType(ShiftType shifttype) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shifttype);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShiftType(ObservableList<ShiftType> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (ShiftType idvalue : itemsSelected) {
			long id = idvalue.getId();
			ShiftType s = (ShiftType) session.load(ShiftType.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateShiftType(ShiftType shifttype) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shifttype);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<PatternContractLine> listPatternContractLine() {
		List<PatternContractLine> patternlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		patternlist = session.createQuery("from PatternContractLine").list();
		session.getTransaction().commit();

		session.close();
		return patternlist;
	}

	@Override
	public List<PatternContractLine> listPatternContractLineId() {
		List<PatternContractLine> patternidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		patternidlist = session.createQuery("select id from PatternContractLine").list();
		session.getTransaction().commit();

		session.close();
		return patternidlist;
	}

	@Override
	public List<PatternContractLine> listPatternContractLinecode() {
		List<PatternContractLine> patterncodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		patterncodelist = session.createQuery("select code from PatternContractLine").list();
		session.getTransaction().commit();

		session.close();
		return patterncodelist;
	}

	@Override
	public void addPatternContractLine(PatternContractLine pattern) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(pattern);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updatePatternContractLine(PatternContractLine pattern) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(pattern);
		session.getTransaction().commit();

		session.close();
	}
	@Override
	public void deletePatternContractLine(PatternContractLine patterndata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(patterndata);
		session.getTransaction().commit();

		session.close();
	}
	@Override
	public void removePatternContractLine(ObservableList<PatternContractLine> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (PatternContractLine idvalue : itemsSelected) {
			long id = idvalue.getId();
			PatternContractLine s = (PatternContractLine) session.load(PatternContractLine.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<ContractLine> listContractLine() {
		List<ContractLine> patternlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		patternlist = session.createQuery("from ContractLine").list();
		session.getTransaction().commit();

		session.close();
		return patternlist;
	}

	@Override
	public List<ContractLine> listContractLineId() {
		List<ContractLine> patternidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		patternidlist = session.createQuery("select id from ContractLine").list();
		session.getTransaction().commit();

		session.close();
		return patternidlist;
	}

	@Override
	public List<ContractLine> listContractLinecode() {
		List<ContractLine> patterncodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		patterncodelist = session.createQuery("select code from ContractLine").list();
		session.getTransaction().commit();

		session.close();
		return patterncodelist;
	}

	@Override
	public void addContractLine(ContractLine pattern) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(pattern);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateContractLine(ContractLine pattern) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(pattern);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeContractLine(ObservableList<ContractLine> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (ContractLine idvalue : itemsSelected) {
			long id = idvalue.getId();
			ContractLine s = (ContractLine) session.load(ContractLine.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void addSkillProficiency(SkillProficiency skillprof) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(skillprof);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<SkillProficiency> listSkillProficiency() {
		List<SkillProficiency> list = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		list = session.createQuery("from SkillProficiency").list();
		session.getTransaction().commit();

		session.close();
		return list;
	}

	@Override
	public void removeSkillProficiency(SkillProficiency itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(itemsSelected);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void mergeSkillProficiency(SkillProficiency skillprof) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(skillprof);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override

	public List<SkillProficiency> listSkillProficiencyempId() {
		List<SkillProficiency> empidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		empidlist = session.createQuery("select employee from SkillProficiency ").list();
		session.getTransaction().commit();

		session.close();
		return empidlist;
	}

	@Override
	public List<SkillProficiency> listSkillProficiencyId() {
		List<SkillProficiency> empidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		empidlist = session.createQuery("select id from SkillProficiency ").list();
		session.getTransaction().commit();

		session.close();
		return empidlist;
	}

	@Override
	public List<SkillProficiency> listSkillProficiencycode() {
		List<SkillProficiency> empidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		empidlist = session.createQuery("select skill from SkillProficiency ").list();
		session.getTransaction().commit();

		session.close();
		return empidlist;
	}

	@Override
	public List<Shift> listShift() {
		List<Shift> shifttypelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shifttypelist = session.createQuery("from Shift").list();
		session.getTransaction().commit();

		session.close();
		return shifttypelist;
	}

	@Override
	public List<Shift> listShiftId() {
		List<Shift> shifttypeidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shifttypeidlist = session.createQuery("select id from Shift").list();
		session.getTransaction().commit();

		session.close();
		return shifttypeidlist;
	}

	@Override
	public List<Shift> listShiftcode() {
		List<Shift> shifttypecodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shifttypecodelist = session.createQuery("select shiftType from Shift").list();
		session.getTransaction().commit();

		session.close();
		return shifttypecodelist;
	}

	@Override
	public void addShift(Shift shift) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shift);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShift(ObservableList<Shift> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (Shift idvalue : itemsSelected) {
			long id = idvalue.getId();
			Shift s = (Shift) session.load(Shift.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateShift(Shift shift) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shift);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<ShiftDate> listShiftDate() {
		List<ShiftDate> skillslist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		skillslist = session.createQuery("from ShiftDate").list();
		session.getTransaction().commit();

		session.close();
		return skillslist;
	}

	@Override
	public List<ShiftDate> listShiftDateId() {
		List<ShiftDate> skillsidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		skillsidlist = session.createQuery("select id from ShiftDate").list();
		session.getTransaction().commit();

		session.close();
		return skillsidlist;
	}

	@Override
	public List<ShiftDate> listShiftDatecode() {
		List<ShiftDate> skillscodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		skillscodelist = session.createQuery("select code from ShiftDate").list();
		session.getTransaction().commit();

		session.close();
		return skillscodelist;
	}

	@Override
	public void addShiftDate(ShiftDate shiftDate) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shiftDate);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShiftDate(ObservableList<ShiftDate> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (ShiftDate idvalue : itemsSelected) {
			long id = idvalue.getId();
			ShiftDate s = (ShiftDate) session.load(ShiftDate.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateShiftDate(ShiftDate shiftDate) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shiftDate);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<CoverRequirements> listCoverRequirementsId() {
		List<CoverRequirements> shiftassignmentidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftassignmentidlist = session.createQuery("select id from CoverRequirements").list();
		session.getTransaction().commit();

		session.close();
		return shiftassignmentidlist;
	}

	@Override
	public List<CoverRequirements> listCoverRequirementsday() {
		List<CoverRequirements> shiftassignmentdaylist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftassignmentdaylist = session.createQuery("select dayOfWeek from CoverRequirements").list();
		session.getTransaction().commit();

		session.close();
		return shiftassignmentdaylist;
	}

	@Override
	public void addCoverRequirements(CoverRequirements cover) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(cover);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeCoverRequirements(ObservableList<CoverRequirements> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (CoverRequirements idvalue : itemsSelected) {
			long id = idvalue.getId();
			CoverRequirements s = (CoverRequirements) session.load(CoverRequirements.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateCoverRequirements(CoverRequirements cover) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(cover);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<CoverRequirements> listCoverRequirements() {
		List<CoverRequirements> shiftassignmentlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftassignmentlist = session.createQuery("from CoverRequirements").list();
		session.getTransaction().commit();

		session.close();
		return shiftassignmentlist;
	}

	@Override
	public List<CoverRequirements> listCoverRequirementscode() {
		List<CoverRequirements> assignmentcodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		assignmentcodelist = session.createQuery("select code from CoverRequirements").list();
		session.getTransaction().commit();

		session.close();
		return assignmentcodelist;
	}

	@Override
	public List<ShiftAssignment> listShiftAssignment() {
		List<ShiftAssignment> shiftassignmentlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftassignmentlist = session.createQuery("from ShiftAssignment").list();
		session.getTransaction().commit();

		session.close();
		return shiftassignmentlist;
	}

	@Override
	public List<DayOffDate> listDayOffDate() {
		List<DayOffDate> dayoffdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdatalist = session.createQuery("from DayOffDate").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdatalist;
	}

	@Override
	public List<DayOffDate> listDayOffDateId() {
		List<DayOffDate> dayoffdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdataidlist = session.createQuery("select id from DayOffDate").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdataidlist;
	}

	@Override
	public void addDayOffDate(DayOffDate dayoffdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(dayoffdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeDayOffDate(ObservableList<DayOffDate> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (DayOffDate idvalue : itemsSelected) {
			long id = idvalue.getId();
			DayOffDate s = (DayOffDate) session.load(DayOffDate.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateDayOffDate(DayOffDate dayoffdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(dayoffdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<DayOnDate> listDayOnDate() {
		List<DayOnDate> dayoffdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdatalist = session.createQuery("from DayOnDate").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdatalist;
	}

	@Override
	public List<DayOnDate> listDayOnDateId() {
		List<DayOnDate> dayoffdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdataidlist = session.createQuery("select id from DayOnDate").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdataidlist;
	}

	@Override
	public void addDayOnDate(DayOnDate dayondata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(dayondata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeDayOnDate(ObservableList<DayOnDate> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (DayOnDate idvalue : itemsSelected) {
			long id = idvalue.getId();
			DayOnDate s = (DayOnDate) session.load(DayOnDate.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateDayOnDate(DayOnDate dayondata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(dayondata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<ShiftOnDate> listShiftOnDate() {
		List<ShiftOnDate> dayoffdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdatalist = session.createQuery("from ShiftOnDate").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdatalist;
	}

	@Override
	public List<ShiftOnDate> listShiftOnDateId() {
		List<ShiftOnDate> dayoffdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdataidlist = session.createQuery("select id from ShiftOnDate").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdataidlist;
	}

	@Override
	public void addShiftOnDate(ShiftOnDate shiftondata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shiftondata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShiftOnDate(ObservableList<ShiftOnDate> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (ShiftOnDate idvalue : itemsSelected) {
			long id = idvalue.getId();
			ShiftOnDate s = (ShiftOnDate) session.load(ShiftOnDate.class, id);
			session.delete(s);
		}

		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateShiftOnDate(ShiftOnDate shiftondata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shiftondata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<ShiftOffDate> listShiftOffDate() {
		List<ShiftOffDate> dayoffdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdatalist = session.createQuery("from ShiftOffDate").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdatalist;
	}

	@Override
	public List<ShiftOffDate> listShiftOffDateId() {
		List<ShiftOffDate> dayoffdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdataidlist = session.createQuery("select id from ShiftOffDate").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdataidlist;
	}

	@Override
	public void addShiftOffDate(ShiftOffDate shiftoffdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shiftoffdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShiftOffDate(ObservableList<ShiftOffDate> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (ShiftOffDate idvalue : itemsSelected) {
			long id = idvalue.getId();
			ShiftOffDate s = (ShiftOffDate) session.load(ShiftOffDate.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateShiftOffDate(ShiftOffDate shiftoffdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shiftoffdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<HolidaysData> listHolidaysData() {
		List<HolidaysData> dayoffdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdatalist = session.createQuery("from HolidaysData").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdatalist;
	}

	@Override
	public List<HolidaysData> listHolidaysDataId() {
		List<HolidaysData> dayoffdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdataidlist = session.createQuery("select id from HolidaysData").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdataidlist;
	}

	@Override
	public void addHolidaysData(HolidaysData holidaydata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(holidaydata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeHolidaysData(ObservableList<HolidaysData> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (HolidaysData idvalue : itemsSelected) {
			long id = idvalue.getId();
			HolidaysData s = (HolidaysData) session.load(HolidaysData.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateHolidaysData(HolidaysData holidaydata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(holidaydata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<RosterDayOff> listRosterDayOff() {
		List<RosterDayOff> rdodatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		rdodatalist = session.createQuery("from RosterDayOff").list();
		session.getTransaction().commit();

		session.close();
		return rdodatalist;
	}

	@Override
	public List<RosterDayOff> listRosterDayOffId() {
		List<RosterDayOff> rdodataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		rdodataidlist = session.createQuery("select id from RosterDayOff").list();
		session.getTransaction().commit();

		session.close();
		return rdodataidlist;
	}

	@Override
	public void addRosterDayOff(RosterDayOff rdodata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(rdodata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeRosterDayOff(ObservableList<RosterDayOff> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (RosterDayOff idvalue : itemsSelected) {
			long id = idvalue.getId();
			RosterDayOff s = (RosterDayOff) session.load(RosterDayOff.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateRosterDayOff(RosterDayOff rdodata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(rdodata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<LeaveData> listLeaveData() {
		List<LeaveData> dayoffdatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdatalist = session.createQuery("from LeaveData").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdatalist;
	}

	@Override
	public List<LeaveData> listLeaveDataId() {
		List<LeaveData> dayoffdataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		dayoffdataidlist = session.createQuery("select id from LeaveData").list();
		session.getTransaction().commit();

		session.close();
		return dayoffdataidlist;
	}

	@Override
	public void addLeaveData(LeaveData leavedata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(leavedata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeLeaveData(ObservableList<LeaveData> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (LeaveData idvalue : itemsSelected) {
			long id = idvalue.getId();
			LeaveData s = (LeaveData) session.load(LeaveData.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateLeaveData(LeaveData leavedata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(leavedata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<TrainingData> listTrainingData() {
		List<TrainingData> rdodatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		rdodatalist = session.createQuery("from TrainingData").list();
		session.getTransaction().commit();

		session.close();
		return rdodatalist;
	}

	@Override
	public List<TrainingData> listTrainingDataId() {
		List<TrainingData> rdodataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		rdodataidlist = session.createQuery("select id from TrainingData").list();
		session.getTransaction().commit();

		session.close();
		return rdodataidlist;
	}

	@Override
	public void addTrainingData(TrainingData trainingdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(trainingdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeTrainingData(ObservableList<TrainingData> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (TrainingData idvalue : itemsSelected) {
			long id = idvalue.getId();
			TrainingData s = (TrainingData) session.load(TrainingData.class, id);
			session.delete(s);
		}

		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateTrainingData(TrainingData trainingdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(trainingdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<CalendarData> listCalendarData() {
		List<CalendarData> calendardatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		calendardatalist = session.createQuery("from CalendarData").list();
		session.getTransaction().commit();

		session.close();
		return calendardatalist;
	}

	@Override
	public List<CalendarData> listCalendarDataId() {
		List<CalendarData> calendardataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		calendardataidlist = session.createQuery("select id from CalendarData").list();
		session.getTransaction().commit();

		session.close();
		return calendardataidlist;
	}

	@Override
	public void addCalendarData(CalendarData assignmentdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(assignmentdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeCalendarData(ObservableList<CalendarData> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (CalendarData idvalue : itemsSelected) {
			long id = idvalue.getId();
			CalendarData s = (CalendarData) session.load(CalendarData.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateCalendarData(CalendarData calendardata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(calendardata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void insertSkillProficiency(SkillProficiency skillprof) {
		// TODO Auto-generated method stub

	}
	@Override
	public List<WorkEarlyPattern> listWorkEarlyPattern() {
		List<WorkEarlyPattern> workbeforedatalist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		workbeforedatalist = session.createQuery("from WorkEarlyPattern").list();
		session.getTransaction().commit();

		session.close();
		return workbeforedatalist;
	}

	@Override
	public List<WorkEarlyPattern> listWorkEarlyPatternId() {
		List<WorkEarlyPattern> workbeforedataidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		workbeforedataidlist = session.createQuery("select id from WorkEarlyPattern").list();
		session.getTransaction().commit();

		session.close();
		return workbeforedataidlist;
	}

	@Override
	public List<WorkEarlyPattern> listWorkEarlyPatterncode() {
		List<WorkEarlyPattern> workbeforedatacodelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		workbeforedatacodelist = session.createQuery("select code from WorkEarlyPattern").list();
		session.getTransaction().commit();

		session.close();
		return workbeforedatacodelist;
	}

	@Override
	public void addWorkEarlyPattern(WorkEarlyPattern workbeforedata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(workbeforedata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeWorkEarlyPattern(ObservableList<WorkEarlyPattern> itemsSelected) {
		List<PatternContractLine> patternidlist = new ArrayList<>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (WorkEarlyPattern idvalue : itemsSelected) {
			long id = idvalue.getId();
			WorkEarlyPattern s = (WorkEarlyPattern) session
					.load(WorkEarlyPattern.class, id);
			
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateWorkEarlyPattern(WorkEarlyPattern workbeforedata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(workbeforedata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<Machine> listMachine() {
		List<Machine> machinelist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		machinelist = session.createQuery("from Machine").list();
		session.getTransaction().commit();

		session.close();
		return machinelist;
	}

	@Override
	public List<Machine> listMachineId() {
		List<Machine> departmentidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		departmentidlist = session.createQuery("select id from Machine").list();
		session.getTransaction().commit();

		session.close();
		return departmentidlist;
	}

	@Override
	public void addMachine(Machine assignmentdata) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(assignmentdata);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeMachine(ObservableList<Machine> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (Machine idvalue : itemsSelected) {
			long id = idvalue.getId();
			Machine s = (Machine) session.load(Machine.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateMachine(Machine department) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(department);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public List<Machine> listMachinecode() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ShiftTypeMachineRequirement> listShiftTypeMachineRequirement() {
		List<ShiftTypeMachineRequirement> shiftTypeMachineRequirementslist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftTypeMachineRequirementslist = session.createQuery("from ShiftTypeMachineRequirement").list();
		session.getTransaction().commit();

		session.close();
		return shiftTypeMachineRequirementslist;
	}

	@Override
	public List<ShiftTypeMachineRequirement> listShiftTypeMachineRequirementId() {
		List<ShiftTypeMachineRequirement> shiftTypeMachineRequirementsidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftTypeMachineRequirementsidlist = session.createQuery("select id from ShiftTypeMachineRequirement").list();
		session.getTransaction().commit();

		session.close();
		return shiftTypeMachineRequirementsidlist;
	}

	

	@Override
	public void addShiftTypeMachineRequirement(ShiftTypeMachineRequirement shiftTypeMachineRequirement) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shiftTypeMachineRequirement);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeShiftTypeMachineRequirement(ObservableList<ShiftTypeMachineRequirement> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (ShiftTypeMachineRequirement idvalue : itemsSelected) {
			long id = idvalue.getId();
			ShiftTypeMachineRequirement s = (ShiftTypeMachineRequirement) session.load(ShiftTypeMachineRequirement.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateShiftTypeMachineRequirement(ShiftTypeMachineRequirement shiftTypeMachineRequirement) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shiftTypeMachineRequirement);
		session.getTransaction().commit();

		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeMachine> listEmployeeMachine() {
		List<EmployeeMachine> employeeMachineslist = new ArrayList<>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		employeeMachineslist = session.createQuery("from EmployeeMachine").list();
		session.getTransaction().commit();
		session.close();
		return employeeMachineslist;
	}

	@Override
	public List<EmployeeMachine> listEmployeeMachineId() {
		List<EmployeeMachine> EmployeeMachinesidlist = new ArrayList<>();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		EmployeeMachinesidlist = session.createQuery("select id from EmployeeMachine").list();
		session.getTransaction().commit();

		session.close();
		return EmployeeMachinesidlist;
	}

	

	@Override
	public void addEmployeeMachine(EmployeeMachine employeeMachines) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(employeeMachines);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeEmployeeMachine(EmployeeMachine itemsSelected) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(itemsSelected);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void mergeEmployeeMachine(EmployeeMachine employeeMachine) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(employeeMachine);
		session.getTransaction().commit();
		session.close();
	}


	@Override
	public List<MachineTypeSkillsRequirement> listMachineTypeSkillsRequirement() {
		List<MachineTypeSkillsRequirement> shiftTypeMachineRequirementslist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftTypeMachineRequirementslist = session.createQuery("from MachineTypeSkillsRequirement").list();
		session.getTransaction().commit();

		session.close();
		return shiftTypeMachineRequirementslist;
	}

	@Override
	public List<MachineTypeSkillsRequirement> listMachineTypeSkillsRequirementId() {
		List<MachineTypeSkillsRequirement> shiftTypeMachineRequirementsidlist = new ArrayList<>();

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		shiftTypeMachineRequirementsidlist = session.createQuery("select id from MachineTypeSkillsRequirement").list();
		session.getTransaction().commit();

		session.close();
		return shiftTypeMachineRequirementsidlist;
	}

	

	@Override
	public void addMachineTypeSkillsRequirement(MachineTypeSkillsRequirement shiftTypeMachineRequirement) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(shiftTypeMachineRequirement);
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void removeMachineTypeSkillsRequirement(ObservableList<MachineTypeSkillsRequirement> itemsSelected) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (MachineTypeSkillsRequirement idvalue : itemsSelected) {
			long id = idvalue.getId();
			MachineTypeSkillsRequirement s = (MachineTypeSkillsRequirement) session.load(MachineTypeSkillsRequirement.class, id);
			session.delete(s);
		}
		session.getTransaction().commit();

		session.close();
	}

	@Override
	public void updateMachineTypeSkillsRequirement(MachineTypeSkillsRequirement shiftTypeMachineRequirement) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(shiftTypeMachineRequirement);
		session.getTransaction().commit();

		session.close();
	}
}