package bwina.java_social_server.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private String id;

    @NonNull
    private String email;

}