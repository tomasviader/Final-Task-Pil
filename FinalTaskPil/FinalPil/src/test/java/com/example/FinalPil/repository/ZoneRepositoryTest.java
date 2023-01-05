package com.example.FinalPil.repository;

import com.example.FinalPil.model.Zone;
import com.example.FinalPil.service.ZoneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ZoneRepositoryTest {

    @Autowired
    ZoneRepository zoneRepository;

    final Zone zone1 = new Zone(1L, "Salta", "Fl", 190, "50", "General Paz", true);
    final Zone zone2 = new Zone(2L, "Cordoba", "Sinsacate", 190, "50", "General Paz", true);



    @Test
    void aNewTestShouldBeCreated(){

        Zone savedZone = zoneRepository.save(zone1);

        assertNotNull(savedZone);
    }

    @Test
    void aZoneShouldBeModified() {
        Zone savedZone = zoneRepository.save(zone1);

        String newName = "Jujuy";
        Zone zoneUpdated = new Zone(1L, newName, "Islas Malvinas", 700, "20", "San Vicente" , true);

        zone1.setId(1L);
        zoneRepository.save(zoneUpdated);

        assertEquals(zoneUpdated.getName(), newName);
        assertEquals(zoneUpdated.getCoordinates(), "20");

    }

    @Test
    void aZoneShouldBeDeleted() {
        zoneRepository.save(zone1);

        zoneRepository.delete(zone1);

        assertEquals(Optional.empty(),zoneRepository.findById(zone1.getId()));

    }

    @Test
    void weShouldGetAllZones(){

        zoneRepository.save(zone1);
        zoneRepository.save(zone2);

        ArrayList<Zone> saveZones = new ArrayList<>();
        saveZones.add(zone1);
        saveZones.add(zone2);

        assertEquals(saveZones.get(1).getName(), zone2.getName());
    }

    /*Test
    void weShouldGetById(){
        zoneRepository.save(zone1);
        Long id = 1L;

        Zone testZone = zoneRepository.findById(id).get();

        assertEquals(testZone.getStreet(), zone1.getStreet());
    }

     */

}
