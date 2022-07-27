package bwina.java_social_server.domain.models.userdetail_attributes;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String schoolName;
    @NonNull
    private String location;
    @NonNull
    private String startDate;
    @NonNull
    private String endDate;
    @NonNull
    private String fieldOfStudy;
    @NonNull
    private Boolean isGraduated;
    @NonNull
    private Double gradePointAvg;
}
