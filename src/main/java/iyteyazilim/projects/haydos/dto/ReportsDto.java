package iyteyazilim.projects.haydos.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportsDto {

    private Long id ;

    private String report ;

    private Long paw_id ;

    private String date ;

    private Long user_id ;


}
