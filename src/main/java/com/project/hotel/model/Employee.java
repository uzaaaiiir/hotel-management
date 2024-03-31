package com.project.hotel.model;

public class Employee {
    private Long employeeId;
    private Long hotelId;
    private Long positionId;
    private String firstName;
    private String lastName;
    private String address;
    private String ssnOrSinNo;
    private Boolean isManager;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSsnOrSinNo() {
        return ssnOrSinNo;
    }

    public void setSsnOrSinNo(String ssnOrSinNo) {
        this.ssnOrSinNo = ssnOrSinNo;
    }

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public Employee(Long hotelId, Long positionId, String firstName, String lastName, String address, String ssnOrSinNo, Boolean isManager) {
        this.hotelId = hotelId;
        this.positionId = positionId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ssnOrSinNo = ssnOrSinNo;
        this.isManager = isManager;
    }
}
