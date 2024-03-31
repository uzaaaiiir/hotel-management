package com.project.hotel.model;

public class Hotel {
    private Long hotelId;
    private Long chainId;
    private String name;
    private String address;
    private String city;
    private String emailAddress;
    private Integer noOfRooms;
    private Integer rating;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Hotel() {
    }

    public Hotel(Long hotelId, Long chainId, String address, String city, String emailAddress, Integer noOfRooms, Integer rating) {
        this.hotelId = hotelId;
        this.chainId = chainId;
        this.address = address;
        this.city = city;
        this.emailAddress = emailAddress;
        this.noOfRooms = noOfRooms;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", chainId=" + chainId +
                ", chainName='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", noOfRooms=" + noOfRooms +
                ", rating=" + rating +
                '}';
    }
}
