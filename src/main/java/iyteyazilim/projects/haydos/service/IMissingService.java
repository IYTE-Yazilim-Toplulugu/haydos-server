package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.entity.Missing;

import java.util.List;

public interface IMissingService {

    Missing createMissing(Missing missing);

    Missing getMissingById(Long Id);

    List<Missing> getAllMissing();

    Missing updateMissing(Long missingID,Missing missing);

   void deleteMissingByName(String name);

    void approvedMissing(Missing missing);

    List<Missing> getAllUnApprovedMissing();

    List<Missing> getAllApprovedMissing();
}
