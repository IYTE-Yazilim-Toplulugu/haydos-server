package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.entity.Missing;
import iyteyazilim.projects.haydos.entity.Paws;

import java.util.List;

public interface IPawsService {
    Paws createPaws(Paws paws);

    Paws getPawsById(Long Id);

    List<Paws> getAllPaws();

    Paws updatePaw(Long pawsID, Paws paws);

    void deletePaws(Long ID);

    void approvePaws();
}
