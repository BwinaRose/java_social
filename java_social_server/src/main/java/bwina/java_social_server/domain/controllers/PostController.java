package bwina.java_social_server.domain.controllers;

import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Post;
import bwina.java_social_server.domain.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }



    @GetMapping("{id}")
    public ResponseEntity<Post> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Post post = postService.getById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
