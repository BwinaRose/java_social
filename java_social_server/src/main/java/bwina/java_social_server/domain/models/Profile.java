package bwina.java_social_server.domain.models;

import lombok.*;
import javax.persistence.*;

@Entity
@ToString
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String userName;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @OneToOne(targetEntity = UserDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    private UserDetails userDetails;

//    @OneToMany(cascade = CascadeType.ALL)
//    @NonNull
//    private List<Profile> follower;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @NonNull
//    private List<Profile> following;
}
