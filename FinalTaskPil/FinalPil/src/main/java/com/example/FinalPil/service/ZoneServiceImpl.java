package com.example.FinalPil.service;

import lombok.AllArgsConstructor;
import com.example.FinalPil.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.FinalPil.repository.ZoneRepository;

import java.util.Objects;

@Service
@AllArgsConstructor
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    ZoneRepository zoneRepository;

    @Override
    public Zone saveZone(Zone zone) {
        return zoneRepository.save(zone);
    }

    @Override
    public Zone updateZoneStatus(Long zoneId, Zone zone) {
        Zone zoneDB = zoneRepository.findById(zoneId).get();

        if (Objects.nonNull(zone.isStatus())){
            zoneDB.setStatus(zone.isStatus());
        }
        return zoneRepository.save(zoneDB);
    }
}
