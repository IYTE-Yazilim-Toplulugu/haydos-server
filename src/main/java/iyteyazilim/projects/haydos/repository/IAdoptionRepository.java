package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface IAdoptionRepository extends JpaRepository<Adoption, Long > {
    Optional<Adoption> findByName(String name);


}
