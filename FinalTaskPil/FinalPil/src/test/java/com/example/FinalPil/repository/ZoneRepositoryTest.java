package com.example.FinalPil.repository;

import com.example.FinalPil.model.Zone;
import com.example.FinalPil.service.ZoneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ZoneRepositoryTest {

    @Autowired
    ZoneRepository zoneRepository;

    @Test

    void aNewTestShouldBeCreated(){
        Zone zone = new Zone(1L, "Almafuerte", "Islas Malvinas", 700, "20",true);


        Zone savedZone = zoneRepository.save(zone);

        assertNotNull(savedZone);
    }

    @Test
    void aZoneShouldBeModified() {
        Zone zone = new Zone(1L, "Almafuerte", "Islas Malvinas", 700, "20", true);
        Zone savedZone = zoneRepository.save(zone);

        String newName = "Cordoba";
        Zone zone1 = new Zone(1L, newName, "Islas Malvinas", 700, "20", true);

        zone1.setId(1L);
        zoneRepository.save(zone1);

        Zone updatedZone = zoneRepository.findByName(newName);
        assertEquals(zone1.getName(), newName);
        assertEquals(zone1.getCoordinates(), "20");

    }

    @Test
    void aZoneShouldBeDeleted() {
        Zone zone = new Zone(1L, "Almafuerte", "Islas Malvinas", 700, "20", true);
        zoneRepository.save(zone);

        zoneRepository.delete(zone);

        assertEquals(Optional.empty(),zoneRepository.findById(zone.getId()));

    }


}
