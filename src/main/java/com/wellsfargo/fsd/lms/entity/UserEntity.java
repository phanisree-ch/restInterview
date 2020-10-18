package com.wellsfargo.fsd.lms.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usersNew")
public class UserEntity {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Uid")
	private int UserId;
		
	@Column(name="fnm")
	private String firstName;
	@Column(name="lnm")
	private String lastName;
	
	@Column(name="mail")
	private String email;
	
	@Column(name="mobnum")
	private String mobile;
	
	 @ManyToMany(mappedBy = "userEntity")
private Set<InterviewEntity> interviews;
	 
	public UserEntity() {
		
	}
		public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Set<InterviewEntity> getInterviews() {
		return interviews;
	}


	public void setInterviews(Set<InterviewEntity> interviews) {
		this.interviews = interviews;
	}


	@Override
	public String toString() {
		return "UserEntity [UserId=" + UserId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobile=" + mobile + "]";
	}


	public UserEntity(int userId, String firstName, String lastName, String email, String mobile) {
	
		UserId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		
	}




	

	
}
