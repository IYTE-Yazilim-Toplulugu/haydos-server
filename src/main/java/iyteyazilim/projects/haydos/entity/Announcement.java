package iyteyazilim.projects.haydos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {


    @GeneratedValue
    @Id
    private Long id ;

    private String header ;

    private String description ;

    private String photo;

    private Date date ;
}
