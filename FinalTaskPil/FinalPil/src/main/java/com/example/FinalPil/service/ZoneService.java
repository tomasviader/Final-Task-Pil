package com.example.FinalPil.service;

import com.example.FinalPil.model.Zone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZoneService {

    Zone saveZone(Zone zone);


    Zone modifyZone(Long id, Zone zone);
    

    void deleteZone(Long id);

    List<Zone> getZones ();

    Zone getZoneById(Long id);

    Zone getZoneByNeighborhood(String neighborhood);

    double getDistanceBetweenZonesById(Long idZone1, Long idZone2);

}
