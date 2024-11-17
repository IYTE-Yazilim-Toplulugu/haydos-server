package iyteyazilim.projects.haydos.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdoptionDto {
    private Long id ;

    private String name;

    private String image ;

    private Long phoneNumber ;

    private String description ;

    private boolean approved ;

    private Long user_id ;

}
