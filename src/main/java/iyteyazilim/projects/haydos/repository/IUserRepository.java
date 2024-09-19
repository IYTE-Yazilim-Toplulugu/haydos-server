package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
