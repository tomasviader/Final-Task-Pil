package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Entity
@Table(name = "\"Zone\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
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


    //clasificacion falta saber como vamos a implentar (enum, etc)

}
