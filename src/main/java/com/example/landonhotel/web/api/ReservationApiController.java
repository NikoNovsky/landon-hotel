package com.example.landonhotel.web.api;

import com.example.landonhotel.data.entity.Reservation;
import com.example.landonhotel.data.repository.ReservationRepository;
import com.example.landonhotel.web.exception.BadRequestException;
import com.example.landonhotel.web.exception.NotFoundException;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam (value = "date", required = false) String date) {
        if (StringUtils.isNotBlank(date)) {
            return this.reservationRepository.findByResDate(LocalDate.parse(date));
        }
        return this.reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable(name = "id") long id) {
        Optional<Reservation> reservation = this.reservationRepository.findById(id);
        if (reservation.isEmpty()) {
            throw new NotFoundException("Reservation not found with id " + id);
        }
        return reservation.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable("id") long id) {
        if (id != reservation.getId()) {
            throw new BadRequestException("reservation id doesn't match with body");
        }
        return this.reservationRepository.save(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteReservationById(@PathVariable("id") long id) {
        this.reservationRepository.deleteById(id);
    }
}
