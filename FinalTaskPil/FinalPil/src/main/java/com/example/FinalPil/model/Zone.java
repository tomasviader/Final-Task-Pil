package com.example.FinalPil.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "\"Zones\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String street;

    @Column(length = 8)
    private int number;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private boolean battery;

    @Column(nullable = false)
    private boolean paper;

    @Column(nullable = false)
    private boolean glass;

    @Column(nullable = false)
    private boolean organicWaste;

    @Column(nullable = false)
    private boolean nonRecyclableWaste;

    @Enumerated
    @Column(nullable = false)
    private Capacity capacity;

}
