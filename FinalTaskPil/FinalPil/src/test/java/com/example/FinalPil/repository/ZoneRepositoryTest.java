package com.example.FinalPil.repository;

import com.example.FinalPil.model.Zone;
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


    Zone zone1 = Zone.builder()
            .id(1L)
            .name("Salta")
            .street("Fl")
            .number(190)
            .latitude(20)
            .longitude(30)
            .neighborhood("General Paz")
            .status(true)
            .build();
    Zone zone2 = Zone.builder()
            .id(2L)
            .name("Cordoba")
            .street("Sinsacate")
            .number(190)
            .latitude(20)
            .longitude(30)
            .neighborhood("General Paz")
            .status(true)
            .build();


    @Test
    void aNewZoneShouldBeCreated(){

        Zone savedZone = zoneRepository.save(zone1);

        assertNotNull(savedZone);
    }

    @Test
    void aZoneShouldBeModified() {
        Zone savedZone = zoneRepository.save(zone1);

        String newName = "Jujuy";
        Zone zoneUpdated = Zone.builder()
                .id(1L)
                .name(newName)
                .street("Islas Malvinas")
                .number(700)
                .latitude(20)
                .longitude(30)
                .neighborhood("San Vicente")
                .status(true)
                .build();

        zone1.setId(1L);
        zoneRepository.save(zoneUpdated);

        assertEquals(zoneUpdated.getName(), newName);
        assertEquals(zoneUpdated.getLatitude(), 20);
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
