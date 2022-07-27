package bwina.java_social_server.domain.services.interfaces;

import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Post;

import java.util.List;

public interface PostService {
    void create(Post post);
    Post getById(Long id) throws ResourceNotFoundException;
    List<Post> getProfiles();
    Integer getLikes();
}
