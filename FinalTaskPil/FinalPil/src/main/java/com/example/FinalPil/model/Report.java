package com.example.FinalPil.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "\"Reports\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long supervisorId;

    @Column(nullable = false)
    private Long zoneId;

    @Column(nullable = false)
    private boolean needResorting;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ZoneState zoneState;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Complaint complaint;

}

