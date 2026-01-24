package com.example.landonhotel.web.controller;

import com.example.landonhotel.service.RoomReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/room-reservations")
public class RoomReservationController {

    private final RoomReservationService roomReservationService;

    public RoomReservationController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }

    @GetMapping
    public String showRoomReservations(Model model, @RequestParam(value = "date", required = false) String date) {
        model.addAttribute("roomReservations", this.roomReservationService.getRoomReservationsForDate(date));
        return "room-reservations";
    }
}
