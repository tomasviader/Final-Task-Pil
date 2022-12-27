package model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "\"Zone\"")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String street;

    @Column(length = 8)
    private int number;

    @Column(nullable = false)
    private String coordinates;

    @Column(nullable = false)
    private boolean status;



    //clasificacion falta saber como vamos a implentar (enum, etc)

}
