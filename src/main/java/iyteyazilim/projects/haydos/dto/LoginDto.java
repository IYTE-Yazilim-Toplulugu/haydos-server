package iyteyazilim.projects.haydos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class LoginDto {

    private Long id ;

    private String email;

    private String password ;

}
