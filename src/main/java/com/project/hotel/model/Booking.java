package com.project.hotel.model;

import java.sql.Date;
import java.time.LocalDate;

public class Booking {
    private Long bookingId;
    private Long roomId;
    private Long customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String roomStatus;
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

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Booking(Long roomId, Long customerId, LocalDate startDate, LocalDate endDate, String roomStatus, String paymentStatus) {
        this.roomId = roomId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomStatus = roomStatus;
        this.paymentStatus = paymentStatus;
    }
}
