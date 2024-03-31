package com.project.hotel.service;

import com.project.hotel.model.Room;
import com.project.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public List<Room> findAvailableRooms(String startDate, String endDate, Integer capacity, String city, String chainName, Integer rating, Double maxPrice) {
        return roomRepository.findAvailableRooms(startDate, endDate, capacity, city, chainName, rating, maxPrice);
    }

    public List<Room> findAllRooms() {
        return roomRepository.viewAllRooms();
    }

    public List<Room> findRoomsByHotelId(Long id) {
        return roomRepository.findByHotelId(id);
    }
}
