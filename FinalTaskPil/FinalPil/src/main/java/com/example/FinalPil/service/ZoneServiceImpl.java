package com.example.FinalPil.service;

import lombok.AllArgsConstructor;
import com.example.FinalPil.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.FinalPil.repository.ZoneRepository;

import java.util.List;
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

    public Zone modifyZone(Long id, Zone zone) {
        Zone zoneDB = zoneRepository.findById(id).get();

        if (Objects.nonNull(zone.getName())) {
            zoneDB.setName(zone.getName());
        }

        if (Objects.nonNull(zone.getStreet())) {
            zoneDB.setStreet(zone.getStreet());
            zoneDB.setNumber(zone.getNumber());
        }

        if (Objects.nonNull(zone.getCoordinates())) {
            zoneDB.setCoordinates(zone.getCoordinates());
        }

        if (Objects.nonNull(zone.isStatus())){
            zoneDB.setStatus(zone.isStatus());
        }

        return zoneRepository.save(zoneDB);
    }


    @Override
    public void deleteZone(Long id) {
        zoneRepository.deleteById(id);
    }

    @Override
    public List<Zone> getZones(){
        return zoneRepository.findAll();
    }

    @Override
    public Zone getZoneById(Long id){
        return zoneRepository.findById(id).get();
    }

    @Override
    public Zone getZoneByNeighborhood(String neighborhood){
        return zoneRepository.findByNeighborhood(neighborhood);
    }
}

