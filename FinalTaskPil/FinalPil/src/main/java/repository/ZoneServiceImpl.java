package repository;

import model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    ZoneRepository zoneRepository;
}

