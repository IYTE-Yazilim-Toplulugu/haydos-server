package iyteyazilim.projects.haydos.service;


import iyteyazilim.projects.haydos.dto.FeedingDto;
import iyteyazilim.projects.haydos.entity.Adoption;
import iyteyazilim.projects.haydos.entity.Feeding;

import java.util.List;

public interface IFeedingService {
    Feeding createFeeding(FeedingDto feeding);

    Feeding getFeedingById(Long Id);

    List<Feeding> getAllFeedings();

    Feeding updateFeeding(Long feedingID, FeedingDto feeding);

    void deleteFeeding(Long ID);

    void approvedFeeding(Feeding feeding);



}
