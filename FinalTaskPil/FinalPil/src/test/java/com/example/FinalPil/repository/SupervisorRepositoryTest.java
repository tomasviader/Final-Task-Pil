package com.example.FinalPil.repository;

import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.model.Zone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SupervisorRepositoryTest {

    @Autowired
    SupervisorRepository supervisorRepository;

    Supervisor supervisor1 = Supervisor.builder()
            .id(1L)
            .supervisorName("Ana")
            .build();

    Supervisor supervisor2 = Supervisor.builder()
            .id(2L)
            .supervisorName("Juan")
            .build();

    @Test
    void aNewSupervisorShouldBeCreated() {

        Supervisor savedZone = supervisorRepository.save(supervisor1);

        assertNotNull(savedZone);
    }

    @Test
    void aSupervisorShouldBeModified() {
        Supervisor savedSupervisor = supervisorRepository.save(supervisor1);

        String newSupervisorName = "Mateo";
        Supervisor updatedSupervisor = Supervisor.builder()
                .id(1L)
                .supervisorName(newSupervisorName)
                .build();

        supervisor1.setId(1L);
        supervisorRepository.save(updatedSupervisor);

        assertEquals(updatedSupervisor.getSupervisorName(), newSupervisorName);
    }

}
