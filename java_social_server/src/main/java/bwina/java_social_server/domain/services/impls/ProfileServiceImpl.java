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
    public Profile getByUserName(String userName) throws ResourceNotFoundException {
        return profileRepo.findByUserName(userName)
                .orElseThrow(()-> new ResourceNotFoundException("No profile with username:" + userName));
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
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
    public void update(Long id, Profile profileDetails) throws ResourceNotFoundException {
        Profile savedProfile = getById(id);
        savedProfile.setId((id));
        savedProfile.setUserName(profileDetails.getUserName());
        savedProfile.setFirstName(profileDetails.getFirstName());
        savedProfile.setLastName(profileDetails.getLastName());
        savedProfile.setUserDetails(profileDetails.getUserDetails());
        profileRepo.save(savedProfile);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Profile profile = getById(id);
        profileRepo.delete(profile);
    }
}
