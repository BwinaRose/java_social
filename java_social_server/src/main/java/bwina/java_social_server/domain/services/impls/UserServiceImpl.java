package bwina.java_social_server.domain.services.impls;

import bwina.java_social_server.domain.models.User;
import bwina.java_social_server.domain.repos.UserRepo;
import bwina.java_social_server.domain.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public Boolean doesExist(String id) {
        Optional<User> optional = userRepo.findById(id);
        return ((Optional<?>) optional).isPresent();
    }
}
