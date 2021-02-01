package com.healthcare.enrollee.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Dependent implements Serializable {
	private String dependentId;
    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

	public Dependent() {
	}

	public Dependent(String dependentId, String name, Date birthDate) {
		this.dependentId = dependentId;
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getDependentId() {
		return dependentId;
	}

	public void setDependentId(String dependentId) {
		this.dependentId = dependentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Dependent[dependentId=%s, name=%s, birthDate=%s]",
                this.dependentId,
                this.name,
                this.birthDate
        );
    }
}
