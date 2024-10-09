package iyteyazilim.projects.haydos.service.impl;

import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
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


    @Override
    public Paws createPaws(Paws paws) {
        paws.setReportsAbout(null);
        paws.setApproved(false);
        paws.setPawAtLocation(null);
        return pawsRepository.save(paws);
    }

    @Override
    public Paws getPawsById(Long Id) {
        return pawsRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("This paws is not found"));
    }

    @Override
    public List<Paws> getAllPaws() {
        return  pawsRepository.findAll();
    }

    @Override
    public Paws updatePaw(Long pawsID, Paws paws) {
        Paws oldPaws = getPawsById(pawsID);
        oldPaws.setPawName(paws.getPawName());
        oldPaws.setImage(paws.getImage());
        oldPaws.setPawGender(paws.getPawGender());
        oldPaws.setAge(paws.getAge());
        oldPaws.setPawGender(paws.getPawGender());
        oldPaws.setHealthCondition(paws.getHealthCondition());
        oldPaws.setReportsAbout(paws.getReportsAbout());
        oldPaws.setApproved(paws.isApproved());
        oldPaws.setPawAtLocation(paws.getPawAtLocation());
        return pawsRepository.save(oldPaws);
    }

    @Override
    public void deletePaws(Long ID) {
        pawsRepository.delete(getPawsById(ID));

    }
    @Override
    public void approvePaws(Paws paws) {
        paws.setApproved(true);
    }

    @Override
    public Collection<Reports> reportsAboutPaws(Paws paws) {
        return paws.getReportsAbout();

    }
}
