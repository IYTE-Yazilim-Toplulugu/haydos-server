package iyteyazilim.projects.haydos.controller;


import iyteyazilim.projects.haydos.dto.MissingDto;
import iyteyazilim.projects.haydos.entity.Missing;
import iyteyazilim.projects.haydos.service.impl.MissingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


//http://localhost:8088/api/v1/missing
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/missing")
public class MissingController {

    private MissingService missingService ;



    @PostMapping("/add")
    public ResponseEntity<Missing> createMissing(@RequestBody MissingDto missing){
        return ResponseEntity.ok(missingService.createMissing(missing));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Missing>> getAllMissing(){
        return ResponseEntity.ok(missingService.getAllMissing());
    }


    @GetMapping("/getAllApproved")
    public ResponseEntity<List<Missing>> getAllApproved(){
        return ResponseEntity.ok(missingService.getAllApprovedMissing());
    }

    @GetMapping("/getAllUnApproved")
    public ResponseEntity<List<Missing>> getAllUnapprovedMissing(){
        return ResponseEntity.ok(missingService.getAllUnApprovedMissing());
    }



    @DeleteMapping("/delete/{name}")
    public ResponseEntity<HashMap<String,String>> deleteMissingByName(@PathVariable("name" ) String name){
        missingService.deleteMissingByName(name);

        HashMap<String, String> response = new HashMap<>();
        response.put("Message", "Your missing with this name '" + name + "' deleted successfully.");

        return ResponseEntity.ok(response);

    }
}
