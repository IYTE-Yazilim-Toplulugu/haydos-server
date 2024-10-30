package iyteyazilim.projects.haydos.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PawDto {

    private Long id ;

    private String name ;

    private String image ;

    private  String gender;

    private Long age;

    private String funFact;

    private String petType;

    private String healthCondition;

    private boolean isApproved ;

    private Long location_id ;

    //collection about paw ilk başta null olcağı için sonradan ekleyeceğim

}
