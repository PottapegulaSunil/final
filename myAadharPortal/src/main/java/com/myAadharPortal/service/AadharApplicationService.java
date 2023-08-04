package com.myAadharPortal.service;



import com.myAadharPortal.model.AadharApplication;
import com.myAadharPortal.Repo.AadharApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AadharApplicationService {
    private AadharApplicationRepository applicationRepository;

    @Autowired
    public AadharApplicationService(AadharApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<AadharApplication> getAllAadharApplications() {
        return applicationRepository.findAll();
    }

    public AadharApplication getAadharApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    public AadharApplication saveAadharApplication(AadharApplication application) {
        return applicationRepository.save(application);
    }

    public void deleteAadharApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    public AadharApplication approveAadharApplication(Long id) {
        AadharApplication application = applicationRepository.findById(id).orElse(null);
        if (application != null) {
            application.setStatus("Approved");
            return applicationRepository.save(application);
        }
        return null;
    }

    public AadharApplication denyAadharApplication(Long id) {
        AadharApplication application = applicationRepository.findById(id).orElse(null);
        if (application != null) {
            application.setStatus("Denied");
            return applicationRepository.save(application);
        }
        return null;
    }
}

