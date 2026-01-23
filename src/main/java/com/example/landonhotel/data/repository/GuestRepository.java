package com.example.landonhotel.data.repository;

import com.example.landonhotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findGuestById(long id);
}
