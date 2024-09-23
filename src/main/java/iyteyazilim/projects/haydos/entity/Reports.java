package iyteyazilim.projects.haydos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@Table(name = "reports",schema = "haydosAppDB")
@NoArgsConstructor
@AllArgsConstructor
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paw_id") // Paws tablosundaki 'id' kolonuna referans veriyor
    private Paws aboutPaw;

    @Column(name = "report_report")
    private String report;

    @Column(name = "report_date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "user_id") // User tablosundaki 'id' kolonuna referans veriyor
    private User userWhoReport;
}

