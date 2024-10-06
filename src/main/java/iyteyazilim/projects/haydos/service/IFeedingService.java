package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.Feeding;

import java.util.List;

public interface IFeedingService {
    Feeding createFeeding(Feeding feeding);

    Feeding getFeedingById(Long Id);

    List<Feeding> getAllFeedings();

    Feeding updateFeeding(Long feedingID, Feeding feeding);

    void deleteFeeding(Long ID);

    void approvedFeeding();



}
