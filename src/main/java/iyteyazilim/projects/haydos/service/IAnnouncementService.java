package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.entity.Announcement;
import iyteyazilim.projects.haydos.entity.User;

import java.util.List;

public interface IAnnouncementService {

    Announcement createAnnouncement(Announcement announcement);

    Announcement getAnnouncementById(Long Id);

    List<Announcement> getAllAnnouncements();

    Announcement updateAnnouncement(Long announcementId, Announcement oldAnnouncement);

    void deleteAnnouncement(Long ID);

    User findUserWhoAnnounce(Announcement announcement);

}
