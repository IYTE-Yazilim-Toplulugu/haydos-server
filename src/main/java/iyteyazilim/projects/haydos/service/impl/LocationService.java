package iyteyazilim.projects.haydos.service.impl;


import iyteyazilim.projects.haydos.dto.LocationDto;
import iyteyazilim.projects.haydos.entity.Location;
import iyteyazilim.projects.haydos.exeception.NotFoundResourceUnApproved;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.repository.ILocationRepository;
import iyteyazilim.projects.haydos.service.ILocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService implements ILocationService {
    private ILocationRepository locationRepository ;
    @Override
    public Location createLocation(LocationDto locationDto) {
        if(locationDto != null){
            Location location = new Location();
            location.setName(locationDto.getName());
            location.setFeedings(null);
            location.setDescription(locationDto.getDescription());
            location.setLatitude(locationDto.getLatitude());
            location.setLongitude(locationDto.getLongitude());
            location.setPawsInHere(null);
            return locationRepository.save(location);
        }
        else throw new ResourceNotFoundException("Your location object is empty. ");
    }

    @Override
    public Location getLocationById(Long locationId) {
        return locationRepository.findById(locationId).orElseThrow(() -> new NotFoundResourceUnApproved("Your location is not found."));
    }

    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    @Override
    public Location updateLocation(Long ID, LocationDto locationDto) {
        if(locationDto != null){
            Location location = locationRepository.findById(ID).orElseThrow(()-> new NotFoundResourceUnApproved("Your location with that "+ID+" is not found."));
            location.setName(locationDto.getName());
            location.setDescription(locationDto.getDescription());
            location.setLatitude(locationDto.getLatitude());
            location.setLongitude(locationDto.getLongitude());

            return locationRepository.save(location);
        }
        else throw new ResourceNotFoundException("Your location is empty object");
    }

    @Override
    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }
}
