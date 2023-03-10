package com.example.FinalPil.controller;

import com.example.FinalPil.model.Supervisor;
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

import static org.hamcrest.Matchers.*;
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
    SupervisorController controller;

    @Test
    void aNewSupervisorShouldBeCreated() throws Exception {
        Supervisor supervisor = Supervisor.builder()
                .supervisorName("Carlos")
                .build();

        when(controller.saveSupervisor(supervisor)).thenReturn(supervisor);

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

        Mockito.when(controller.getSupervisorById(supervisor.getId())).thenReturn(supervisor);
        Mockito.when(controller.modifySupervisor(updatedSupervisor.getId(),updatedSupervisor)).thenReturn(updatedSupervisor);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/supervisors/"+ updatedSupervisor.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(updatedSupervisor));

        this.mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.supervisorName", is("Laura")));
     }          

    @Test
    void aSupervisorShouldBeDeleted() throws Exception{
        Supervisor supervisor = Supervisor.builder()
                .id(1L)
                .supervisorName("Lautaro")
                .build();

        Mockito.when(controller.getSupervisorById(supervisor.getId())).thenReturn(supervisor);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/supervisors/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void weShouldGetAllSupervisors() throws Exception {
        Supervisor supervisor1 = Supervisor.builder()
                .id(1L)
                .supervisorName("Gabriel")
                .build();

        Supervisor supervisor2 = Supervisor.builder()
                .id(2L)
                .supervisorName("Enzo")
                .build();

        List<Supervisor> records = new ArrayList<>(Arrays.asList(supervisor1, supervisor2));

        Mockito.when(controller.getSupervisors()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/supervisors")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].supervisorName", is("Enzo")));
    }

    @Test
    void weShouldGetASupervisorById() throws Exception {
        Supervisor supervisor1 = Supervisor.builder()
                .id(4L)
                .supervisorName("Lautaro")
                .build();

        Mockito.when(controller.getSupervisorById(supervisor1.getId())).thenReturn(supervisor1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/supervisors/" + supervisor1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.supervisorName", is("Lautaro")));
    }
}


