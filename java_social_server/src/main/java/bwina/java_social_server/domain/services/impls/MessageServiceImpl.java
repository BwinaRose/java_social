package bwina.java_social_server.domain.services.impls;

import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Message;
import bwina.java_social_server.domain.repos.MessageRepo;
import bwina.java_social_server.domain.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepo messageRepo;

    @Autowired
    public MessageServiceImpl(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public Message create(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public Message getById(Long id) throws ResourceNotFoundException {
        return messageRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message can not be found or may not exist."));
    }

    @Override
    public Iterable<Message> getBySender(Long senderId) {
        return messageRepo.findBySender(senderId);
    }

    @Override
    public Iterable<Message> getByReceiver(Long receiverId) {
        return messageRepo.findByReceiver(receiverId);
    }

    @Override
    public Iterable<Message> getByDate(Timestamp timestamp){
        return messageRepo.findByDateSent(timestamp);
    }

    @Override
    public Boolean delete(Long id) throws ResourceNotFoundException {
        Message message = messageRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Message can not be found or may not exist."));
        messageRepo.delete(message);
        return true;
    }

}
