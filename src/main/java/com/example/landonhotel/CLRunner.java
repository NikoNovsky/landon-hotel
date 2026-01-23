package com.example.landonhotel;

import com.example.landonhotel.data.entity.Guest;
import com.example.landonhotel.data.entity.Reservation;
import com.example.landonhotel.data.entity.Room;
import com.example.landonhotel.data.repository.GuestRepository;
import com.example.landonhotel.data.repository.ReservationRepository;
import com.example.landonhotel.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Room> rooms = this.roomRepository.findAll();
//        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
//        System.out.println(room);
//        rooms.forEach(System.out::println);

        List<Guest> guests = this.guestRepository.findAll();
        Optional<Guest> guest = this.guestRepository.findGuestById(1);
        System.out.println(guest);
        guests.forEach(System.out::println);

        List<Reservation> reservations = this.reservationRepository.findAll();
        Optional<Reservation> reservation = this.reservationRepository.findByResDate(new Date(2023-1900, 7, 28));
        System.out.println(new Date(2023-1900, 7, 28));
        System.out.println(reservation);
        reservations.forEach(System.out::println);
    }
}
