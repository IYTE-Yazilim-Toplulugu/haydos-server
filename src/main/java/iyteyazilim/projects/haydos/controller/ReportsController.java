package iyteyazilim.projects.haydos.controller;



import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.service.impl.ReportsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class ReportsController {

    private ReportsService reportsService ;

    @PostMapping("/report/addReports")
    public ResponseEntity<Reports> addReports(@RequestBody Reports reports ,@RequestBody  User user , @RequestBody Paws paws ){
        return ResponseEntity.ok(reportsService.addReports(reports,user,paws));
    }

    @DeleteMapping("/report/deleteReport/{id}")
    public ResponseEntity<String> deleteReportsById(@PathVariable("id") Long id){
        reportsService.deleteReportById(id);
        return ResponseEntity.ok("Reports deleted successfully by user") ;
    }

}
