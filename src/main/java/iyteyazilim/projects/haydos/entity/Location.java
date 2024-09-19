package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private Long xCoordinate ;

    private Long yCoordinate ;

    private String name ;

}
