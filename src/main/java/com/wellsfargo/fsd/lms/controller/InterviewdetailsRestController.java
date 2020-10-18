
  package com.wellsfargo.fsd.lms.controller;
  
  import java.util.List;
import java.util.Set;

import javax.validation.Valid;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.http.HttpStatus; import
  org.springframework.http.ResponseEntity; import
  org.springframework.validation.BindingResult; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.lms.dao.InterviewDao;
import com.wellsfargo.fsd.lms.entity.InterviewEntity;
import com.wellsfargo.fsd.lms.entity.UserEntity;
import com.wellsfargo.fsd.lms.exception.InterviewException;
import com.wellsfargo.fsd.lms.model.InterviewModel;
import com.wellsfargo.fsd.lms.model.UserModel;
import com.wellsfargo.fsd.lms.service.InterviewService;
import com.wellsfargo.fsd.lms.service.UserService;

 
  @RestController
  
  @RequestMapping("/interviews") 
  public class InterviewdetailsRestController {
	  
	  @Autowired
		private InterviewDao interRepo;
  
	  @Autowired
		private InterviewService interservice;
	  @Autowired
		private UserService loanService;
		

	  @GetMapping
	  public ResponseEntity<List<InterviewModel>> getAllinterviews() throws InterviewException
	  {
		  return new ResponseEntity<List<InterviewModel>>(interservice.getAllinterviews(),HttpStatus.OK);
	  }
	 
	  @PostMapping
		public ResponseEntity<InterviewModel> createinterview(@RequestBody @Valid InterviewModel interview,BindingResult result) throws InterviewException{
			if(result.hasErrors()) {
				throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
			}
			return new ResponseEntity<>(interservice.add(interview),HttpStatus.OK);
		}
		
	 
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteinterview(@PathVariable("id")int InterviewId) throws InterviewException{
			
			
			interservice.deleteinterview(InterviewId);		
			return new ResponseEntity<>(HttpStatus.OK);
		}
		

		@GetMapping("interviewername/{keyword}")
		public ResponseEntity<List<InterviewModel>> getinterview(@PathVariable("keyword")String key) throws InterviewException{
			ResponseEntity<List<InterviewModel>> rep =null;
			List<InterviewModel> keyword = interservice.searchAll(key);
			if(keyword!=null) {
				rep= new ResponseEntity<List<InterviewModel>>(keyword,HttpStatus.OK);
			}else {
				rep= new ResponseEntity<List<InterviewModel>>(keyword,HttpStatus.NOT_FOUND);
				
			}
			return rep;
		}
		
		@GetMapping("interviewname/{keyword}")
		public ResponseEntity<List<InterviewModel>> getallbyinterviewname(@PathVariable("keyword")String key) throws InterviewException{
			ResponseEntity<List<InterviewModel>> rep =null;
			List<InterviewModel> keyword = interservice.searchAllinterviewname(key);
			if(keyword!=null) {
				rep= new ResponseEntity<List<InterviewModel>>(keyword,HttpStatus.OK);
			}else {
				rep= new ResponseEntity<List<InterviewModel>>(keyword,HttpStatus.NOT_FOUND);
			}
			return rep;
		}
  

		@GetMapping("/count")
		public long countEntities() throws InterviewException {
			long count = interservice.getCountOfInterviews();
			return count;
		}
		
		  
	    @PutMapping({"/addUsers/{interviewId}/{userId}"})
	    public  ResponseEntity<Void> addUsers(@PathVariable("interviewId") int interviewId, @PathVariable("userId") int userId) throws InterviewException
	    {
	    	interservice.addUsersToInterview(interviewId, userId);	
			return new ResponseEntity<>(HttpStatus.OK);
	    	
	    }
	    
	    @GetMapping("/attendees/{interviewId}")
	    public  List<UserModel> getAttendees(@PathVariable("interviewId") int interviewId) {
	       // return  interservice.findByInterviewId(interviewId).getUserEntity();
	    	return  loanService.findByInterviewId(interviewId);
	    }
	    
		
		
		@PutMapping("/updateStatus/{interviewid}/{status}")
		public ResponseEntity<InterviewModel> updateStatus(@PathVariable("interviewid")int interviewId,@PathVariable("status")String status) throws InterviewException {
			  return new ResponseEntity<InterviewModel>(interservice.updateStatus(interviewId, status),HttpStatus.OK);
		}
		
		
  }
 