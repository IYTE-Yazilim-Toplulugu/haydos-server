package iyteyazilim.projects.haydos.service.impl;

import iyteyazilim.projects.haydos.dto.PawDto;
import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.repository.ILocationRepository;
import iyteyazilim.projects.haydos.repository.IPawsRepository;
import iyteyazilim.projects.haydos.service.IPawsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class PawsService implements IPawsService {

    @Autowired
    private IPawsRepository pawsRepository;

    private ILocationRepository locationRepository;


    @Override
    public Paws createPaws(PawDto pawDto) {
        if (pawDto != null) {
            Paws paws = Paws.builder()
                    .pawAtLocation(null)
                    .pawName(pawDto.getName())
                    .image(pawDto.getImage())
                    .pawGender(pawDto.getGender())
                    .age(pawDto.getAge())
                    .funFact(pawDto.getFunFact())
                    .petType(pawDto.getPetType())
                    .healthCondition(pawDto.getHealthCondition())
                    .reportsAbout(null)
                    .isApproved(false)
                    .pawAtLocation(locationRepository.findById(pawDto.getLocation_id()).orElse(null))
                    .build();
            return pawsRepository.save(paws);
        } else throw new ResourceNotFoundException("This paws is not found");
    }

    @Override
    public Paws getPawsById(Long Id) {
        return pawsRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("This paws is not found"));
    }

    @Override
    public List<Paws> getAllPaws() {
        return pawsRepository.findAll();
    }

    @Override
    public Paws updatePaw(Long pawsID, PawDto paws) {
        if (paws != null) {
            Paws oldPaws = getPawsById(pawsID);
            oldPaws.setPawName(paws.getName());
            oldPaws.setImage(paws.getImage());
            oldPaws.setPawGender(paws.getGender());
            oldPaws.setAge(paws.getAge());
            oldPaws.setHealthCondition(paws.getHealthCondition());
            oldPaws.setApproved(paws.isApproved());
            return pawsRepository.save(oldPaws);
        } else throw new ResourceNotFoundException("Your object is empty.");
    }

    @Override
    public void deletePaws(Long ID) {
        pawsRepository.delete(getPawsById(ID));

    }

    @Override
    public void approvePaws(Paws paws) {
        if (paws != null) {
            paws.setApproved(true);
            pawsRepository.save(paws);
        }
        else throw new ResourceNotFoundException("Your paws object is empty .");
    }
}