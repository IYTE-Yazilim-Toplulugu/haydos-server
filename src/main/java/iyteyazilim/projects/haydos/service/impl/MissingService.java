package iyteyazilim.projects.haydos.service.impl;


import iyteyazilim.projects.haydos.dto.MissingDto;
import iyteyazilim.projects.haydos.entity.Missing;
import iyteyazilim.projects.haydos.exeception.NotFoundResourceUnApproved;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.exeception.UserNotFoundException;
import iyteyazilim.projects.haydos.repository.IMissingRepository;
import iyteyazilim.projects.haydos.repository.IUserRepository;
import iyteyazilim.projects.haydos.service.IMissingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MissingService implements IMissingService {


    @Autowired
    private IMissingRepository missingRepository ;
    private IUserRepository userRepository ;
    @Override
    public Missing createMissing(MissingDto missingDto) {
        if(missingDto != null){
            Missing missing = new Missing();
            missing.setYourName(missingDto.getYourName());
            missing.setYourPhoto(missingDto.getYourPhoto());
            missing.setPhoneNumber(missingDto.getPhoneNumber());
            missing.setDescription(missingDto.getDescription());
            missing.setApproved(missingDto.isApproved());
            missing.setUserWhoMiss(userRepository.findById(missingDto.getUser_id()).orElseThrow(() -> new UserNotFoundException("User not found with this id")));
            return missingRepository.save(missing);
        }
        else
            throw new ResourceNotFoundException("Your missing object is null");
    }

    @Override
    public Missing getMissingById(Long Id) {
        return missingRepository.findById(Id).orElseThrow(()->
                new ResourceNotFoundException("Missing that you wanted is not found."));
    }

    @Override
    public List<Missing> getAllMissing() {
        return missingRepository.findAll();
    }

    @Override
    public Missing updateMissing(Long missingID, MissingDto newMissing) {
        if (newMissing != null) {
            Missing missing = getMissingById(missingID);

            missing.setYourName(newMissing.getYourName());
            missing.setPhoneNumber(newMissing.getPhoneNumber());
            missing.setDescription(newMissing.getDescription());
            missing.setYourPhoto(newMissing.getYourPhoto());
            missing.setApproved(newMissing.isApproved());
            missing.setUserWhoMiss(userRepository.findById(newMissing.getUser_id()).orElseThrow(()-> new UserNotFoundException("Your user with "+ newMissing.getUser_id()+" is not found.")));
            return missingRepository.save(missing);
        }
        else throw new ResourceNotFoundException("Your missing object is empty. ");
    }

    @Override
    public void deleteMissingByName(String name) {

        missingRepository.delete(missingRepository.findByYourName(name).orElseThrow(() -> new ResourceNotFoundException("You want to delete missing with this name" +
                name +" is not found.")));
    }

    @Override
    public void approvedMissing(Missing missing) {
        if(missing != null){
            missing.setApproved(true);
            missingRepository.save(missing);
        }
        else throw new ResourceNotFoundException("Your missing object is empty.");
    }
    public List<Missing> getAllUnApprovedMissing(){
        return missingRepository.findByApproved(false).orElseThrow(()->
                new NotFoundResourceUnApproved("There is no unapproved missing"));
    }

    @Override
    public List<Missing> getAllApprovedMissing() {
        return missingRepository.findByApproved(true).orElseThrow(()->
                new NotFoundResourceUnApproved("There is no approved missing "));
    }
}
