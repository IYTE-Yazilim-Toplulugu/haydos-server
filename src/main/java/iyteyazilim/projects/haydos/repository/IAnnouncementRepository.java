package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnnouncementRepository extends JpaRepository<Announcement , Long> {
}
