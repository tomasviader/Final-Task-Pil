package service;

import model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ZoneRepository;

@Service
class ZoneServiceImpl implements ZoneService {
    @Autowired
    ZoneRepository zoneRepository;

    @Override
    public Zone saveZone(Zone zone) {
        return zoneRepository.save(zone);
    }
}
