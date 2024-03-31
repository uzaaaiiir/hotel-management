package com.project.hotel.controller;

import com.project.hotel.model.Customer;
import com.project.hotel.model.Hotel;
import com.project.hotel.service.HotelChainService;
import com.project.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelChainService hotelChainService;

    @GetMapping
    public String listHotels(Model model) {
        model.addAttribute("hotels", hotelService.findAll());
        return "hotel/listHotels";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("hotelChains", hotelChainService.findAll());
        return "hotel/add";
    }

    @PostMapping
    public String saveHotel(@ModelAttribute Hotel hotel) {
        hotelService.addHotel(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Hotel hotel = hotelService.findById(id);

        if (hotel != null) {
            model.addAttribute("hotel", hotel);
            model.addAttribute("hotelChain", hotelChainService.findById(hotel.getChainId()));
            return "hotel/edit";
        } else {
            return "redirect:/hotels";
        }
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.updateHotel(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return "redirect:/hotels";
    }

}
