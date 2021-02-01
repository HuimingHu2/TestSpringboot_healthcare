package com.healthcare.enrollee.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "enrolleenorm")
public class Enrollee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column
	private String enrolleeId;
    
	@Column
    private String name;
	
	@Column
	private boolean activeStatus;
	
	@Column
	private boolean hasDependents;

	@Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
	
	@Column
	private String phoneNum;
	
	public Enrollee() {
	}
	
	public Enrollee(String enrolleeId, String name, boolean activeStatus, Date birthDate) {
		this.enrolleeId = enrolleeId;
		this.name = name;
		this.activeStatus = activeStatus;
		this.birthDate = birthDate;
	}
	
	public Enrollee(String enrolleeId, String name, Date birthDate, boolean activeStatus, String phoneNum) {
		this.enrolleeId = enrolleeId;
		this.name = name;
		this.birthDate = birthDate;
		this.activeStatus = activeStatus;
		this.phoneNum = phoneNum;
	}	

	public Enrollee(String enrolleeId, String name, boolean activeStatus, boolean hasDependents, Date birthDate) {
		this.enrolleeId = enrolleeId;
		this.name = name;
		this.activeStatus = activeStatus;
		this.hasDependents = hasDependents;
		this.birthDate = birthDate;
	}

	public Enrollee(String enrolleeId, String name, boolean activeStatus, boolean hasDependents, Date birthDate,
			String phoneNum) {
		this.enrolleeId = enrolleeId;
		this.name = name;
		this.activeStatus = activeStatus;
		this.hasDependents = hasDependents;
		this.birthDate = birthDate;
		this.phoneNum = phoneNum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(String enrolleeId) {
		this.enrolleeId = enrolleeId;
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

	public boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public boolean isHasDependents() {
		return hasDependents;
	}

	public void setHasDependents(boolean hasDependents) {
		this.hasDependents = hasDependents;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Enrollee[enrolleeId=%s, name=%s, activeStatus=%s, hasDependents=%s, birthDate=%s, phoneNum=%s]",
                this.enrolleeId,
                this.name,
                this.activeStatus,
                this.hasDependents,
                this.birthDate,
                this.phoneNum
        );
    }
	
}
