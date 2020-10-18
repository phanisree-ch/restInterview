package com.wellsfargo.fsd.lms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wellsfargo.fsd.lms.dao.InterviewDao;
import com.wellsfargo.fsd.lms.dao.UserDao;
import com.wellsfargo.fsd.lms.entity.InterviewEntity;
import com.wellsfargo.fsd.lms.entity.UserEntity;
import com.wellsfargo.fsd.lms.exception.InvalidData;
import com.wellsfargo.fsd.lms.exception.InterviewException;
import com.wellsfargo.fsd.lms.model.InterviewModel;
import com.wellsfargo.fsd.lms.model.UserModel;




@Service
public class InterServiceImpl implements InterviewService {

	@Autowired
	private InterviewDao interRepo;
	
	@Autowired
	private UserDao userRepository;
	
	@Autowired
	InterviewService interservice ;
		
	private InterviewEntity toEntity(InterviewModel intervw) {
		return new InterviewEntity(intervw.getInterviewid(), intervw.getInterviewername(),intervw.getInterviewname(),intervw.getUserskills(),
				intervw.getTimeofinterview(), intervw.getDateofinterview(),intervw.getInterviewstatus(), intervw.getRemarks());
	}
	
	private InterviewModel toModel(InterviewEntity entity) {
		return new InterviewModel(entity.getInterviewid(), entity.getInterviewername(),entity.getInterviewname(), entity.getUserskills(),
				entity.getTimeofinterview(), entity.getDateofinterview(), entity.getInterviewstatus(), entity.getRemarks());
	}

	@Override
	@Transactional
	public InterviewModel add(InterviewModel loan) throws InterviewException {
		if(loan!=null) {
			if(interRepo.existsById(loan.getInterviewid())) {
				throw new InterviewException("Interview Id already used!");
			}
			
			loan = toModel(interRepo.save(toEntity(loan)));
		}
		return loan;
	}
	
	@Override
	public List<InterviewModel> searchAll(String keyword) throws InterviewException {
		
		List<InterviewEntity> entities = interRepo.findByInterviewername(keyword);
		
		List<InterviewModel> model= null;
		
		if(entities!=null && !entities.isEmpty()) {
			model = entities.stream().map(e -> toModel(e)).collect(Collectors.toList());
		}
		return model;
			
	}
	
	@Override
	public List<InterviewModel> searchAllinterviewname(String keyword) throws InterviewException {
		
List<InterviewEntity> entities = interRepo.findByInterviewname(keyword);
		
		List<InterviewModel> model= null;
		
		if(entities!=null && !entities.isEmpty()) {
			model = entities.stream().map(e -> toModel(e)).collect(Collectors.toList());
		}
		return model;
			
			
	}
	
	@Override
	public List<InterviewModel> getAllinterviews() {
		List<InterviewEntity> entities = interRepo.findAll();
		List<InterviewModel> models = null;
		if(entities!=null && !entities.isEmpty()) {
			models = entities.stream().map(e -> toModel(e)).collect(Collectors.toList());
					}
		return models;
	}
	
	@Transactional
	public long getCountOfInterviews() {
		long count = interRepo.count();
		return count;
	}

	@Override
	public InterviewModel updateStatus(int interviewId, String status) {
			InterviewEntity entities = interRepo.getOne(interviewId);
		InterviewModel models = null;
		//InterviewEntity interview = interRepo.getOne(interviewId);
		entities.setInterviewstatus(status);
              models = toModel(interRepo.save(entities));          
		return models;
	}

	
		@Override
	public InterviewEntity addUsersToInterview(int interviewId, int userId) {
		InterviewEntity interview = interRepo.findById(interviewId).orElseThrow(() -> new InvalidData("Interview Id : " + interviewId + " is not found."));
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new InvalidData("User Id : " + userId + " is not found."));        
      
        if (interview.getUserEntity().stream().noneMatch(user1 -> user1.getUserId() == userId)) {
            interview.getUserEntity().add(user);
            interRepo.save(interview);
            
		}
		return interview;

	}

@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteinterview(@PathVariable("id")int interviewId) throws InterviewException{
	if(!interRepo.existsById(interviewId)) {
		
		throw new InterviewException("Interview Id Not Found");
	}
	interRepo.deleteById(interviewId);		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	

	


	
	

}
