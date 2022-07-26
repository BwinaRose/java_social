package bwina.java_social_server.domain.users.repo;

import bwina.java_social_server.domain.users.models.UserProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserProfileRepo extends CrudRepository<UserProfile, String> {
    Optional<UserProfile> findByEmail(String email);
}
