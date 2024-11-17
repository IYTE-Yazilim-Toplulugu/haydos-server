package iyteyazilim.projects.haydos.controller;



import iyteyazilim.projects.haydos.dto.ReportsDto;
import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.service.impl.ReportsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class ReportsController {

    private ReportsService reportsService ;

    @PostMapping("/report/addReports")
    public ResponseEntity<Reports> addReports(@RequestBody ReportsDto reports ){
        return ResponseEntity.ok(reportsService.addReports(reports));
    }

    @DeleteMapping("/report/deleteReport/{id}")
    public ResponseEntity<String> deleteReportsById(@PathVariable("id") Long id){
        reportsService.deleteReportById(id);
        return ResponseEntity.ok("Reports deleted successfully by user") ;
    }

    // Belirli bir raporu ID'ye göre getirme
    @GetMapping("/{id}")
    public ResponseEntity<Reports> getReportsById(@PathVariable("id") Long id) {
        Reports report = reportsService.getReportsById(id);
        return ResponseEntity.ok(report);
    }

    // Tüm raporları getirme
    @GetMapping("/getAll")
    public ResponseEntity<List<Reports>> getAllReports() {
        List<Reports> allReports = reportsService.getAllReports();
        return ResponseEntity.ok(allReports);
    }
}
