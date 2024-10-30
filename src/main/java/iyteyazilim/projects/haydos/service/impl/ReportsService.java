package iyteyazilim.projects.haydos.service.impl;

import iyteyazilim.projects.haydos.dto.ReportsDto;
import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.repository.IPawsRepository;
import iyteyazilim.projects.haydos.repository.IReportsRepository;
import iyteyazilim.projects.haydos.repository.IUserRepository;
import iyteyazilim.projects.haydos.service.IReportsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ReportsService implements IReportsService {

    @Autowired
    private IReportsRepository reportsRepository;

    private IPawsRepository pawsRepository;

    private IUserRepository userRepository ;


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

    public Reports addReports(ReportsDto reportsDto) {
        if (reportsDto != null) {
            Reports reports = Reports.builder()
                    .report(reportsDto.getReport())
                    .date(reportsDto.getDate())
                    .aboutPaw(pawsRepository.findById(reportsDto.getPaw_id()).orElse(null))
                    .userWhoReport(userRepository.findById(reportsDto.getUser_id()).orElse(null))
                    .build();
            return reportsRepository.save(reports);
        }
        else
            throw new ResourceNotFoundException("Your reports is empty ");
    }

}