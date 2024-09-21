package iyteyazilim.projects.haydos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@Table(name = "reports")
@NoArgsConstructor
@AllArgsConstructor
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paw_id") // Paws tablosundaki 'id' kolonuna referans veriyor
    private Paws aboutPaw;

    private String report;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id") // User tablosundaki 'id' kolonuna referans veriyor
    private User userWhoReport;
}

