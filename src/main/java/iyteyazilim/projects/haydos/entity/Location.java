package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@Table(name = "location")
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long xCoordinate;

    private Long yCoordinate;

    private String name;

    @OneToMany(mappedBy = "locationWhichFeed", cascade = CascadeType.ALL)
    private List<Feeding> feedings;
}

