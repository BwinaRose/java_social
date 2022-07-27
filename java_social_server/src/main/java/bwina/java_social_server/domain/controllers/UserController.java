package bwina.java_social_server.domain.controllers;

import bwina.java_social_server.core.exceptions.ResourceCreationException;
import bwina.java_social_server.domain.models.Profile;
import bwina.java_social_server.domain.models.User;
import bwina.java_social_server.domain.services.interfaces.UserService;
import bwina.java_social_server.security.models.FireBaseUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/me")
    public ResponseEntity<FireBaseUser> getUserInfo(@AuthenticationPrincipal FireBaseUser user) {
        log.info("A request was made by user with id {} and email {}",user.getUid(), user.getEmail());
        Boolean saved = userService.doesExist(user.getUid());
        log.info("Is the user saved {}", saved);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/new")
    public ResponseEntity<User> create(@RequestBody User user) throws ResourceCreationException {
        Long id = user.getId();
        user.setId(id);
        user.setUid(user.getUid());
        //user.setName();
        userService.create(user);
        return ResponseEntity.ok(user);
    }
}