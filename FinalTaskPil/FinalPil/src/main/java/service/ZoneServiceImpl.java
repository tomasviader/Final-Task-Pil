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
    public Zone updateZoneStatus(Long zoneId, Zone zone) {
        Zone zoneDB = zoneRepository.findById(zoneId).get();

        if (Objects.nonNull(zone.isStatus())){
            zoneDB.setStatus(zone.isStatus());
        }
        return zoneRepository.save(zoneDB);
    }
}
