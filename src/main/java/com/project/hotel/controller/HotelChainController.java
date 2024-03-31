package com.project.hotel.controller;

import com.project.hotel.model.HotelChain;
import com.project.hotel.service.HotelChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotelchains")
public class HotelChainController {
    @Autowired
    private HotelChainService hotelChainService;

    @GetMapping
    public String listHotelChains(Model model) {
        model.addAttribute("hotelChains", hotelChainService.findAll());
        return "hotel/chains";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hotelChain", new HotelChain());
        return "/hotel/addChain";
    }

    @PostMapping
    public String addHotelChain(@ModelAttribute HotelChain hotelChain) {
        hotelChainService.addHotelChain(hotelChain);
        return "redirect:/hotelchains";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotelChain(@PathVariable Long id) {
        hotelChainService.deleteHotelChain(id);
        return "redirect:/hotelchains";
    }
}
