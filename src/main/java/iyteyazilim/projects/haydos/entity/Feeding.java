package iyteyazilim.projects.haydos.entity;

import iyteyazilim.projects.haydos.entity.Location;
import iyteyazilim.projects.haydos.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "feeding",schema = "haydosAppDB")
@NoArgsConstructor
@AllArgsConstructor
public class Feeding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id") // Location tablosundaki 'id' kolonuna referans veriyor
    private Location locationWhichFeed;

    @ManyToOne
    @JoinColumn(name = "user_id") // User tablosundaki 'id' kolonuna referans veriyor
    private User userWhoFeed;

    private String image;

    private boolean isApproved ;
}
