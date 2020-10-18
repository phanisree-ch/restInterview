package com.wellsfargo.fsd.lms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wellsfargo.fsd.lms.entity.InterviewEntity;
import com.wellsfargo.fsd.lms.exception.InterviewException;
import com.wellsfargo.fsd.lms.model.InterviewModel;



public interface InterviewService {
	
	InterviewModel add(InterviewModel interview) throws InterviewException;
	public long getCountOfInterviews()throws InterviewException;
		List<InterviewModel> searchAll(String keyword) throws InterviewException;
	List<InterviewModel> searchAllinterviewname(String keyword) throws InterviewException;
	List<InterviewModel> getAllinterviews()throws InterviewException;

	InterviewModel updateStatus(int interviewId, String status)throws InterviewException;
	InterviewEntity addUsersToInterview(int interviewId, int userId)throws InterviewException;

	ResponseEntity<Void> deleteinterview(int interviewId) throws InterviewException;
	
	
}
