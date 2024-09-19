package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @GeneratedValue
    @Id
    private Long id ;

    private String name ;

    private String email ;

    private String  password ;

    private Reports report ;

    private Long points;

    private String photo ;

}
