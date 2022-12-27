package service;

import model.Zone;

public interface ZoneService {

    Zone saveZone(Zone zone);


    public Zone updateZoneStatus(Long zoneId, Zone zone);
}
