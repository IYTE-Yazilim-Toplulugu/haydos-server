package iyteyazilim.projects.haydos.entity;

import iyteyazilim.projects.haydos.entity.Location;
import iyteyazilim.projects.haydos.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "feeding",schema = "haydosAppDB")
@NoArgsConstructor
@AllArgsConstructor
@Builder

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

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private boolean approved ;


    private  String feedingTime   ;




}
