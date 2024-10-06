package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.entity.Location;

import java.util.List;

public interface ILocationService {

    Location createLocation(Location location);

    Location getLocationById(Long locationId);

    List<Location> getAllLocation();

    Location updateLocation(Long LocationId , Location locationDto);

    void deleteLocation(Long locationId);
}
