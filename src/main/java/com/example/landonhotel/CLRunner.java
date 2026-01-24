package com.example.landonhotel;

import com.example.landonhotel.data.entity.Guest;
import com.example.landonhotel.data.entity.Reservation;
import com.example.landonhotel.data.entity.Room;
import com.example.landonhotel.data.repository.GuestRepository;
import com.example.landonhotel.data.repository.ReservationRepository;
import com.example.landonhotel.data.repository.RoomRepository;
import com.example.landonhotel.service.RoomReservationService;
import com.example.landonhotel.service.model.RoomReservation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomReservationService roomReservationService;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, RoomReservationService roomReservationService) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomReservationService = roomReservationService;
    }

    @Override
    public void run(String... args) throws Exception {
//        COMMENTED COS I DONT NEED THIS ANYMORE LIKE NOW

//        List<Room> rooms = this.roomRepository.findAll();
//        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
//        System.out.println(room);
//        rooms.forEach(System.out::println);
//
//        List<Guest> guests = this.guestRepository.findAll();
//        Optional<Guest> guest = this.guestRepository.findGuestById(1);
//        System.out.println(guest);
//        guests.forEach(System.out::println);
//
//        List<Reservation> reservations = this.reservationRepository.findAll();
//        List<Reservation> reservation = this.reservationRepository.findByResDate(LocalDate.of(2023, 8, 28));
//        System.out.println(reservation);
//        reservations.forEach(System.out::println);
//
//        List<RoomReservation> roomReservations = this.roomReservationService.getRoomReservationsForDate("2023-08-28");
//        roomReservations.forEach(System.out::println);

    }
}
