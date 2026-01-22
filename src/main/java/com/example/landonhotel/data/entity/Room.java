package com.example.landonhotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "rooms")
@Data
@ToString
public class Room {
    @Id
    @Column(name="room_id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="room_number")
    private String roomNumber;

    @Column(name="bed_info")
    private String bedInfo;

    public Room(int id, String name, String roomNumber, String bedInfo) {
        this.id = id;
        this.name = name;
        this.roomNumber = roomNumber;
        this.bedInfo = bedInfo;
    }
}
