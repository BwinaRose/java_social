package bwina.java_social_server.domain.repos;

import bwina.java_social_server.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}