package org.optaplanner.examples.nurserostering.domain;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.optaplanner.examples.common.domain.AbstractPersistable;

@Entity
public class Department extends AbstractPersistable  {

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

}
