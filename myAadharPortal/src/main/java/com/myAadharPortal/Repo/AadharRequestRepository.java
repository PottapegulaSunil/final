package com.myAadharPortal.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.myAadharPortal.model.AadharRequest;

@Repository
public interface AadharRequestRepository extends JpaRepository<AadharRequest, Long> {

	

	AadharRequest findByCitizenId(Long citizenId);

	List<AadharRequest> findByCurrentStatus(String string);
    
}

