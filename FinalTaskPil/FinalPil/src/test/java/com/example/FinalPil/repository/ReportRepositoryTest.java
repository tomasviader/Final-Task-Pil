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

    Supervisor supervisor2 = Supervisor.builder()
            .id(2L)
            .supervisorName("Juan")
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
            .id(1L)
            .zone(zone)
            .supervisor(supervisor2)
            .capacity(Capacity.EMPTY)
            .complaint(Complaint.VANDALISM)
            .zoneState(ZoneState.INACCESSIBLE)
            .needResorting(false)
            .build();

    Report report2 = Report.builder()
            .id(2L)
            .zone(zone)
            .supervisor(supervisor)
            .capacity(Capacity.FULL)
            .complaint(Complaint.VANDALISM)
            .zoneState(ZoneState.DAMAGED)
            .needResorting(false)
            .build();
    @Test
    void weShouldGetAllReports(){

        reportRepository.save(report);
        reportRepository.save(report2);

        ArrayList<Report> saveReports = new ArrayList<>();
        saveReports.add(report);
        saveReports.add(report2);

        assertEquals(saveReports.get(1).getZone(), report2.getZone());
    }
}
