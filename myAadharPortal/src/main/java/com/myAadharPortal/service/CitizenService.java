package com.myAadharPortal.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myAadharPortal.Repo.CitizenRepository;
import com.myAadharPortal.model.Citizen;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;

    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    public Citizen saveCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public void deleteCitizen(Long id) {
        citizenRepository.deleteById(id);
    }

    public Citizen updateCitizen(Long id, Citizen updatedCitizen) {
        Citizen existingCitizen = citizenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Citizen not found with ID: " + id));

        existingCitizen.setName(updatedCitizen.getName());
        existingCitizen.setDob(updatedCitizen.getDob());
        existingCitizen.setAddress(updatedCitizen.getAddress());
        existingCitizen.setEmail(updatedCitizen.getEmail());
        existingCitizen.setMobileNo(updatedCitizen.getMobileNo());
        existingCitizen.setGender(updatedCitizen.getGender());

        return citizenRepository.save(existingCitizen);
    }

	public Citizen findByEmail(String email) {
		// TODO Auto-generated method stub
		return citizenRepository.findByEmail(email);
	}
	public Citizen findByMobileNo(String mobileNo) {
		
		return citizenRepository.findByMobileNo(mobileNo);
	}
    
    
}
