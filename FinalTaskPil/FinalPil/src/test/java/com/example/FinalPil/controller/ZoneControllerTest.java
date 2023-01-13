package com.example.FinalPil.controller;

import com.example.FinalPil.model.Zone;
import com.example.FinalPil.repository.ZoneRepository;
import com.example.FinalPil.service.ZoneService;
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
                .latitude(20)
                .longitude(30)
                .neighborhood("Centro")
                .status(true)
                .battery(true)
                .build();

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

        Zone zone_3 = Zone.builder()
                .id(1L)
                .name("Cordoba")
                .street("Sinsacate")
                .number(190)
                .latitude(20)
                .longitude(30)
                .neighborhood("General Paz")
                .status(true)
                .build();



        Zone updatedZone = Zone.builder()
                .id(zone_3.getId())
                .name("Cba")
                .street("Jujuy")
                .number(200)
                .latitude(34)
                .longitude(65)
                .neighborhood("Centro")
                .status(false)
                .build();

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
        Zone zone1 = Zone.builder()
                .id(1L)
                .name("Cordoba")
                .street("Sinsacate")
                .number(190)
                .latitude(20)
                .longitude(30)
                .neighborhood("General Paz")
                .status(true)
                .build();


        Mockito.when(zoneRepository.findById(zone1.getId())).thenReturn(Optional.of(zone1));

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/zones/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    void weShouldGetAllZones() throws Exception {
        Zone zone1 = Zone.builder()
                .id(1L)
                .name("Pampa")
                .street("Colon")
                .number(190)
                .latitude(20)
                .longitude(30)
                .neighborhood("General Paz")
                .status(true)
                .build();

        Zone zone2 = Zone.builder()
                .id(2L)
                .name("Almafuerte")
                .street("Salta")
                .number(3000)
                .latitude(20)
                .longitude(30)
                .neighborhood("Yapeyu")
                .status(false)
                .build();

        List<Zone> records = new ArrayList<>(Arrays.asList(zone1, zone2));

        Mockito.when(zoneService.getZones()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/zones")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].name", is("Almafuerte")));
    }

    @Test
    public void weShouldGetAZoneById() throws Exception {
        Zone zone1 = Zone.builder()
                .id(4L)
                .name("Catamarca")
                .street("Jujuy")
                .number(200)
                .latitude(20)
                .longitude(30)
                .neighborhood("Centro")
                .status(false)
                .build();


        Mockito.when(zoneService.getZoneById(zone1.getId())).thenReturn(zone1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/zones/" + zone1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Catamarca")));
    }

    @Test
    public void weShouldGetAZoneByNeighborhood() throws Exception {
        Zone zone1 = Zone.builder()
                .id(4L)
                .name("Catamarca")
                .street("Jujuy")
                .number(200)
                .latitude(20)
                .longitude(30)
                .neighborhood("Centro")
                .status(false)
                .build();

        Mockito.when(zoneService.getZoneByNeighborhood(zone1.getNeighborhood())).thenReturn(zone1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/zones/neighborhood/" + zone1.getNeighborhood())
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Catamarca")));
    }


    @Test
    public void weShouldGetTheDistanceBetweenTwoZonesById() throws Exception {
        Zone zone1 = Zone.builder()
                .id(1L)
                .name("Plaza España")
                .street("Avenida Irigoyen")
                .number(594)
                .latitude(-31.4290925)
                .longitude(-64.18715)
                .neighborhood("Nueva Cordoba")
                .paper(true)
                .battery(true)
                .status(true)
                .build();

        Zone zone2 = Zone.builder()
                .id(2L)
                .name("Plaza Colon")
                .street("Avenida Colon")
                .number(1000)
                .latitude(-31.4085704)
                .longitude(-64.1981353)
                .neighborhood("Alto Alberdi")
                .status(true)
                .battery(true)
                .organicWaste(true)
                .build();

        Mockito.when(zoneService.getZoneById(zone1.getId())).thenReturn(zone1);
        Mockito.when(zoneService.getZoneById(zone2.getId())).thenReturn(zone2);
        Mockito.when(zoneService.getDistanceBetweenZonesById(zone1.getId(), zone2.getId())).thenReturn(3.0);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/zones/distance/" + zone1.getId() + "-" + zone2.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


}


