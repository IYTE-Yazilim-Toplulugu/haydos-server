package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAnnouncementRepository extends JpaRepository<Announcement , Long> {
    Optional<Announcement> findByHeader(String header);
}
