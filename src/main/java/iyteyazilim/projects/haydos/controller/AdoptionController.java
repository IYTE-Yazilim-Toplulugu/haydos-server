
package iyteyazilim.projects.haydos.controller;


import iyteyazilim.projects.haydos.entity.Adoption;
import iyteyazilim.projects.haydos.service.impl.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoption")
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService ;

    @PostMapping("/add")
    public ResponseEntity<Adoption> addAdoption(@RequestParam Adoption adoption){
       return ResponseEntity.ok(adoptionService.createAdoption(adoption));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Adoption>> getAllAdoptions() {
        return ResponseEntity.ok(adoptionService.getAllAdoptions());
    }


    @PutMapping("/approve/{id}")
    public ResponseEntity<Adoption> updateAdoption(@PathVariable("id") Long adoptionId , @RequestBody Adoption adoption){
         return ResponseEntity.ok( adoptionService.updateAdoption(adoptionId,adoption));
    }




    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAdoption(@PathVariable("id") Long adoptionId){
        adoptionService.deleteAdoption(adoptionId);
        return ResponseEntity.ok("Adoption paw deleted successfully");
    }

}


