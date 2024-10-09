package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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

    private boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "user_id") // User tablosundaki 'id' kolonuna referans veriyor
    private User userWhoMiss ;
}
