package bwina.java_social_server.domain.users.service;

import bwina.java_social_server.domain.users.models.UserProfile;
import bwina.java_social_server.domain.users.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserProfileRepo userProfileRepo;

    @Autowired
    public UserServiceImpl(UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }

    @Override
    public UserProfile create(UserProfile userProfile) {
        return null;
    }

    @Override
    public Boolean doesExist(String id) {
        Optional<UserProfile> optional = userProfileRepo.findById(id);
        return optional.isPresent();
    }
}
