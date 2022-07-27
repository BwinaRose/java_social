package bwina.java_social_server.domain.controllers;

import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Post;
import bwina.java_social_server.domain.models.Profile;
import bwina.java_social_server.domain.services.interfaces.PostService;
import bwina.java_social_server.domain.services.interfaces.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private ProfileService profileService;
    private PostService postService;

    @Autowired
    public ProfileController(ProfileService profileService, PostService postService) {
        this.profileService = profileService;
        this.postService = postService;
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Profile profile = profileService.getById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Post post = postService.getById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
