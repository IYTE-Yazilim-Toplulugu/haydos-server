package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Feeding {

    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(cascade = )
    private Location location ;


    private User user ;

    private String image ;
}
