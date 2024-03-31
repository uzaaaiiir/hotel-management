package com.project.hotel.model;

public class HotelChain {
    private Long chainId;
    private String name;
    private Integer noOfHotels;

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

    public Integer getNoOfHotels() {
        return noOfHotels;
    }

    public void setNoOfHotels(Integer noOfHotels) {
        this.noOfHotels = noOfHotels;
    }

    public HotelChain() {
    }

    public HotelChain(Long chainId, String name, Integer noOfHotels) {
        this.chainId = chainId;
        this.name = name;
        this.noOfHotels = noOfHotels;
    }

    @Override
    public String toString() {
        return "HotelChain{" +
                "chainId=" + chainId +
                ", name='" + name + '\'' +
                ", noOfHotels=" + noOfHotels +
                '}';
    }
}
