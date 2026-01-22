package com.example.landonhotel.data.repository;

import com.example.landonhotel.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository<Room> extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNumberIgnoreCase(Room roomNumber);
}
