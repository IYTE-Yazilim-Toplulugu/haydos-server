package iyteyazilim.projects.haydos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class AdoptionDto {

    private String yourName;

    private String yourPhoto;

    private Long phoneNumber;

    private String description;

    private boolean approved;

    private Long user_id ;
}
