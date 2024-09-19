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
public class Paws {


    @GeneratedValue
    @Id
    private Long id ;

    private String name ;

    private String gender ;

    //Optional
    private boolean isMale ;

    private HealthCondition healthCondition ;

    private Reports reports  ;

    private boolean isApproved ;


}
