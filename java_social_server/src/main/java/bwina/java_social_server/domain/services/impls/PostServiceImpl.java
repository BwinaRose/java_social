package bwina.java_social_server.domain.services.impls;

import bwina.java_social_server.core.exceptions.ResourceCreationException;
import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Post;
import bwina.java_social_server.domain.repos.PostRepo;
import bwina.java_social_server.domain.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public void create(Post post) {
    }

    @Override
    public Post getById(Long id) throws ResourceNotFoundException {
        return postRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post can not be found or may not exist."));
    }

    @Override
    public List<Post> getProfiles() {
        return null;
    }

    @Override
    public Integer getLikes() {
        return null;
    }
}
