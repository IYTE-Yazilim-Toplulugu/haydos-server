package iyteyazilim.projects.haydos.controller;

import iyteyazilim.projects.haydos.dto.LocationDto;
import iyteyazilim.projects.haydos.entity.Location;
import iyteyazilim.projects.haydos.service.impl.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/add")
    public ResponseEntity<Location> addLocation(@RequestBody LocationDto locationDto) {
        return ResponseEntity.ok(locationService.createLocation(locationDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocation());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody LocationDto locationDto) {
        return ResponseEntity.ok(locationService.updateLocation(id, locationDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.ok("Location deleted successfully.");
    }
}
