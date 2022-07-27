package bwina.java_social_server.domain.services.interfaces;

import bwina.java_social_server.core.exceptions.ResourceCreationException;
import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.User;
import java.util.List;

public interface UserService {
    User create(User user) throws ResourceCreationException;
    Boolean doesExist(String id);
    User getById(Long id) throws ResourceNotFoundException;
    User getByEmail(String email) throws ResourceNotFoundException;
    List<User> getAllUsers();
    void update(Long id, User userDetails) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}