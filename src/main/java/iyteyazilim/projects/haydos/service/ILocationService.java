package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.LocationDto;

import java.util.List;

public interface ILocationService {

    LocationDto createLocation(LocationDto locationDto);

    LocationDto getLocationById(Long locationId);

    List<LocationDto> getAllLocation();

    LocationDto updateLocation(Long LocationId , LocationDto locationDto);

    void deleteLocation(Long locationId);
}
