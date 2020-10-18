package com.wellsfargo.fsd.lms.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserModel {
	
	
	@NotNull(message = "Loan Id is mandotiry")
	private int UserId;
	
	@NotNull(message = "FirstName is manditory")
	@NotBlank(message = "FirstName is manditory")
	@Size(min=5,max=30,message = "FirstName is expected to be 5 to 30 chars in length")
	private String firstName;
	
	@NotNull(message = "LastName is manditory")
	@NotBlank(message = "LastName is manditory")
	@Size(min=3,max=25,message = "LastName is expected to be 3 to 25 chars in length")
	private String lastName;	
	
	@Email(message = "Email should be valid")
    private String email;
  
	  @NotNull(message = "mobilenumber is manditory")
	  @NotBlank(message = "mobilenumber  is manditory")
	  @Pattern(regexp = "(\\+91|9)[0-9]{9}")
	  @Size(min=10,max=10,message="mobilenumber should have atleast 2 characters")
	  private String mobile;
	  
	  	  

	public UserModel() {
		
	}
	

	public UserModel(int UserId,
String firstName,
String lastName,
	String email,
 String mobile) {
	
		super();
		this.UserId = UserId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}


	public int getUserId() {
		return UserId;
	}


	public void setUserId(int UserId) {
		this.UserId = UserId;
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


	@Override
	public String toString() {
		return "UserModel [UserId=" + UserId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobile=" + mobile + "]";
	}




	

	
	
	
	
	
	
}
