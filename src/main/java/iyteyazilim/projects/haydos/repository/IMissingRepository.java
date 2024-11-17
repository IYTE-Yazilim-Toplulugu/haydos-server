package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Missing;
import iyteyazilim.projects.haydos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IMissingRepository extends JpaRepository<Missing , Long > {
    @Query("SELECT m FROM Missing m WHERE m.yourName = :yourName")
    Optional<Missing> findByYourName(@Param("yourName") String yourName);



    @Query("SELECT m FROM Missing m WHERE m.approved = :approved")
    Optional<List<Missing>> findByApproved(@Param("approved") boolean approved);

    @Query("SELECT m FROM Missing m WHERE m.yourPhoto = :photo")
    Optional<Missing> findByYourPhoto(@Param("photo") String photo);

    @Query("SELECT m FROM Missing m WHERE m.userWhoMiss = :user")
    Optional<List<Missing>> findByUserWhoMiss(@Param("user") User user);

    @Query("SELECT m FROM Missing m WHERE m.phoneNumber = :phoneNumber")
    Optional<Missing> findByPhoneNumber(@Param("phoneNumber") Long phoneNumber);




}
