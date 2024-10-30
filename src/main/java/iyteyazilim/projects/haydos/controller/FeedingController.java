package iyteyazilim.projects.haydos.controller;

import iyteyazilim.projects.haydos.dto.FeedingDto;
import iyteyazilim.projects.haydos.entity.Feeding;
import iyteyazilim.projects.haydos.service.impl.FeedingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/feeding")
public class FeedingController {

     private final FeedingService feedingService;

     @PostMapping("/add")
     public ResponseEntity<Feeding> addFeeding(@RequestBody FeedingDto feedingDto) {
          return ResponseEntity.ok(feedingService.createFeeding(feedingDto));
     }

     @GetMapping("/get/{id}")
     public ResponseEntity<Feeding> getFeedingById(@PathVariable Long id) {
          return ResponseEntity.ok(feedingService.getFeedingById(id));
     }

     @GetMapping("/getAll")
     public ResponseEntity<List<Feeding>> getAllFeedings() {
          return ResponseEntity.ok(feedingService.getAllFeedings());
     }

     @PutMapping("/update/{id}")
     public ResponseEntity<Feeding> updateFeeding(@PathVariable Long id, @RequestBody FeedingDto feedingDto) {
          Feeding updatedFeeding = feedingService.updateFeeding(id, feedingDto);
          return ResponseEntity.ok(updatedFeeding);
     }

     @DeleteMapping("/delete/{id}")
     public ResponseEntity<String> deleteFeeding(@PathVariable Long id) {
          feedingService.deleteFeeding(id);
          return ResponseEntity.ok("Feeding record deleted successfully.");
     }

     @PutMapping("/approve/{id}")
     public ResponseEntity<Feeding> approveFeeding(@PathVariable Long id) {
          Feeding feeding = feedingService.getFeedingById(id);
          feedingService.approvedFeeding(feeding);
          return ResponseEntity.ok(feeding);
     }
}
