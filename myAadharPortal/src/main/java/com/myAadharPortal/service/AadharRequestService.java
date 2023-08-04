package com.myAadharPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myAadharPortal.model.AadharRequest;
import com.myAadharPortal.Repo.AadharRequestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AadharRequestService {

    private final AadharRequestRepository aadharRequestRepository;

    @Autowired
    public AadharRequestService(AadharRequestRepository aadharRequestRepository) {
        this.aadharRequestRepository = aadharRequestRepository;
    }

    public AadharRequest applyForAadhar(AadharRequest aadharRequest) {
        // Check if the client provided values for currentStatus and typeOfApplication
        // If not provided, set the default values
        if (aadharRequest.getCurrentStatus() == null) {
            aadharRequest.setCurrentStatus("Pending");
        }

        if (aadharRequest.getTypeOfApplication() == null) {
            aadharRequest.setTypeOfApplication("New");
        }

        return aadharRequestRepository.save(aadharRequest);
    }


    public List<AadharRequest> getAllApprovedAadharApplications() {
        return aadharRequestRepository.findByCurrentStatus("Approved");
    }

    public String getStatusByCitizenId(Long citizenId) {
        AadharRequest aadharRequest = aadharRequestRepository.findByCitizenId(citizenId);
        if (aadharRequest != null) {
            return aadharRequest.getCurrentStatus();
        } else {
            return "Not Found";
        }
    }

    public AadharRequest approveAadharRequest(Long requestId) {
        AadharRequest aadharRequest = aadharRequestRepository.findById(requestId).orElse(null);
        if (aadharRequest != null) {
            aadharRequest.setCurrentStatus("Approved");
            return aadharRequestRepository.save(aadharRequest);
        }
        return null;
    }

    public AadharRequest denyAadharRequest(Long requestId) {
        AadharRequest aadharRequest = aadharRequestRepository.findById(requestId).orElse(null);
        if (aadharRequest != null) {
            aadharRequest.setCurrentStatus("Denied");
            return aadharRequestRepository.save(aadharRequest);
        }
        return null;
    }

    public List<AadharRequest> getAllAadharRequests() {
        return aadharRequestRepository.findAll();
    }

    public boolean deleteAadharRequest(Long requestId) {
        Optional<AadharRequest> optionalAadharRequest = aadharRequestRepository.findById(requestId);
        if (optionalAadharRequest.isPresent()) {
            AadharRequest aadharRequest = optionalAadharRequest.get();

            aadharRequestRepository.delete(aadharRequest);
            return true;
        }
        return false;
    }

}