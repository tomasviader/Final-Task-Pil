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

        if (Objects.nonNull(zone.getLatitude())) {
            zoneDB.setLatitude(zone.getLatitude());
        }

        if (Objects.nonNull(zone.getLongitude())) {
            zoneDB.setLongitude(zone.getLongitude());
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

    @Override
    public String getDistanceBetweenZonesById(Long idZone1, Long idZone2){

        Zone zone1 = getZoneById(idZone1);
        Zone zone2 = getZoneById(idZone2);

        double latZoneOne = Math.toRadians(zone1.getLatitude());
        double lonZoneOne = Math.toRadians(zone1.getLongitude());
        double latZoneTwo = Math.toRadians(zone2.getLatitude());
        double lonZoneTwo = Math.toRadians(zone2.getLongitude());
        double earthRadius = 6371.01;

        double result = Math.round(earthRadius * Math.acos(Math.sin(latZoneOne) * Math.sin(latZoneTwo)
                + Math.cos(latZoneOne) * Math.cos(latZoneTwo) * Math.cos(lonZoneOne - lonZoneTwo)));

        return "The distance between " + zone1.getName() + " and " + zone2.getName()
                + " is: " + result + "Km.";
    }

    @Override
    public String getFastestFillingZone(Long idZone1, Long idZone2) {
        Zone zone1 = getZoneById(idZone1);
        Zone zone2 = getZoneById(idZone2);
        String zoneOneFaster = zone1.getName() + " is faster to fill than " + zone2.getName() + "";
        String zoneTwoFaster = zone2.getName() + " is faster to fill than " + zone1.getName() + "";
        if (zone1.getCapacity().areEmpty(zone2.getCapacity())) {
            return "At least one zone does not have to be empty";
        }
        if (zone1.getCapacity().equals(zone2.getCapacity())){
            return "The two zones are equally fast";
        }
        if (zone1.getCapacity().isFasterThan(zone2.getCapacity())){
            return zoneOneFaster;
        } else{
            return zoneTwoFaster;
        }
    }
}

