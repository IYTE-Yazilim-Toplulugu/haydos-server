package iyteyazilim.projects.haydos.security;

import iyteyazilim.projects.haydos.dto.LoginDto;
import iyteyazilim.projects.haydos.entity.User;
import iyteyazilim.projects.haydos.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public User authenticate(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException(" Öğrenci numarası kayıtlı değildir"));
    }
}