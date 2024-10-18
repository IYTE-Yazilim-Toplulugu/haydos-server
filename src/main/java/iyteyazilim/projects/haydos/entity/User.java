package iyteyazilim.projects.haydos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Entity
@Data
@Table(name = "user", schema = "mydatabase")
@NoArgsConstructor
@AllArgsConstructor


@NamedQuery(
        name = "User.findByUsername",
        query = "SELECT u FROM User u WHERE u.username = :username"
)
public class User implements UserDetails {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @Column(name = "user_name",nullable = false)
    private String name;
    @Column(name = "user_email" , nullable = false  ,unique = true)
    private String username;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}