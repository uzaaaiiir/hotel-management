package com.project.hotel.model;

import java.time.LocalDate;

public class Renting {
    private Long rentingId;
    private Long roomId;
    private Long customerId;
    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String paymentStatus;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Renting(Long roomId, Long customerId, Long employeeId, LocalDate startDate, LocalDate endDate, String paymentStatus) {
        this.roomId = roomId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentStatus = paymentStatus;
    }
}
