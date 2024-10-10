package iyteyazilim.projects.haydos.service.impl;


import iyteyazilim.projects.haydos.entity.Feeding;
import iyteyazilim.projects.haydos.service.IFeedingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedingService implements IFeedingService {

    @Override
    public Feeding createFeeding(Feeding feeding) {
        return null;
    }

    @Override
    public Feeding getFeedingById(Long Id) {
        return null;
    }

    @Override
    public List<Feeding> getAllFeedings() {
        return null;
    }

    @Override
    public Feeding updateFeeding(Long feedingID, Feeding feeding) {
        return null;
    }

    @Override
    public void deleteFeeding(Long ID) {

    }

    @Override
    public void approvedFeeding() {

    }
}
