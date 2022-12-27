package service;

import model.Zone;

public interface ZoneService {

    Zone saveZone(Zone zone);

    Zone modifyZone(Long id, Zone zoneId);


}
