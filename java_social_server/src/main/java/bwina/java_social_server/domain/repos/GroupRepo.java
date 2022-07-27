package bwina.java_social_server.domain.repos;

import bwina.java_social_server.domain.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GroupRepo extends JpaRepository<Group, Long> {
    Optional<Group> findByAdmin(Long adminId);
    Optional<Group> findByGroupName(String groupName);
}
