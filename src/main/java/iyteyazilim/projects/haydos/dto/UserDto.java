package iyteyazilim.projects.haydos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private String name ;

    private String email ;

    private String password ;

    private String phoneNumber ;
}
