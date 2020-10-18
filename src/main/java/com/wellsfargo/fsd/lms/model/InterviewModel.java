package com.wellsfargo.fsd.lms.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InterviewModel {
	

	@NotNull(message = "interview Id is mandotiry")
	private int interviewid;	
	
	@NotNull(message = "interviewername is manditory")
	@NotBlank(message = "interviewername is manditory")
	@Size(min=5,max=30,message = "userSkills is expected to be 5 to 30 chars in length")
	private String interviewername;
	
	@NotNull(message = "interviewname is manditory")
	@NotBlank(message = "interviewname is manditory")
	@Size(min=3,max=30,message = "userSkills is expected to be 5 to 30 chars in length")
	private String interviewname;
	
	@NotNull(message = "userSkills is manditory")
	@NotBlank(message = "userSkills is manditory")
	@Size(min=5,max=30,message = "userSkills is expected to be 5 to 30 chars in length")
	private String userskills;
	
	@NotNull(message = "timeofInterview is manditory")	
	private LocalDate timeofinterview;
	
	@NotNull(message = "dateOfinterview is manditory")	
	private LocalDate dateofinterview;
	
	@NotNull(message = "interviewNameis manditory")
	@NotBlank(message = "interviewName is manditory")
	@Size(min=5,max=100,message = "interviewStatu is expected to be 5 to 100 chars in length")
	private String interviewstatus;

	@NotNull(message = "remarks are manditory")
	@NotBlank(message = "remarks are manditory")
	@Size(min=5,max=100,message = "remarks is expected to be 5 to 100 chars in length")
	private String remarks;

	  
		  

	public InterviewModel(int interviewid,
String interviewername,
String interviewname,
String userskills,
LocalDate timeofinterview,
LocalDate dateofinterview,
String interviewstatus,
String remarks) {
		super();
		this.interviewid = interviewid;
		this.interviewername = interviewername;
		this.interviewname = interviewname;
		this.userskills = userskills;
		this.timeofinterview = timeofinterview;
		this.dateofinterview = dateofinterview;
		this.interviewstatus = interviewstatus;
		this.remarks = remarks;
	}

	public InterviewModel() {
		
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
		return "InterviewModel [interviewid=" + interviewid + ", interviewername=" + interviewername
				+ ", interviewname=" + interviewname + ", userskills=" + userskills + ", timeofinterview="
				+ timeofinterview + ", dateofinterview=" + dateofinterview + ", interviewstatus=" + interviewstatus
				+ ", remarks=" + remarks + "]";
	}
	



}
