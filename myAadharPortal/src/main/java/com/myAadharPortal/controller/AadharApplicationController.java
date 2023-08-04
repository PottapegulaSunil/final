package com.myAadharPortal.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myAadharPortal.model.*;
import com.myAadharPortal.service.*;



import com.myAadharPortal.model.AadharApplication;
import com.myAadharPortal.service.AadharApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/aadhar-applications")
public class AadharApplicationController {
    private AadharApplicationService applicationService;

    @Autowired
    public AadharApplicationController(AadharApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<AadharApplication> getAllAadharApplications() {
        return applicationService.getAllAadharApplications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AadharApplication> getAadharApplicationById(@PathVariable Long id) {
        AadharApplication application = applicationService.getAadharApplicationById(id);
        if (application != null) {
            return ResponseEntity.ok(application);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public AadharApplication createAadharApplication(@RequestBody AadharApplication application) {
        return applicationService.saveAadharApplication(application);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAadharApplication(@PathVariable Long id) {
        applicationService.deleteAadharApplication(id);
        return ResponseEntity.noContent().build();
    }

    // Admin actions for approving or denying Aadhar requests
    @PostMapping("/approve/{id}")
    public ResponseEntity<AadharApplication> approveAadharApplication(@PathVariable Long id) {
        AadharApplication application = applicationService.approveAadharApplication(id);
        if (application != null) {
            return ResponseEntity.ok(application);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/deny/{id}")
    public ResponseEntity<AadharApplication> denyAadharApplication(@PathVariable Long id) {
        AadharApplication application = applicationService.denyAadharApplication(id);
        if (application != null) {
            return ResponseEntity.ok(application);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

