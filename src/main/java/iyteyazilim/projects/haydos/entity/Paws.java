package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@Data
@Table(name = "paw",schema = "haydosAppDB")
@NoArgsConstructor
@AllArgsConstructor
public class Paws {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paw_id")
    private Long id;

    @Column(name = "paw_name")
    private String pawName;

    @Column(name =  "paw_image")
    private String image;

    @Column(name = "paw_gender")
    private String pawGender;

    @Column(name = "paw_age")
    private Long age ;

    @Column(name = "paw_funFact")
    private String funFact;

    @Column(name =  "paw_type")
    @Enumerated(EnumType.STRING)
    private PetType petType ;


    @Column(name = "paw_health")
    @Enumerated(EnumType.STRING)
    private HealthCondition healthCondition;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aboutPaw")
    @Column(nullable = true)
    private Collection<Reports> reportsAbout;

    @Column(name = "paw_approval")
    private boolean isApproved;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    private Location pawAtLocation  ;
}