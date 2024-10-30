package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Announcement;
import iyteyazilim.projects.haydos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAnnouncementRepository extends JpaRepository<Announcement , Long> {
    @Query("SELECT a FROM Announcement a WHERE a.header = :header")
    Optional<Announcement> findByHeader(@Param("header") String header);

}
