package com.example.FinalPil.controller;

import com.example.FinalPil.model.Zone;

import com.example.FinalPil.repository.ZoneRepository;
import com.example.FinalPil.service.ZoneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ZoneController.class)
class ZoneControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    ZoneService zoneService;
    
     @MockBean
    ZoneRepository zoneRepository;
    
    
    @Test
    void aNewZoneShouldBeCreated() throws Exception {
        Zone zone = Zone.builder()
                .name("Cba")
                .street("Salta")
                .number(200)
                .coordinates("40")
                .status(true).build();

        when(zoneService.saveZone(zone)).thenReturn(zone);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/zones")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(zone));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Cba")));
    }

    @Test
    void aZoneShouldBeModified() throws Exception {


        Zone zone_3 = new Zone(3L, "Almafuerte", "Salta", 190, "50",true);


        Zone updatedZone = Zone.builder()
                .id(zone_3.getId())
                .name("Cba")
                .street("Jujuy")
                .number(200)
                .coordinates("40")
                .status(false).build();

        Mockito.when(zoneRepository.findById(zone_3.getId())).thenReturn(Optional.of(zone_3));
        Mockito.when(zoneService.modifyZone(updatedZone.getId(),updatedZone)).thenReturn(updatedZone);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/zones/"+ updatedZone.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(updatedZone));

        this.mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Cba")))
                .andExpect(jsonPath("$.street", is("Jujuy")));

    }

    @Test
    void aZoneShouldBeDeleted()throws Exception{
        Zone zone1 = new Zone(3L, "Almafuerte", "Salta", 190, "50",true);

        Mockito.when(zoneRepository.findById(zone1.getId())).thenReturn(Optional.of(zone1));

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/zones/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}


