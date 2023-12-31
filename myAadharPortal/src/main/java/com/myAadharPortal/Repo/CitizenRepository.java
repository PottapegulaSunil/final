package com.myAadharPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.myAadharPortal.model.Admin;
import com.myAadharPortal.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
	Citizen findByEmail(String email);

	Citizen findByMobileNo(String mobileNo);
}
