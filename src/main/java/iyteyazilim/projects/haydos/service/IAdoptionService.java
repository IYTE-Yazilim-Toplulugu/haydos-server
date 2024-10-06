package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.UserDto;

import java.util.List;

public interface IAdoptionService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long Id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userID, UserDto userDto);

    void deleteUser(Long ID);
}
