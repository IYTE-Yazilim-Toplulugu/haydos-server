package iyteyazilim.projects.haydos.service.impl;


import iyteyazilim.projects.haydos.entity.Location;
import iyteyazilim.projects.haydos.service.ILocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService implements ILocationService {
    @Override
    public Location createLocation(Location location) {
        return null  ;
    }

    @Override
    public Location getLocationById(Long locationId) {
        return null;
    }

    @Override
    public List<Location> getAllLocation() {
        return null;
    }

    @Override
    public Location updateLocation(Long LocationId, Location locationDto) {
        return null;
    }

    @Override
    public void deleteLocation(Long locationId) {

    }
}
