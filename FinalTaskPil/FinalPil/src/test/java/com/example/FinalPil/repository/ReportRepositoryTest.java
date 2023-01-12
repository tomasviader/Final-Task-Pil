package com.example.FinalPil.repository;

import com.example.FinalPil.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.ArrayList;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ReportRepositoryTest {

    @Autowired
    ReportRepository reportRepository;

    Supervisor supervisor = Supervisor.builder()
            .id(1L)
            .supervisorName("Carlos")
            .build();

    Zone zone = Zone.builder()
            .id(2L)
            .name("Cba")
            .street("Salta")
            .number(200)
            .latitude(34)
            .longitude(65)
            .neighborhood("Centro")
            .status(true)
            .battery(true)
            .build();

    Report report = Report.builder()
            .zone(zone)
            .supervisor(supervisor)
            .capacity(Capacity.EMPTY)
            .complaint(Complaint.VANDALISM)
            .zoneState(ZoneState.INACCESSIBLE)
            .needResorting(false)
            .build();

    /*@Test
    void aNewReportShouldBeCreated(){

        Report savedReport = reportRepository.save(report);

        assertNotNull(savedReport);
    }*/

}
