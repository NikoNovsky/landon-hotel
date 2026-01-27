package com.example.landonhotel.web.api;

import com.example.landonhotel.data.entity.Room;
import com.example.landonhotel.data.repository.RoomRepository;
import com.example.landonhotel.web.exception.BadRequestException;
import com.example.landonhotel.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {

    private final RoomRepository roomRepository;

    public RoomApiController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody Room room) {
        System.out.println(room);
        return this.roomRepository.save(room);
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") long id) {
        Optional<Room> room = this.roomRepository.findById(id);
        if (room.isEmpty()) {
            throw new NotFoundException("room not found with id: " + id);
        }
        return room.get();
    }

//    moje rozwiązanie - jest gorsze od drugiego, bo zapisuję tylko konkrente pola, a nie cały obiekt
//    metoda PUT zapisuje cały obiekt (pokazać odpowiednie pola użytkownikowi i wszystkie się zapiszą)
//    jak dojdzie nowe pole, to mniej grzebania w backendzie (ew. tylko na froncie pokazujesz pole, a PUT i tak je zapisze do modelu)
//    @PutMapping("/{id}")
//    public Room updateRoom(@PathVariable("id") long id, @RequestBody Room room) {
//        Optional<Room> oldRoom = this.roomRepository.findById(id);
//        if (oldRoom.isEmpty()) {
//            throw new NotFoundException("room not found with id: " + id);
//        }
//        oldRoom.get().setName(room.getName());
//        oldRoom.get().setRoomNumber(room.getRoomNumber());
//        return this.roomRepository.save(oldRoom.get());
//    }

//    rozwiązanie wg instruktora
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable("id") long id, @RequestBody Room room) {
      if (id != room.getId()) {
          throw new BadRequestException("id on path does not match body");
      }
      return this.roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRoom(@PathVariable("id") long id) {
        this.roomRepository.deleteById(id);
    }
}
