package bwina.java_social_server.domain.repos;

import bwina.java_social_server.domain.models.Profile;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile,Long> {
    @NonNull Optional<Profile> findById(Long id);
    Optional<Profile> findByUserName(String userName);
}
