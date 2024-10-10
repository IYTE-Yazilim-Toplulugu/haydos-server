package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.entity.Adoption;
import iyteyazilim.projects.haydos.entity.User;

import java.util.List;

public interface IAdoptionService {

    Adoption createAdoption(Adoption adoption);

    Adoption getAdoptionById(Long Id);

    Adoption getAdoptionByName(String name);

    List<Adoption> getAllAdoptions();

    Adoption updateAdoption(Long userID, Adoption adoption);

    void deleteAdoption(Long ID);

    void approvedAdoption(Adoption adoption);

    Adoption createAdoptionWithUser(Adoption adoption , User user);

}
