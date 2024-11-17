package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface IAdoptionRepository extends JpaRepository<Adoption, Long > {
    @Query("SELECT a FROM Adoption a WHERE a.name = :name")
    Optional<Adoption> findByName(@Param("name") String name);


}
