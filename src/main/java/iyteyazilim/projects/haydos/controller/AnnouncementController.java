package iyteyazilim.projects.haydos.controller;

import iyteyazilim.projects.haydos.dto.AnnouncementDto;
import iyteyazilim.projects.haydos.entity.Announcement;
import iyteyazilim.projects.haydos.service.impl.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
@AllArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping("/add")
    public ResponseEntity<Announcement> addAnnouncement(@RequestBody AnnouncementDto announcementDto) {
        return ResponseEntity.ok(announcementService.createAnnouncement(announcementDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Announcement>> getAllAnnouncements() {
        return ResponseEntity.ok(announcementService.getAllAnnouncements());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable("id") Long announcementId, @RequestBody AnnouncementDto announcement) {
        return ResponseEntity.ok(announcementService.updateAnnouncement(announcementId, announcement));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAnnouncement(@PathVariable("id") Long announcementId) {
        announcementService.deleteAnnouncement(announcementId);
        return ResponseEntity.ok("Announcement deleted successfully");
    }
}

