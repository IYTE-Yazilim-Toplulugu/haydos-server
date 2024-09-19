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
public class Adoption {

    @GeneratedValue
    @Id
    private Long id ;

    private String yourName ;

    private String yourPhoto ;

    private Long phoneNumber ;

    private String description ;

    private boolean isApproved ;
}
