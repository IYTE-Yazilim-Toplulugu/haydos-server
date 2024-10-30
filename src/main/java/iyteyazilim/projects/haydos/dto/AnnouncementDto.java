package iyteyazilim.projects.haydos.dto;

import lombok.*;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class AnnouncementDto {
    private Long id ;

    private String header ;

    private String description ;

    private String image ;

    private String date  ;

    private Long user_id ;
}
