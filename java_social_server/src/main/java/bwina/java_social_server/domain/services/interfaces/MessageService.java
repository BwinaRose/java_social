package bwina.java_social_server.domain.services.interfaces;

import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Message;

import java.sql.Timestamp;

public interface MessageService {
    Message create(Message message);
    Message getById(Long id) throws ResourceNotFoundException;
    Iterable<Message> getBySender(Long senderId) throws ResourceNotFoundException;
    Iterable<Message> getByReceiver(Long receiverId) throws ResourceNotFoundException;
    Iterable<Message> getByDate(Timestamp timestamp);
    Boolean delete(Long id) throws ResourceNotFoundException;
}
