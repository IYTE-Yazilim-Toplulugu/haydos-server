package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.PawDto;
import iyteyazilim.projects.haydos.entity.Missing;
import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;

import java.util.Collection;
import java.util.List;

public interface IPawsService {
    Paws createPaws(PawDto paws);

    Paws getPawsById(Long Id);

    List<Paws> getAllPaws();

    Paws updatePaw(Long pawsID, PawDto paws);

    void deletePaws(Long ID);

    void approvePaws(Paws paws) ;
}
