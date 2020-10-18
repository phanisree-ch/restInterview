package com.wellsfargo.fsd.lms.service;

import java.util.List;

import com.wellsfargo.fsd.lms.exception.InterviewException;
import com.wellsfargo.fsd.lms.model.UserModel;


public interface UserService {

	UserModel add(UserModel user) throws InterviewException;
	UserModel save(UserModel user) throws InterviewException;
	
	boolean deleteuser(int userId) throws InterviewException;
	
	UserModel getuser(int userId);
	List<UserModel> getAllusers();
	 List<UserModel> findByInterviewId(int interviewId);
}
