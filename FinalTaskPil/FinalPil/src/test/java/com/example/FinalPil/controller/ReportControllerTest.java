package com.example.FinalPil.controller;

import com.example.FinalPil.model.*;
import com.example.FinalPil.repository.ReportRepository;
import com.example.FinalPil.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
}