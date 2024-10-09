package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Feeding;
import iyteyazilim.projects.haydos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IFeedingRepository extends JpaRepository<Feeding , Long > {
}
