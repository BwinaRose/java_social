package bwina.java_social_server.domain.services.impls;

import bwina.java_social_server.core.exceptions.ResourceCreationException;
import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Profile;
import bwina.java_social_server.domain.repos.ProfileRepo;
import bwina.java_social_server.domain.services.interfaces.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    private ProfileRepo profileRepo;

    @Autowired
    public ProfileServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public Profile getById(Long id) throws ResourceNotFoundException {
        return profileRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profile does not exist with id: " + id));
    }

    @Override
    public List<Profile> getAllFollowers() {
        return null;
    }

    @Override
    public List<Profile> getAllFollowing() {
        return null;
    }

    @Override
    public Profile create(Profile profile) throws ResourceCreationException {
        Optional<Profile> optional = profileRepo.findByUserName(profile.getUserName());
        if (optional.isPresent())
            throw new ResourceCreationException("Profile already exists with username: " + profile.getUserName());
        return profileRepo.save(profile);
    }

    @Override
    public Profile update(Long id, Profile profile) throws ResourceNotFoundException {
        Profile savedProfile = getById(id);
        savedProfile.setFirstName(profile.getFirstName());
        savedProfile.setLastName(profile.getLastName());
        savedProfile.setEmail(profile.getEmail());
        savedProfile.setPassword(profile.getPassword());
        savedProfile.setUserDetails(profile.getUserDetails());
        return profileRepo.save(profile);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Profile profile = getById(id);
        profileRepo.delete(profile);
    }
}
