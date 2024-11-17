package iyteyazilim.projects.haydos.service.impl;

import iyteyazilim.projects.haydos.dto.AdoptionDto;
import iyteyazilim.projects.haydos.entity.Adoption;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.exeception.UserNotFoundException;
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
    private  IAdoptionRepository adoptionRepository;
    @Autowired
    private  IUserRepository userRepository;

    @Override
    public Adoption createAdoption(AdoptionDto adoptionDto) {
        if(adoptionDto != null) {
            var adoption = Adoption.builder()
                    .id(adoptionDto.getId())
                    .name(adoptionDto.getName())
                    .phoneNumber(adoptionDto.getPhoneNumber())
                    .isApproved(adoptionDto.isApproved())
                    .description(adoptionDto.getDescription())
                    //or else Sayesinde eğer adoption yapan user bulamazsa post hatası almak yerine user null olarak kalacak ;
                    // TODO: 19.10.2024 Bu kısım ileriki sürümlerde post un 200 okey dönmesi yerine 403 ya da 500 dönmesini
                    // TODO: 19.10.2024 sağlayabilirz ama bu kısımlarda kullanıcı verisini illaki alırız diye düşünüyorum id olarak ya da userDto olarak
                    .userWhoAdopt(userRepository.findById(adoptionDto.getUser_id()).orElse(null))
                    .build();
            return adoptionRepository.save(adoption);
        }
        else
            throw new ResourceNotFoundException("Your adoption object is empty");
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
        if (newAdoption != null) {
            Adoption oldAdoption = getAdoptionById(adoptionId);
            newAdoption.setName(oldAdoption.getName());
            newAdoption.setYourPhoto(oldAdoption.getYourPhoto());
            newAdoption.setPhoneNumber(oldAdoption.getPhoneNumber());
            newAdoption.setDescription(oldAdoption.getDescription());
            newAdoption.setApproved(oldAdoption.isApproved());
            newAdoption.setUserWhoAdopt(oldAdoption.getUserWhoAdopt());
            return adoptionRepository.save(oldAdoption);
        }else
            throw new ResourceNotFoundException("Your new adoption object is empty so it was not changed .");
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
        if(adoption != null){
            adoption.setApproved(true);
            adoptionRepository.save(adoption);

        }
        else
            throw new ResourceNotFoundException("Your adoption object is empty");
    }
}