package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.entity.Missing;
import iyteyazilim.projects.haydos.entity.Reports;

import java.util.List;

public interface IReportsService {

    Reports createReports(Reports reports);

    Reports getReportsById(Long Id);

    List<Reports> getAllReports();

    Reports updateReports(Long reportsID, Reports reports);

    void deleteReports(Long ID);

}
