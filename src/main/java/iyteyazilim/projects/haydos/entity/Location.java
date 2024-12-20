package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
@Entity
@Data
@Table(name = "location",schema = "haydosAppDB")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long latitude;

    private Long longitude;

    private String name;

    private String description ;

    @OneToMany(mappedBy = "locationWhichFeed", cascade = CascadeType.ALL )
    private List<Feeding> feedings;


    @OneToMany(mappedBy = "pawAtLocation" , cascade =  CascadeType.ALL)
    private List<Paws> pawsInHere ;
}

