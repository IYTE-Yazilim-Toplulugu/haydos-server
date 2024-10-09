package iyteyazilim.projects.haydos.service.impl;

import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.repository.IReportsRepository;
import iyteyazilim.projects.haydos.service.IReportsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ReportsService implements IReportsService {

    @Autowired
    private IReportsRepository reportsRepository ;


    @Override
    public Reports getReportsById(Long Id) {
         return reportsRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Report is not found"));
    }

    @Override
    public List<Reports> getAllReports() {
        return reportsRepository.findAll();
    }


    @Override
    public void deleteReportById(Long ID) {
        reportsRepository.deleteById(ID);
    }

    public Reports addReports(Reports reports , User user , Paws paws ) {
        reports.setAboutPaw(paws);
        reports.setUserWhoReport(user);
        return reportsRepository.save(reports);
    }
}
