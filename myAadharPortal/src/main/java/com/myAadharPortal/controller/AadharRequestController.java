package com.myAadharPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myAadharPortal.model.AadharRequest;
import com.myAadharPortal.service.AadharRequestService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/aadhar-requests")
public class AadharRequestController {
    private final AadharRequestService aadharRequestService;

    @Autowired
    public AadharRequestController(AadharRequestService aadharRequestService) {
        this.aadharRequestService = aadharRequestService;
    }

    @PostMapping("/apply")
    public ResponseEntity<AadharRequest> applyForAadhar(@RequestBody AadharRequest aadharRequest) {
        AadharRequest createdAadharRequest = aadharRequestService.applyForAadhar(aadharRequest);
        return new ResponseEntity<>(createdAadharRequest, HttpStatus.CREATED);
    }

    @GetMapping("/approved")
    public ResponseEntity<List<AadharRequest>> getApprovedAadharApplications() {
        List<AadharRequest> approvedAadharApplications = aadharRequestService.getAllApprovedAadharApplications();
        return new ResponseEntity<>(approvedAadharApplications, HttpStatus.OK);
    }

    @GetMapping("/status/{citizenId}")
    public ResponseEntity<String> getAadharStatusByCitizenId(@PathVariable Long citizenId) {
        String status = aadharRequestService.getStatusByCitizenId(citizenId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @PostMapping("/approve/{requestId}")
    public ResponseEntity<AadharRequest> approveAadharRequest(@PathVariable Long requestId) {
        AadharRequest approvedRequest = aadharRequestService.approveAadharRequest(requestId);
        if (approvedRequest != null) {
            return new ResponseEntity<>(approvedRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/deny/{requestId}")
    public ResponseEntity<AadharRequest> denyAadharRequest(@PathVariable Long requestId) {
        AadharRequest deniedRequest = aadharRequestService.denyAadharRequest(requestId);
        if (deniedRequest != null) {
            return new ResponseEntity<>(deniedRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<AadharRequest>> getAllAadharRequests() {
        List<AadharRequest> allAadharRequests = aadharRequestService.getAllAadharRequests();
        return new ResponseEntity<>(allAadharRequests, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{requestId}")
    public ResponseEntity<Void> deleteAadharRequest(@PathVariable Long requestId) {
        boolean deleted = aadharRequestService.deleteAadharRequest(requestId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

