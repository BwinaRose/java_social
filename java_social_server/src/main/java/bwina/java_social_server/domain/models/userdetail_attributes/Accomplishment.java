package bwina.java_social_server.domain.models.userdetail_attributes;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString
@RequiredArgsConstructor
@Table(name = "accomplishments")
public class Accomplishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String accomplishment;
}
