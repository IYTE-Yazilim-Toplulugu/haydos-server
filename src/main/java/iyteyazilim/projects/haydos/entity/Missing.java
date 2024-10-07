package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Data
@Table(name = "missing" ,schema = "haydosAppDB")
@NoArgsConstructor
@AllArgsConstructor
public class Missing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pawName;

    private String pawPhoto;

    private Long phoneNumber;

    private String description;

    private boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "user_id") // User tablosundaki 'id' kolonuna referans veriyor
    private User userWhoMiss;
}