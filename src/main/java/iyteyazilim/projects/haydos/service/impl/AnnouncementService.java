package iyteyazilim.projects.haydos.service.impl;


import iyteyazilim.projects.haydos.dto.AnnouncementDto;
import iyteyazilim.projects.haydos.entity.Announcement;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.repository.IAnnouncementRepository;
import iyteyazilim.projects.haydos.repository.IUserRepository;
import iyteyazilim.projects.haydos.service.IAnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AnnouncementService implements IAnnouncementService {

    @Autowired
    private IAnnouncementRepository announcementRepository;

    private IUserRepository userRepository ;



    @Override
    public Announcement createAnnouncement(AnnouncementDto announcementDto) {
        if (announcementDto != null) {
            var announcement = Announcement.builder()
                    .id(announcementDto.getId())
                    .header(announcementDto.getHeader())
                    .photo(announcementDto.getImage())

                    //TODO buraya doğru düzgün veri akışı sağlamam gerek
                    .date(new Date(announcementDto.getDate()))
                    .userWhoAnnounce(userRepository.findById(announcementDto.getUser_id()).orElse(null))
                    .build();


            return announcementRepository.save(announcement);
        }
        else throw new ResourceNotFoundException("Your announcement Dto is empty");
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
    public Announcement updateAnnouncement(Long announcementId, AnnouncementDto newAnnouncement) {
        if (newAnnouncement != null){
            Announcement oldAnnouncement = getAnnouncementById(announcementId);
            oldAnnouncement.setHeader(newAnnouncement.getHeader());
            //TODO aynı şekilde buraya da
            oldAnnouncement.setDate(new Date (newAnnouncement.getDate()));
            oldAnnouncement.setDescription(newAnnouncement.getDescription());
            oldAnnouncement.setUserWhoAnnounce(userRepository.findById(newAnnouncement.getUser_id()).orElse(null));
            return announcementRepository.save(oldAnnouncement);

        }
        else
            throw new ResourceNotFoundException("Your new announcement is ");

    }

    @Override
    public void deleteAnnouncement(Long ID) {
        announcementRepository.delete(getAnnouncementById(ID));

    }


}
