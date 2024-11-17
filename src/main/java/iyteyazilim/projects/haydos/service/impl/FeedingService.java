package iyteyazilim.projects.haydos.service.impl;


import iyteyazilim.projects.haydos.dto.FeedingDto;
import iyteyazilim.projects.haydos.entity.Adoption;
import iyteyazilim.projects.haydos.entity.Feeding;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.repository.IFeedingRepository;
import iyteyazilim.projects.haydos.repository.ILocationRepository;
import iyteyazilim.projects.haydos.repository.IUserRepository;
import iyteyazilim.projects.haydos.service.IFeedingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedingService implements IFeedingService {

    private IUserRepository userRepository ;
    private ILocationRepository locationRepository;
    private IFeedingRepository feedingRepository;

    @Override
    public Feeding createFeeding(FeedingDto feedingDto) {
        if (feedingDto != null) {
            Feeding feeding =  Feeding.builder()
                    .locationWhichFeed(locationRepository.findById(feedingDto.getLocation_id()).orElse(null))
                    .userWhoFeed(userRepository.findById(feedingDto.getUser_id()).orElse(null))
                    .image(feedingDto.getImage())
                    .approved(feedingDto.isApproved())
                    .feedingTime(feedingDto.getFeedingTime())
                    .build();
            return feedingRepository.save(feeding);

        }
        else
            throw new ResourceNotFoundException("Your feeding object is empty");
    }
    @Override
    public Feeding getFeedingById(Long Id) {
        return feedingRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Your feeding is not found in the app"));
    }

    @Override
    public List<Feeding> getAllFeedings() {
        return feedingRepository.findAll();
    }

    @Override
    public Feeding updateFeeding(Long feedingID, FeedingDto feeding) {
        return null;
    }

    @Override
    public void deleteFeeding(Long ID) {
        feedingRepository.deleteById(ID);
    }

    @Override
    public void approvedFeeding(Feeding feeding) {
        if(feeding != null ){
            feeding.setApproved(true);
            feedingRepository.save(feeding);
        }
        else throw new ResourceNotFoundException("Feeding object is empty . ");
    }


}
