package com.project.hotel.service;

import com.project.hotel.model.Hotel;
import com.project.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public List<Hotel> findByHotelId(Long chainId) {
        return hotelRepository.findByChainId(chainId);
    }

    public Hotel findById(Long id) {
        return hotelRepository.findById(id);
    }

    public int addHotel(Hotel hotel) {
        return hotelRepository.addHotel(hotel);
    }

    public int updateHotel(Hotel hotel) {
        return hotelRepository.updateHotel(hotel);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteHotel(id);
    }
}
