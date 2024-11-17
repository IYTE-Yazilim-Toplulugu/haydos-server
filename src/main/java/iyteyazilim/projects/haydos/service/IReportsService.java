package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.ReportsDto;
import iyteyazilim.projects.haydos.entity.Missing;
import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.entity.User;

import java.util.List;

public interface IReportsService {

    Reports addReports(ReportsDto reportsDto);

    Reports getReportsById(Long Id);

    List<Reports> getAllReports();


    void deleteReportById(Long ID);


}
