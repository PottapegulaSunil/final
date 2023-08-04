package com.myAadharPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.myAadharPortal.model.AadharApplication;



@Repository
public interface AadharApplicationRepository extends JpaRepository<AadharApplication, Long> {
    
}
