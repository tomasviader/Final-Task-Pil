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


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ZoneController.class)
class ZoneControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Mock
    private ObjectWriter objectWriter;

    @MockBean
    ZoneService zoneService;

    Zone zone_1 = new Zone(1L, "Almafuerte", "Islas Malvinas", 280, "20");
    Zone zone_2 = new Zone(2L, "Cordoba", "Rondeau", 395, "30");
    Zone zone_3 = new Zone(3L, "Almafuerte", "Salta", 190, "50");

    @Test
    void ANewZoneShouldBeCreated() throws Exception {
        Zone zone = Zone.builder()
                .name("Cba")
                .street("Salta")
                .number(200)
                .coordinates("40").build();

        Mockito.when(zoneService.saveZone(zone)).thenReturn(zone);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/zones")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(zone));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Cba")));
    }

}