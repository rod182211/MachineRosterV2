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

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nurserostering.domain.pattern.Pattern;

@Entity (name = "PatternContractLine" )
@XStreamAlias("PatternContractLine")
public class PatternContractLine  extends AbstractPersistable {
	

	@ManyToOne(cascade = CascadeType.MERGE)
    private Contract contract;
	@ManyToOne(cascade = CascadeType.ALL)
    private Pattern pattern;

	public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }



	public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return contract + "-" + pattern;
    }

}
