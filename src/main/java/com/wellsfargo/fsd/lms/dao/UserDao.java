package com.wellsfargo.fsd.lms.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.lms.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>{
	
	
	
	

		/*
	 * @Query("SELECt l FROM LoanEntity l WHERE l.dateOfDisbursment BETWEEN :start and :end"
	 * ) List<UserEntity> findAllHavingDOBInRange(@DateTimeFormat(iso=ISO.DATE)
	 * LocalDate start,@DateTimeFormat(iso=ISO.DATE)LocalDate end);
	 */
}
