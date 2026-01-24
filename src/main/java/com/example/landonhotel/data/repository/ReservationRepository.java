package com.example.landonhotel.data.repository;

import com.example.landonhotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByResDate(LocalDate reservationDate);
}
