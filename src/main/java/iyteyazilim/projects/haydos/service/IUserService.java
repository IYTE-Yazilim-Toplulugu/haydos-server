package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.Feeding;

import java.util.List;

public interface IUserService {
    Feeding createUser(Feeding userDto);

    Feeding getUserById(Long Id);

    List<Feeding> getAllUsers();

    Feeding updateUser(Long userID, Feeding userDto);

    void deleteUser(Long ID);

}
