package bwina.java_social_server.domain.controllers;


import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Message;
import bwina.java_social_server.domain.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message){
        Message messageToSave = messageService.create(message);
        return new ResponseEntity<>(messageToSave, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Message message = messageService.getById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMessage(@PathVariable("id") Long id) throws ResourceNotFoundException {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
