package iyteyazilim.projects.haydos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    private Long xCoordinate;

    private Long yCoordinate;

    private String name;

    private String description ;

}
