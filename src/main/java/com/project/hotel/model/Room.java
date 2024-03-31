package com.project.hotel.model;

public class Room {
    private Long roomId;
    private Long hotelId;
    private String hotelChain;
    private String city;
    private String roomNumber;
    private Double price;
    private String amenities;
    private Integer capacity;
    private String view;
    private Boolean isExtendable;
    private String problemsAndDamages;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Boolean getIsExtendable() {
        return isExtendable;
    }

    public void setIsExtendable(Boolean extendable) {
        isExtendable = extendable;
    }

    public String getProblemsAndDamages() {
        return problemsAndDamages;
    }

    public void setProblemsAndDamages(String problemsAndDamages) {
        this.problemsAndDamages = problemsAndDamages;
    }

    public String getHotelChain() {
        return hotelChain;
    }

    public void setHotelChain(String hotelChain) {
        this.hotelChain = hotelChain;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Room() {
    }

    public Room(Long roomId, Long hotelId, String roomNumber, Double price, String amenities, Integer capacity, String view, Boolean isExtendable, String problemsAndDamages) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.price = price;
        this.amenities = amenities;
        this.capacity = capacity;
        this.view = view;
        this.isExtendable = isExtendable;
        this.problemsAndDamages = problemsAndDamages;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", hotelId=" + hotelId +
                ", roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", amenities='" + amenities + '\'' +
                ", capacity=" + capacity +
                ", view='" + view + '\'' +
                ", isExtendable=" + isExtendable +
                ", problemsAndDamages='" + problemsAndDamages + '\'' +
                '}';
    }
}
