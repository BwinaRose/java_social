package bwina.java_social_server.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Profile.class)
    @JoinColumn(name = "commenter_id", referencedColumnName = "id")
    private Profile commenter;

    @NonNull
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePosted;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "post_id")
    private Post post;

    @PrePersist
    public void onPost() {
        datePosted = new Date();
    }
}
