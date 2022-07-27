package bwina.java_social_server.domain.repos;

import bwina.java_social_server.domain.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepo extends JpaRepository<Post,Long> {
    Optional<Post> findByPostContentContains(String content);
    Optional<Post> findByPostOwner(String profileName);
}
