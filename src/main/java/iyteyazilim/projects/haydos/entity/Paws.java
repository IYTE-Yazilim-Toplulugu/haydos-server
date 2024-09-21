package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "paws")
@NoArgsConstructor
@AllArgsConstructor
public class Paws {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gender;

    // Optional
    private boolean isMale;

    @Enumerated(EnumType.STRING)
    private HealthCondition healthCondition;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "aboutPaw")
    private Reports reportsAbout;

    private boolean isApproved;
}