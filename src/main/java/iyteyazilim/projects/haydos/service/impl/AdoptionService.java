package iyteyazilim.projects.haydos.service.impl;

import iyteyazilim.projects.haydos.dto.AdoptionDto;
import iyteyazilim.projects.haydos.entity.Adoption;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.repository.IAdoptionRepository;
import iyteyazilim.projects.haydos.repository.IUserRepository;
import iyteyazilim.projects.haydos.service.IAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionService implements IAdoptionService {

    @Autowired
    IAdoptionRepository adoptionRepository ;
    @Autowired
    IUserRepository userRepository;

    @Override
    public Adoption createAdoption(AdoptionDto adoptionDto) {

            Adoption adoption = new Adoption();
            adoption.setApproved(adoptionDto.isApproved());
            adoption.setDescription(adoptionDto.getDescription());
            adoption.setYourName(adoptionDto.getYourName());
            adoption.setYourPhoto(adoptionDto.getYourPhoto());
            adoption.setPhoneNumber(adoption.getPhoneNumber());

            User user = userRepository.findById(adoptionDto.getUser_id()).
                    orElseThrow(() -> new RuntimeException(" User who want to adopt not found "));
            adoption.setUserWhoAdopt(user);
            return adoptionRepository.save(adoption);

    }

    @Override
    public Adoption getAdoptionById(Long Id) {
        return adoptionRepository.findById(Id).orElseThrow(()-> new RuntimeException("Adoption is not found "));
    }

    @Override
    public List<Adoption> getAllAdoptions() {
        return adoptionRepository.findAll();
    }

    @Override
    public Adoption updateAdoption(Long adoptionID, AdoptionDto adoptionDto) {
        Adoption adoption = getAdoptionById(adoptionID) ;
        adoption.
    }
    @Override
    public void deleteAdoption(Long ID) {
        adoptionRepository.delete(getAdoptionById(ID));
    }
    @Override
    public Adoption approvedAdoption(AdoptionDto adoptionDto) {
        Adoption adoption = createAdoption(adoptionDto);

        adoption.setApproved(true);

        return adoption ;

    }
}
