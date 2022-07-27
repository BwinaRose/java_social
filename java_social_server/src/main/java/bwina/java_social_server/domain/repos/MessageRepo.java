package bwina.java_social_server.domain.repos;

import bwina.java_social_server.domain.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Timestamp;

public interface MessageRepo extends JpaRepository<Message,Long> {
    Iterable<Message> findBySender(Long profileId);
    Iterable<Message> findByReceiver(Long profileId);
    Iterable<Message> findByDateSent(Timestamp timestamp);
}
