package controller;

import model.Zone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import repository.ZoneRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ZoneController.class)
class ZoneControllerTest {
    @Autowired
    ZoneRepository zoneRepository;

    @Test
    void ANewZoneShouldBeCreate(){
        Zone zone = new Zone(1L,"Almafuerte","I M", 280, "hola");
        zoneRepository.save(zone);
    }

}