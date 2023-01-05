package com.example.FinalPil.service;

import com.example.FinalPil.model.Zone;

import java.util.List;

public interface ZoneService {

    Zone saveZone(Zone zone);


    Zone modifyZone(Long id, Zone zone);
    

    void deleteZone(Long id);

    List<Zone> getZones ();

    Zone getZoneById(Long id);

    Zone getZoneByNeighborhood(String neighborhood);

}
