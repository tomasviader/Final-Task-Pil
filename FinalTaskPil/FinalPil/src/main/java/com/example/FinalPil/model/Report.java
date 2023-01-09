package com.example.FinalPil.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Report\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String supervisor;//change

    @Column(nullable = false)
    private Zone zone;

    @Column(length = 8)
    private String capacity; //change

    @Column(nullable = false)
    private boolean needResorting;

    @Column(nullable = false)
    private String zoneState; //change

    @Column(nullable = false)
    private String complaint; //change

}
