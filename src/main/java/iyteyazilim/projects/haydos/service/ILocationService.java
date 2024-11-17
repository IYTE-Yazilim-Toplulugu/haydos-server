package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.LocationDto;
import iyteyazilim.projects.haydos.entity.Location;

import java.util.List;

public interface ILocationService {

    Location createLocation(LocationDto location);

    Location getLocationById(Long locationId);

    List<Location> getAllLocation();

    Location updateLocation(Long LocationId , LocationDto locationDto);

    void deleteLocation(Long locationId);
}
