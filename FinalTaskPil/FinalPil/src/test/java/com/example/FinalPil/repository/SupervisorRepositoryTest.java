package com.example.FinalPil.repository;

import com.example.FinalPil.model.Supervisor;
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
    void aNewTestShouldBeCreated() {

        Supervisor savedZone = supervisorRepository.save(supervisor1);

        assertNotNull(savedZone);
    }

}
