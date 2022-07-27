package bwina.java_social_server.domain.services.interfaces;

import bwina.java_social_server.core.exceptions.ResourceCreationException;
import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Profile;

import java.util.List;

public interface ProfileService {
    Profile create(Profile profile) throws ResourceCreationException;
    Profile getById(Long id) throws ResourceNotFoundException;
    List<Profile> getAllFollowers();
    List<Profile> getAllFollowing();
    Profile update(Long id, Profile profile) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
