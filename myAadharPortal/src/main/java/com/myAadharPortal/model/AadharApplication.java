package com.myAadharPortal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class AadharApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long citizenId;
    private String passportId; // If applicable
    private LocalDate applicationDate;
    private String status; 

    // Default constructor
    public AadharApplication() {
    }

    // Parameterized constructor
    public AadharApplication(Long citizenId, String passportId, LocalDate applicationDate) {
        this.citizenId = citizenId;
        this.passportId = passportId;
        this.applicationDate = applicationDate;
        this.status = "Pending"; // Assuming the application status is "Pending" by default
    }

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

