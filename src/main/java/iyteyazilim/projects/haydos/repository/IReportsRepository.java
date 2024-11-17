package iyteyazilim.projects.haydos.repository;

import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportsRepository extends JpaRepository<Reports , Long> {


}
