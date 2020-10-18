package com.wellsfargo.fsd.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.wellsfargo.fsd.lms.entity.InterviewEntity;
import com.wellsfargo.fsd.lms.entity.UserEntity;
import com.wellsfargo.fsd.lms.model.InterviewModel;

@Repository
public interface InterviewDao extends JpaRepository<InterviewEntity, Integer>
{
	List<InterviewEntity> findByInterviewername(String keyword);
	//List<UserEntity> findAllByStatus(String status);
//	 @Query("SELECT p FROM InterviewEntity p WHERE CONCAT(p.name, p.brand, p.madein, p.price) LIKE %?1%") 
	// public List<InterviewEntity> findByinterviewName(String keyword);

	List<InterviewEntity> findByInterviewname(String keyword);
	//List<InterviewEntity> findByuenUserid(String UserId);
	//List<InterviewEntity> findByueninterviewstatus(String interviewstatus);
//InterviewEntity findByinterviewName(String keyword);

	

	//List<InterviewEntity> findByinterview_id(int interviewId);
	
	 
}
