package iyteyazilim.projects.haydos.controller;


import iyteyazilim.projects.haydos.dto.LoginDto;
import iyteyazilim.projects.haydos.dto.UserDto;
import iyteyazilim.projects.haydos.entity.Paws;
import iyteyazilim.projects.haydos.entity.Reports;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http//:localhost/api/v1/login
@RequestMapping("api/v1")
@RestController
@AllArgsConstructor
public class UserController {


    private final UserService userService ;




    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto loginUser) {
        try {
            User user = userService.login(loginUser);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 response
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.signUp(userDto));
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserById(Long userId ){
        userService.deleteUserById(userId);
        return ResponseEntity.ok("That User deleted successfully");

    }
    @PutMapping("/updateEmailAndPassword/{email}")
    public ResponseEntity<User> updateUserEmailAndPassword(@PathVariable("email") String email , @RequestBody String newEmail , @RequestBody String newPassword){
        return ResponseEntity.ok( userService.updateUserEmailAndPasswordByEmail(email,newEmail,newPassword));
    }

}
