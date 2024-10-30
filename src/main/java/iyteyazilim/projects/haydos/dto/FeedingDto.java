package iyteyazilim.projects.haydos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedingDto {
    private Long id ;

    private Long location_id ;

    private Long user_id ;

    private String image ;

    private boolean approved ;

    private String feedingTime ;
}
