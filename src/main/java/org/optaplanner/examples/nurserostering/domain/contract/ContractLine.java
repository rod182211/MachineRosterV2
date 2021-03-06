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

package org.optaplanner.examples.nurserostering.domain.contract;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamInclude;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.MappedSuperclass;
import org.optaplanner.examples.common.domain.AbstractPersistable;



@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@XStreamAlias("ContractLine")
@XStreamInclude({
        BooleanContractLine.class,
        MinMaxContractLine.class
})
public abstract class ContractLine extends AbstractPersistable {

    @ManyToOne
	private Contract contract;
 
	
	@Enumerated(EnumType.STRING)
	private ContractLineType contractLineType;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ContractLineType getContractLineType() {
        return contractLineType;
    }

    public void setContractLineType(ContractLineType contractLineType) {
        this.contractLineType = contractLineType;
    }

    public abstract boolean isEnabled();

    @Override
    public String toString() {
        return contract + "-" + contractLineType;
    }
}
