package iyteyazilim.projects.haydos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LocationDto {

    private Long id;

    private Long latitude ;

    private Long longitude;

    private String name ;

    private String description ;

}
