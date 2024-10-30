package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.AnnouncementDto;
import iyteyazilim.projects.haydos.entity.Announcement;
import iyteyazilim.projects.haydos.entity.User;

import java.util.List;

public interface IAnnouncementService {

    Announcement createAnnouncement(AnnouncementDto announcement);

    Announcement getAnnouncementById(Long Id);

    List<Announcement> getAllAnnouncements();

    Announcement updateAnnouncement(Long announcementId, AnnouncementDto oldAnnouncement);

    void deleteAnnouncement(Long ID);
}
