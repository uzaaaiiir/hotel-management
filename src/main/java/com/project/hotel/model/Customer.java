package com.project.hotel.model;

import java.time.LocalDate;

public class Customer {
    private Long customerId;
    private String idNumber;
    private String firstName;
    private String lastName;
    private String typeOfId;
    private LocalDate registrationDate;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTypeOfId() {
        return typeOfId;
    }

    public void setTypeOfId(String typeOfId) {
        this.typeOfId = typeOfId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Customer() {
    }

    public Customer(String idNumber, String firstName, String lastName, String typeOfId, LocalDate registrationDate) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfId = typeOfId;
        this.registrationDate = registrationDate;
    }
}
