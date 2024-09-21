package iyteyazilim.projects.haydos.entity;

import iyteyazilim.projects.haydos.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "adoption")
@NoArgsConstructor
@AllArgsConstructor
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String yourName;

    private String yourPhoto;

    private Long phoneNumber;

    private String description;

    private boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "user_id") // User tablosundaki 'id' kolonuna referans veriyor
    private User userWhoAdopt;
}
