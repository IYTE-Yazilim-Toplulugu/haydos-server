package iyteyazilim.projects.haydos.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MissingDto {

    private Long id;

    private String yourName ;

    private String yourPhoto;

    private Long phoneNumber;

    private String description ;

    private boolean isApproved ;

    private Long user_id ;
}
