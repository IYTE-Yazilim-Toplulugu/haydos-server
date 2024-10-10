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
       return  adoptionRepository.save(adoption);

    }
    public Adoption createAdoptionWithUser(Adoption adoption ,User user){


        if(adoption.getUserWhoAdopt() == null){
            adoption.setUserWhoAdopt(user);

        }
        return adoptionRepository.save(adoption);

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
        return adoptionRepository.findAll();
    }

    @Override
    public Adoption updateAdoption(Long adoptionId, Adoption newAdoption) {
        Adoption oldAdoption = getAdoptionById(adoptionId);
        newAdoption.setName(oldAdoption.getName());
        newAdoption.setYourPhoto(oldAdoption.getYourPhoto());
        newAdoption.setPhoneNumber(oldAdoption.getPhoneNumber());
        newAdoption.setDescription(oldAdoption.getDescription());
        newAdoption.setApproved(oldAdoption.isApproved());
        newAdoption.setUserWhoAdopt(oldAdoption.getUserWhoAdopt());
        return adoptionRepository.save(oldAdoption);
    }


    public void deleteAdoption(String name) {
        adoptionRepository.delete(adoptionRepository.findByName(name).orElseThrow(
                ()-> new ResourceNotFoundException("Adoption you want to delete is not found.")
        ));

    }
    @Override
    public void deleteAdoption(Long Id){
        adoptionRepository.deleteById(Id);
    }

    @Override
    public void approvedAdoption(Adoption adoption) {
        adoption.setApproved(true);
        adoptionRepository.save(adoption);

    }
}