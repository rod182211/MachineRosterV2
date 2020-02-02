package org.optaplanner.examples.nurserostering.domain;

import java.util.Objects;

import javax.persistence.Entity;

import org.optaplanner.examples.common.domain.AbstractPersistable;

@Entity
public class Department extends AbstractPersistable implements Comparable<Department> {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

  
    @Override
    public String toString() {
        return code;
    }
    @Override
    public int compareTo(Department o) {
        return this.getCode().compareTo(o.getCode());
    }
	}

