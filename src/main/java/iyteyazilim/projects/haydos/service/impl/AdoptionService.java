package iyteyazilim.projects.haydos.service.impl;

import iyteyazilim.projects.haydos.entity.Adoption;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.repository.IAdoptionRepository;
import iyteyazilim.projects.haydos.repository.IUserRepository;
import iyteyazilim.projects.haydos.service.IAdoptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AdoptionService implements IAdoptionService {

    @Autowired
    IAdoptionRepository adoptionRepository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public Adoption createAdoption(Adoption adoption) {
        return null;

    }
    public Adoption createAdoptionWithUser(Adoption adoption ,User user){
        return null ;

    }

    @Override
    public Adoption getAdoptionById(Long Id) {
        return adoptionRepository.findById(Id).orElseThrow(()->
                new ResourceNotFoundException("Your adoption with this "+ Id + " is not found. " ));
    }

    @Override
    public Adoption getAdoptionByName(String name) {
        return  adoptionRepository.findByName(name).orElseThrow(()->
                new ResourceNotFoundException("Your adoption with this " + name + " is not found."));
    }

    @Override
    public List<Adoption> getAllAdoptions() {
        return null;
    }

    @Override
    public Adoption updateAdoption(Long userID, Adoption adoption) {
        return null;
    }

    @Override
    public void deleteAdoption(Long ID) {

    }

    @Override
    public Adoption approvedAdoption(Adoption adoption) {
        return null;
    }
}