package iyteyazilim.projects.haydos.controller;


import iyteyazilim.projects.haydos.dto.AdoptionDto;
import iyteyazilim.projects.haydos.entity.Adoption;
import iyteyazilim.projects.haydos.service.impl.AdoptionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoption")
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService ;

    @PostMapping("/add")
    public ResponseEntity<Void> addAdoption(@RequestParam("yourName") String yourName ,
                                            @RequestParam("yourPhoto") String yourPhoto ,
                                            @RequestParam("phoneNumber") Long phoneNumber ,
                                            @RequestParam("description") String description
                                            ){

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Adoption>> getAllAdoptions() {
        return ResponseEntity.ok(adoptionService.getAllAdoptions());
    }



    @GetMapping("/get/{id}")
    public ResponseEntity<List<PdfDoc>> getPdfsByType(@RequestParam("type") PdfType type) {
        try {
            List<PdfDoc> pdfs = pdfDocService.getPdfsByType(type);
            return ResponseEntity.ok(pdfs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<AdoptionDto> updateAdoption(@PathVariable("id") Long adoptionId , @RequestBody AdoptionDto adoptionDto){
        AdoptionDto adoptionDto1 = adoptionService.updateAdoption(adoptionId,adoptionDto)
    }



    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAdoption(@PathVariable("id") Long adoptionId){
        adoptionService.deleteAdoption(adoptionId);
        return ResponseEntity.ok("Adoption paw deleted successfully");
    }

}
