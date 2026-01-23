package com.example.landonhotel.data.repository;

import com.example.landonhotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByResDate(Date resDate);
}
