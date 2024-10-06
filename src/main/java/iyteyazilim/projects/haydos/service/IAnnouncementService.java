package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.entity.Announcement;

import java.util.List;

public interface IAnnouncementService {

    Announcement createAnnouncement(Announcement announcement);

    Announcement getAnnouncementById(Long Id);

    List<Announcement> getAllAnnouncements();

    Announcement updateAnnouncement(Long announcementId, Announcement userDto);

    void deleteAnnouncement(Long ID);

}
