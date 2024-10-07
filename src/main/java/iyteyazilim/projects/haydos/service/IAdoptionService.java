package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.AdoptionDto;
import iyteyazilim.projects.haydos.dto.Feeding;
import iyteyazilim.projects.haydos.entity.Adoption;

import java.util.List;

public interface IAdoptionService {

    Adoption createAdoption(AdoptionDto adoption);

    Adoption getAdoptionById(Long Id);

    List<Adoption> getAllAdoptions();

    Adoption updateAdoption(Long userID, AdoptionDto adoption);

    void deleteAdoption(Long ID);

    Adoption approvedAdoption(AdoptionDto adoption);
}
