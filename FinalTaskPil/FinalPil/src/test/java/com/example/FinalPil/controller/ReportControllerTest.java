package com.example.FinalPil.controller;

import com.example.FinalPil.model.*;
import com.example.FinalPil.repository.ReportRepository;
import com.example.FinalPil.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ReportController.class)
class ReportControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ReportService reportService;

    @MockBean
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

    @Test
    void aNewReportShouldBeCreated() throws Exception {
        Report report = Report.builder()
                .zone(zone)
                .supervisor(supervisor)
                .capacity(Capacity.EMPTY)
                .complaint(Complaint.VANDALISM)
                .zoneState(ZoneState.INACCESSIBLE)
                .needResorting(false)
                .build();

        when(reportService.saveReport(report)).thenReturn(report);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/reports")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(report));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.needResorting", is(false)));
    }

    @Test
    void weShouldGetAllReports() throws Exception {
        Report report = Report.builder()
                .id(1L)
                .supervisor(supervisor)
                .zone(zone)
                .capacity(Capacity.EMPTY)
                .needResorting(false)
                .zoneState(ZoneState.INACCESSIBLE)
                .complaint(Complaint.UNUSED_AREA)
                .build();

        Report report2 = Report.builder()
                .id(2L)
                .supervisor(supervisor)
                .zone(zone)
                .capacity(Capacity.EMPTY)
                .needResorting(true)
                .zoneState(ZoneState.IN_MAINTENANCE)
                .complaint(Complaint.UNUSED_AREA)
                .build();

        List<Report> records = new ArrayList<>(Arrays.asList(report, report2));

        Mockito.when(reportService.getReports()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/reports")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].needResorting", is(false)));
    }

    @Test
    public void weShouldGetAReportById() throws Exception {
        Report report = Report.builder()
                .id(1L)
                .supervisor(supervisor)
                .zone(zone)
                .capacity(Capacity.EMPTY)
                .needResorting(false)
                .zoneState(ZoneState.INACCESSIBLE)
                .complaint(Complaint.UNUSED_AREA)
                .build();


        Mockito.when(reportService.getReportById(report.getId())).thenReturn(report);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/reports/" + report.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.needResorting", is(false)));
    }

    @Test
    void aReportShouldBeModified() throws Exception {

        Report report = Report.builder()
                .id(1L)
                .supervisor(supervisor)
                .zone(zone)
                .capacity(Capacity.EMPTY)
                .needResorting(false)
                .zoneState(ZoneState.INACCESSIBLE)
                .complaint(Complaint.UNUSED_AREA)
                .build();

        Report reportUpdated = Report.builder()
                .id(report.getId())
                .supervisor(supervisor)
                .zone(zone)
                .capacity(Capacity.FULL)
                .needResorting(true)
                .zoneState(ZoneState.DAMAGED)
                .complaint(Complaint.UNUSED_AREA)
                .build();

        Mockito.when(reportRepository.findById(report.getId())).thenReturn(Optional.of(report));
        Mockito.when(reportService.modifyReport(reportUpdated.getId(), reportUpdated)).thenReturn(reportUpdated);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/reports/" + reportUpdated.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(reportUpdated));

        this.mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.needResorting", is(true)))
                .andExpect(jsonPath("$.capacity", is("FULL")));

    }

    @Test
    void aReportShouldBeDeleted() throws Exception {
        Report report = Report.builder()
                .id(1L)
                .supervisor(supervisor)
                .zone(zone)
                .capacity(Capacity.EMPTY)
                .needResorting(false)
                .zoneState(ZoneState.INACCESSIBLE)
                .complaint(Complaint.UNUSED_AREA)
                .build();


        Mockito.when(reportRepository.findById(report.getId())).thenReturn(Optional.of(report));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/reports/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}