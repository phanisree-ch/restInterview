package com.wellsfargo.fsd.lms.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.type.LocalDateType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="interviewNew")
public class InterviewEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="inid")
	private int interviewid;
	
	@Column(name="interviewername")
	private String interviewername;
	

	@Column(name="interviewname")
	private String interviewname;
	
	@Column(name="userskills")
	private String userskills;
	
	@Column(name="inttm")  	 
	@DateTimeFormat(iso=ISO.TIME)
	private LocalDate timeofinterview;
	@Column(name="intdob")  
	  @DateTimeFormat(iso=ISO.DATE)
	private LocalDate dateofinterview;
	
	@Column(name="intstatus")
	private String interviewstatus;
	
	@Column(name="intrmks")
	private String remarks;

	@ManyToMany(fetch = FetchType.LAZY, cascade =  {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
    @JoinTable(name = "interviewNew_userNew",
            joinColumns = {@JoinColumn(name = "interview_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<UserEntity> userEntity;
	
	
	public Set<UserEntity> getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(Set<UserEntity> userEntity) {
		this.userEntity = userEntity;
	}

	/*
	 * public void addUsers(List<UserEntity> users) {
	 * this.getUserEntity().addAll(users); }
	 */

	public InterviewEntity() {
		
	}
	

	

	public InterviewEntity(int InterviewId, String interviewername, String InterviewName, String userSkills,
			LocalDate timeofInterview, LocalDate dateOfinterview, String interviewStatus, String remarks) {
		super();
		this.interviewid = InterviewId;
		this.interviewername = interviewername;
		this.interviewname = InterviewName;
		this.userskills = userSkills;
		this.timeofinterview = timeofInterview;
		this.dateofinterview = dateOfinterview;
		this.interviewstatus = interviewStatus;
		this.remarks = remarks;
	}

	public int getInterviewid() {
		return interviewid;
	}

	public void setInterviewid(int interviewid) {
		this.interviewid = interviewid;
	}

	public String getInterviewername() {
		return interviewername;
	}

	public void setInterviewername(String interviewername) {
		this.interviewername = interviewername;
	}

	public String getInterviewname() {
		return interviewname;
	}

	public void setInterviewname(String interviewname) {
		this.interviewname = interviewname;
	}

	public String getUserskills() {
		return userskills;
	}

	public void setUserskills(String userskills) {
		this.userskills = userskills;
	}

	public LocalDate getTimeofinterview() {
		return timeofinterview;
	}

	public void setTimeofinterview(LocalDate timeofinterview) {
		this.timeofinterview = timeofinterview;
	}

	public LocalDate getDateofinterview() {
		return dateofinterview;
	}

	public void setDateofinterview(LocalDate dateofinterview) {
		this.dateofinterview = dateofinterview;
	}

	public String getInterviewstatus() {
		return interviewstatus;
	}

	public void setInterviewstatus(String interviewstatus) {
		this.interviewstatus = interviewstatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "InterviewEntity [interviewid=" + interviewid + ", interviewername=" + interviewername
				+ ", interviewname=" + interviewname + ", userskills=" + userskills + ", timeofinterview="
				+ timeofinterview + ", dateofinterview=" + dateofinterview + ", interviewstatus=" + interviewstatus
				+ ", remarks=" + remarks + "]";
	}

	
	
}
