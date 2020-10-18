package com.wellsfargo.fsd.lms.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.lms.exception.InterviewException;
import com.wellsfargo.fsd.lms.model.UserModel;
import com.wellsfargo.fsd.lms.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserModel>> getAllusers(){
		return new ResponseEntity<List<UserModel>>(userService.getAllusers(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getuser(@PathVariable("id")int userId){
		ResponseEntity<UserModel> resp=null;
		
		UserModel user = userService.getuser(userId);
		
		if(user!=null) {
			resp =new ResponseEntity<>(user,HttpStatus.OK);
		}else {
			resp =new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<UserModel> createuser(@RequestBody @Valid UserModel user,BindingResult result) throws InterviewException{
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(userService.add(user),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<UserModel> modifyuser(@RequestBody @Valid UserModel user,BindingResult result) throws InterviewException{
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteuser(@PathVariable("id")int userId) throws InterviewException{
		userService.deleteuser(userId);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
