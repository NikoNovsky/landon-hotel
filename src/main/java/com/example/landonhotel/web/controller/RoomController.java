package com.example.landonhotel.web.controller;

import com.example.landonhotel.data.entity.Room;
import com.example.landonhotel.data.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Room> getRooms(Model model) {
        return roomRepository.findAll();
    }

    @GetMapping
    public String loadPage() {
        return "room-list";
    }
}
