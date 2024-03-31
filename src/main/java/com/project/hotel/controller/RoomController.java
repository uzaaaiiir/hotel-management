package com.project.hotel.controller;

import com.project.hotel.model.Room;
import com.project.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/searchRooms")
    public String searchRooms(@RequestParam(required = false) String startDate,
                              @RequestParam(required = false) String endDate,
                              @RequestParam(required = false) Integer capacity,
                              @RequestParam(required = false) String city,
                              @RequestParam(required = false) String chainName,
                              @RequestParam(required = false) Integer rating,
                              @RequestParam(required = false) Double maxPrice,
                              Model model) {
        List<Room> rooms = roomService.findAvailableRooms(startDate, endDate, capacity, city, chainName, rating, maxPrice);
        model.addAttribute("rooms", rooms);
        return "customers/searchRoom";
    }

    @GetMapping("/rooms/{id}")
    public String viewRooms(@PathVariable Long id, Model model) {
        model.addAttribute("rooms", roomService.findRoomsByHotelId(id));
        return "hotel/rooms";
    }
}
