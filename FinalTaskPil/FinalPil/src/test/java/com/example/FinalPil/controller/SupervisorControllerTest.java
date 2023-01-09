package com.example.FinalPil.controller;

import com.example.FinalPil.model.Supervisor;
import com.example.FinalPil.model.Zone;
import com.example.FinalPil.repository.SupervisorRepository;
import com.example.FinalPil.repository.ZoneRepository;
import com.example.FinalPil.service.SupervisorService;
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

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SupervisorController.class)
class SupervisorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    SupervisorService supervisorService;

    @MockBean
    SupervisorRepository supervisorRepository;


    @Test
    void aNewSupervisorShouldBeCreated() throws Exception {
        Supervisor supervisor = Supervisor.builder()
                .supervisorName("Carlos")
                .build();

        when(supervisorService.saveSupervisor(supervisor)).thenReturn(supervisor);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/supervisors")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(supervisor));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.supervisorName", is("Carlos")));
    }

    @Test
    void aSupervisorShouldBeModified() throws Exception {

        Supervisor supervisor = Supervisor.builder()
                .id(1L)
                .supervisorName("Pepe")
                .build();

        Supervisor updatedSupervisor = Supervisor.builder()
                .id(supervisor.getId())
                .supervisorName("Laura")
                .build();

        Mockito.when(supervisorRepository.findById(supervisor.getId())).thenReturn(Optional.of(supervisor));
        Mockito.when(supervisorService.modifySupervisor(updatedSupervisor.getId(),updatedSupervisor)).thenReturn(updatedSupervisor);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/supervisors/"+ updatedSupervisor.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(updatedSupervisor));

        this.mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.supervisorName", is("Laura")));
    }
}