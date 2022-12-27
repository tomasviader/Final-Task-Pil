package service;

import model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ZoneRepository;

import java.util.Objects;

@Service
class ZoneServiceImpl implements ZoneService {
    @Autowired
    ZoneRepository zoneRepository;

    @Override
    public Zone saveZone(Zone zone) {
        return zoneRepository.save(zone);
    }


    @Override
    public Zone modifyZone(Long zoneId, Zone zone) {
        Zone zoneDB = zoneRepository.findById(zoneId).get();

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

        return zoneRepository.save(zoneDB);
    }
}

