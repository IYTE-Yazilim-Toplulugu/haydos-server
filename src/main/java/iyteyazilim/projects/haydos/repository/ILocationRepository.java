package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepository extends JpaRepository<Location , Long> {
}
