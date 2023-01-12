package com.example.FinalPil.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "\"Zone\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, name = "01_name")
    private String name;

    @Column(nullable = false, name = "02_streetName")
    private String street;

    @Column(length = 8, name = "03_streetNumber")
    private int number;

    @Column(nullable = false, name = "04_latitude")
    private int latitude;

    @Column(nullable = false, name = "05_longitude")
    private int longitude;

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

}
