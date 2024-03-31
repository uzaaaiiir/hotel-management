package com.project.hotel.service;

import com.project.hotel.model.HotelChain;
import com.project.hotel.repository.HotelChainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelChainService {
    @Autowired
    private HotelChainRepository hotelChainRepository;

    public List<HotelChain> findAll() {
        return hotelChainRepository.findAll();
    }

    public HotelChain findById(Long id) {
        return hotelChainRepository.findById(id);
    }

    public int addHotelChain(HotelChain hotelChain) {
        return hotelChainRepository.addHotelChain(hotelChain);
    }

    public void deleteHotelChain(Long id) {
        hotelChainRepository.deleteHotelChain(id);
    }
}
