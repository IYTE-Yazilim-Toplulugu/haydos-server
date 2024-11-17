package iyteyazilim.projects.haydos.controller;

import iyteyazilim.projects.haydos.dto.PawDto;
import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.service.impl.PawsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

// http://localhost:8088/api/v1/paws
@RestController
@RequestMapping("api/v1/paws")
@AllArgsConstructor
public class PawController {

    private final PawsService pawsService;

    @PostMapping("/add")
    public ResponseEntity<Paws> createPaws(@RequestBody PawDto pawDto) {
        Paws createdPaws = pawsService.createPaws(pawDto);
        return ResponseEntity.ok(createdPaws);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paws> getPawsById(@PathVariable("id") Long id) {
        Paws paws = pawsService.getPawsById(id);
        return ResponseEntity.ok(paws);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Paws>> getAllPaws() {
        List<Paws> allPaws = pawsService.getAllPaws();
        return ResponseEntity.ok(allPaws);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Paws> updatePaw(@PathVariable("id") Long id, @RequestBody PawDto pawDto) {
        Paws updatedPaws = pawsService.updatePaw(id, pawDto);
        return ResponseEntity.ok(updatedPaws);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, String>> deletePaws(@PathVariable("id") Long id) {
        pawsService.deletePaws(id);

        HashMap<String, String> response = new HashMap<>();
        response.put("Message", "Paw with ID '" + id + "' has been successfully deleted.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<Paws> approvePaws(@PathVariable("id") Long id) {
        Paws paws = pawsService.getPawsById(id);
        pawsService.approvePaws(paws);
        return ResponseEntity.ok(paws);
    }
}
