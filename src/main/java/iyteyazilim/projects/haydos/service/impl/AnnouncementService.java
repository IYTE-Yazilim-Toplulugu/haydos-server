package iyteyazilim.projects.haydos.service.impl;


import iyteyazilim.projects.haydos.entity.Announcement;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.repository.IAnnouncementRepository;
import iyteyazilim.projects.haydos.service.IAnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnnouncementService implements IAnnouncementService {

    @Autowired
    private IAnnouncementRepository announcementRepository;



    @Override
    public Announcement createAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }
    public Announcement createAnnouncementWithUser(Announcement announcement , User user){
        announcement.setUserWhoAnnounce(user);
        return announcementRepository.save(announcement);
    }

    @Override
    public Announcement getAnnouncementById(Long Id) {
        return announcementRepository.findById(Id).orElseThrow(()->
                new ResourceNotFoundException("This announcement with this id " + Id +" is not found."));
    }
    public Announcement getAnnouncementByHeader(String header){
        return announcementRepository.findByHeader(header).orElseThrow(()->
                new ResourceNotFoundException("This announcement with this header " + header + " is not found."));
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement updateAnnouncement(Long announcementId, Announcement oldAnnouncement) {
        Announcement newAnnouncement = getAnnouncementById(announcementId);

    }

    @Override
    public void deleteAnnouncement(Long ID) {
        announcementRepository.delete(getAnnouncementById(ID));

    }

    @Override
    public User findUserWhoAnnounce(Announcement announcement) {
        return null;
    }
}
