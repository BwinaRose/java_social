package bwina.java_social_server.domain.services.interfaces;

import bwina.java_social_server.core.exceptions.ResourceCreationException;
import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Profile;

import java.util.List;

public interface ProfileService {
    Profile create(Profile profile) throws ResourceCreationException;
    Profile getById(Long id) throws ResourceNotFoundException;
    Profile getByUserName(String userName) throws ResourceNotFoundException;
    List<Profile> getAllProfiles();
    List<Profile> getAllFollowers();
    List<Profile> getAllFollowing();
    void update(Long id, Profile profile) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
