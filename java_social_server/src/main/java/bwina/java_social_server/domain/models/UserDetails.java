package bwina.java_social_server.domain.models;

import bwina.java_social_server.domain.models.userdetail_attributes.Accomplishment;
import bwina.java_social_server.domain.models.userdetail_attributes.Education;
import bwina.java_social_server.domain.models.userdetail_attributes.Experience;
import bwina.java_social_server.domain.models.userdetail_attributes.Skill;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = Skill.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    @NonNull
    private List<Skill> skills;

    @OneToMany(targetEntity = Experience.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    @NonNull
    private List<Experience> experience;

    @OneToMany(targetEntity = Education.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    @NonNull
    private List<Education> education;

    @OneToMany(targetEntity = Accomplishment.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    @NonNull
    private List<Accomplishment> accomplishment;
}
