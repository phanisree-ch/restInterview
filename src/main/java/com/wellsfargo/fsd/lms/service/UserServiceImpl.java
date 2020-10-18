package com.wellsfargo.fsd.lms.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wellsfargo.fsd.lms.dao.InterviewDao;
import com.wellsfargo.fsd.lms.dao.UserDao;
import com.wellsfargo.fsd.lms.entity.InterviewEntity;
import com.wellsfargo.fsd.lms.entity.UserEntity;
import com.wellsfargo.fsd.lms.exception.InvalidData;
import com.wellsfargo.fsd.lms.exception.InterviewException;
import com.wellsfargo.fsd.lms.model.UserModel;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userRepo;
	
	@Autowired
	private InterviewDao interRepo;
	
	

	private UserEntity toEntity(UserModel model) {
		return new UserEntity(model.getUserId(), model.getFirstName(), model.getLastName(),model.getEmail(), model.getMobile());
	}
	
	private UserModel toModel(UserEntity entity) {
		return new UserModel(entity.getUserId(),entity.getFirstName(), entity.getLastName(), entity.getEmail(), entity.getMobile());
	}
	
	@Override
    public   List<UserModel> findByInterviewId(int interviewId) {
		InterviewEntity intEntity= interRepo.findById(interviewId).orElseThrow(() -> new InvalidData("Interview Id : " + interviewId + " is not found."));
		Set<UserEntity> users= intEntity.getUserEntity();
        
    	List<UserModel> models = null;
		if(users!=null && !users.isEmpty()) {
			models = users.stream().map(e -> toModel(e)).collect(Collectors.toList());
		}
		return models;
	}
	
	@Override
	@Transactional
	public UserModel add(UserModel user) throws InterviewException {
		if(user!=null) {
			if(userRepo.existsById(user.getUserId())) {
				throw new InterviewException("user Id already used!");
			}
			
			user = toModel(userRepo.save(toEntity(user)));
		}
		return user;
	}

	@Override
	@Transactional
	public UserModel save(UserModel user) throws InterviewException {
		if(user!=null) {
			if(!userRepo.existsById(user.getUserId())) {
				throw new InterviewException("user Not Found");
			}
			
			user = toModel(userRepo.save(toEntity(user)));
		}
		return user;
	}

	@Override
	@Transactional
	public boolean deleteuser(int userId) throws InterviewException {
		if(!userRepo.existsById(userId)) {
			throw new InterviewException("user Not Found");
		}
		
		userRepo.deleteById(userId);
		return true;
	}

	@Override
	public UserModel getuser(int userId) {
		UserEntity entity = userRepo.findById(userId).orElse(null);
		return entity!=null?toModel(entity):null;
	}
	
	//private List<UserEntity> users = Arrays.asList(new UserEntity(1,"hello","hai","hello@hai.com","9287983279"));
	
	@Override
	public List<UserModel> getAllusers() {
		List<UserEntity> entities = userRepo.findAll();
		List<UserModel> models = null;
		if(entities!=null && !entities.isEmpty()) {
			models = entities.stream().map(e -> toModel(e)).collect(Collectors.toList());
			/*models = new ArrayList<>();
			for(userEntity e : entities) {
				models.add(toModel(e));
			}*/
		}
		return models;
	}
}
