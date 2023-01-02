package com.example.FinalPil.repository;

import com.example.FinalPil.model.Zone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ZoneRepositoryTest {

    @Autowired
    ZoneRepository zoneRepository;

    @Test
    void ANewTestShouldBeCreated(){
        Zone zone = new Zone(1L, "Almafuerte", "Islas Malvinas", 700, "20");

        Zone savedZone = zoneRepository.save(zone);

        assertNotNull(savedZone);
    }
}