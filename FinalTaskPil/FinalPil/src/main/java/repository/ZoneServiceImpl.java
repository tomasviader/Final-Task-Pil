package repository;

import model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.*;
import service.ZoneService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ZoneServiceImpl implements ZoneService {
    @Autowired
    ZoneRepository zoneRepository;



    /*public Optional<Zone> updateZone(Long id, Zone zone) {
      *//*  if (zones.contains(id)) {
            int i = zones.indexOf(existing);
            zones.set(i, zone);
        }else{
            throw new IllegalArgumentException("Zone not found");
        }*//*

       *//* return zoneRepository.findById(id)
                .map( oldZone -> {
                Zone updated = oldZone.updateWith(zone);
                repository.save(updated);
        });*//*
    }*/
}

