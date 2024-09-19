package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdoptionRepository extends JpaRepository<Adoption , Long > {
}
