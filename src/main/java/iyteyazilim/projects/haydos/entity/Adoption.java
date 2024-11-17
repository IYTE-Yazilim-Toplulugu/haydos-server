package iyteyazilim.projects.haydos.entity;

import iyteyazilim.projects.haydos.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "adoption",schema = "haydosAppDB")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String yourPhoto;

    private Long phoneNumber;

    private String description;

    private boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "user_id") // User tablosundaki 'id' kolonuna referans veriyor
    private User userWhoAdopt;
}
