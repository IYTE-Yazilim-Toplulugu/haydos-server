package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@Table(name = "user", schema = "haydosAppDB")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name",nullable = false)
    private String name;
    @Column(name = "user_email" , nullable = false  ,unique = true)
    private String email;
    @Column(name = "user_password" , nullable = false)
    private String password;
    @Column(name = "user_points")
    private Integer points;
    @Column(name = "user_image")
    private String image;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

    @Column(name = "user_email" , nullable = false , unique = true,insertable=false, updatable=false)
    private String phoneNumber;

    @OneToMany(mappedBy = "userWhoMiss", cascade = CascadeType.ALL)
    private List<Missing> missingPawsByMe;

    @OneToMany(mappedBy = "userWhoAdopt", cascade = CascadeType.ALL)
    private List<Adoption> adoptionPawsByMe;

    @OneToMany(mappedBy = "userWhoAnnounce", cascade = CascadeType.ALL)
    private List<Announcement> announcementByMe;

    @OneToMany(mappedBy = "userWhoFeed", cascade = CascadeType.ALL)
    private List<Feeding> feedPawsByMe;

    @OneToMany(mappedBy = "userWhoReport", cascade = CascadeType.ALL)
    private List<Reports> reports;

    @ManyToMany
    @JoinTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<Friends> friends;
}