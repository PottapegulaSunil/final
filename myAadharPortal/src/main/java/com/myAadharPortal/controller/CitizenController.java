package com.myAadharPortal.controller;
import java.util.List;


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

import com.myAadharPortal.service.CitizenService;
import com.myAadharPortal.model.Admin;
import com.myAadharPortal.model.Citizen;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/citizens")
public class CitizenController {
    @Autowired
    private CitizenService citizenService;

    @GetMapping
    public List<Citizen> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @PostMapping
    public Citizen createCitizen(@RequestBody Citizen citizen) {
        return citizenService.saveCitizen(citizen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitizen(@PathVariable Long id) {
        citizenService.deleteCitizen(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Citizen loginRequest) {
        String mobile = loginRequest.getMobileNo();
        String password = loginRequest.getPassword();

        // Validate admin email and password
        Citizen citizen = citizenService.findByMobileNo(mobile);
        if (citizen == null || !citizen.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        return ResponseEntity.ok("\"Login successful\"");

    // Add other endpoints for specific citizen-related operations
}
}
