package iyteyazilim.projects.haydos.service;

import iyteyazilim.projects.haydos.dto.Feeding;
import iyteyazilim.projects.haydos.dto.LoginDto;
import iyteyazilim.projects.haydos.dto.UserDto;
import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.entity.User;

import java.util.List;

public interface IUserService {
    User login(LoginDto loginDto);

    User updateInfo(User user);

    User updateLoginInfo(LoginDto loginDto);

    User signUp(UserDto userDto);

    List<User> getAllUsers();

    void deleteUserById(Long Id);

    void deleteUserByEmail(String email);

    User updateUserEmailAndPasswordByEmail(String email , String newEmail , String newPassword);

}
