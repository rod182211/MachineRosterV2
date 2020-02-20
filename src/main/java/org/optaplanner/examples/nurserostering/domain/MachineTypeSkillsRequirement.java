 package org.optaplanner.examples.nurserostering.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.optaplanner.examples.common.domain.AbstractPersistable;
@Entity
public class MachineTypeSkillsRequirement extends AbstractPersistable  {

    @ManyToOne
	private Machine machine;
    @ManyToOne
	private Skill skill;
    @ManyToOne
   	private ShiftType shiftType;
   
    public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

   
    public ShiftType getShiftType() {
		return shiftType;
	}

	public void setShiftType(ShiftType shiftType) {
		this.shiftType = shiftType;
	}

	@Override
	public String toString() {
		return "MachineTypeSkillsRequirement [machine=" + machine + ", skill=" + skill + ", shiftType=" + shiftType
				+ "]";
	}

	

}