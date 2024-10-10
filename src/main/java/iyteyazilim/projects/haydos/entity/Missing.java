package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Missing {


    @GeneratedValue
    @Id
    private Long id ;

    private String yourName;

    private String yourPhoto ;

    private Long phoneNumber ;

    private String description ;

    @Column(name = "approved_status")
    private boolean approved;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false) // User tablosundaki 'id' kolonuna referans veriyor
    private User userWhoMiss ;
}
