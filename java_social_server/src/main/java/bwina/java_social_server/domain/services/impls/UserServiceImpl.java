package bwina.java_social_server.domain.services.impls;

import bwina.java_social_server.core.exceptions.ResourceCreationException;
import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Profile;
import bwina.java_social_server.domain.models.User;
import bwina.java_social_server.domain.repos.UserRepo;
import bwina.java_social_server.domain.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User create(User user) throws ResourceCreationException {
        Optional<User> optional = userRepo.findByEmail(user.getEmail());
        if (optional.isPresent())
            throw new ResourceCreationException("User already exists with email: " + user.getEmail());
        return userRepo.save(user);
    }

    @Override
    public Boolean doesExist(String id) {
        Optional<User> optional = userRepo.findById(Long.valueOf(id));
        return optional.isPresent();
    }

    @Override
    public User getById(Long id) throws ResourceNotFoundException {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + id));

    }

    @Override
    public User getByEmail(String email) throws ResourceNotFoundException {
        return userRepo.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("No user found with email:" + email));

    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void update(Long id, User userDetails) throws ResourceNotFoundException {
        User savedUser = getById(id);
        savedUser.setId((id));
        savedUser.setEmail(userDetails.getEmail());
        savedUser.setPassword(userDetails.getPassword());
        userRepo.save(savedUser);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        User user = getById(id);
        userRepo.delete(user);
    }
}
