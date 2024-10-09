package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> findByUserRole(UserRole userRole);
    Optional<User> findByEmail(String email);
}
