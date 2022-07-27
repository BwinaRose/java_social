package bwina.java_social_server.domain.models.userdetail_attributes;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String jobTitle;
    @NonNull
    private String company;
    @NonNull
    private String location;
    @NonNull
    private String startDate;
    @NonNull
    private String endDate;
    @NonNull
    private EmploymentType employmentType;
}
