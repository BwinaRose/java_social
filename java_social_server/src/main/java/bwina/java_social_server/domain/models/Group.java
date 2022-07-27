package bwina.java_social_server.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name="groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String groupName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    @NonNull
    private Profile admin;

    @NonNull
    private String description;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Profile.class)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private List<Profile> groupMembers;
}
