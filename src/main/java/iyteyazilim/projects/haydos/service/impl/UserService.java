package iyteyazilim.projects.haydos.service.impl;


import iyteyazilim.projects.haydos.dto.LoginDto;
import iyteyazilim.projects.haydos.dto.UserDto;
import iyteyazilim.projects.haydos.entity.*;
import iyteyazilim.projects.haydos.exeception.ResourceNotFoundException;
import iyteyazilim.projects.haydos.exeception.UserNotFoundException;
import iyteyazilim.projects.haydos.repository.IUserRepository;
import iyteyazilim.projects.haydos.service.IUserService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {



    private IUserRepository userRepository ;

    @Override

    public User login(LoginDto loginUser) {
        return userRepository.findByUsername(loginUser.getEmail())
                .filter(user -> user.getPassword().equals(loginUser.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }


    @Override
    public User updateLoginInfo(LoginDto loginDto) {
        return null;
    }


    @Override
    public void deleteUserById(Long Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User signUp(UserDto userDto) {

        User user = new User() ;

        user.setUsername(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setUserRole(UserRole.NORMAL);

        user.setAnnouncementByMe(null);
        user.setPoints(0);
        user.setImage("");
        user.setMissingPawsByMe(null);
        user.setAdoptionPawsByMe(null);
        user.setFeedPawsByMe(null);
        user.setReports(null);
        user.setFriends(null);
    return userRepository.save(user);

    }

    @Override
    public void deleteUserByEmail(String email) {
        User user = userRepository.findByUsername(email).orElseThrow(()-> new UserNotFoundException(email));
        userRepository.deleteById(user.getId());
    }



    @Override
    public User updateUserEmailAndPasswordByEmail(String email , String newEmail , String newPassword) {
        User user = userRepository.findByUsername(email).orElseThrow(()-> new UserNotFoundException("That user is not found "));
        user.setPassword(newPassword);
        user.setUsername(newEmail);
        return user;
    }

    @Override
    public User updateImage(String image) {
        return null;
    }
}
