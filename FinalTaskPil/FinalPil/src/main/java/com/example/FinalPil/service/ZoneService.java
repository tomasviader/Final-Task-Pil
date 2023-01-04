package com.example.FinalPil.service;

import com.example.FinalPil.model.Zone;

public interface ZoneService {

    Zone saveZone(Zone zone);


    Zone modifyZone(Long id, Zone zone);
    

    void deleteZone(Long id);

}
