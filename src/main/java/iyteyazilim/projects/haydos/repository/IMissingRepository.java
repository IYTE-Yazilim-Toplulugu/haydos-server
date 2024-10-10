package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Missing;
import iyteyazilim.projects.haydos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMissingRepository extends JpaRepository<Missing , Long > {

    Optional<Missing> findByYourName(String yourName);

    Optional<Missing> findByPhoneNumber(Long phoneNumber);

    Optional<List<Missing>> findByApproved(boolean approved);

    Optional<Missing> findByYourPhoto(String photo);

    Optional<List<Missing>> findByUserWhoMiss(User user);

}
