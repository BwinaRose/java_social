package bwina.java_social_server.domain.controllers;

import bwina.java_social_server.core.exceptions.ResourceCreationException;
import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Profile;
import bwina.java_social_server.domain.services.interfaces.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/profile")
public class ProfileController {
    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/new")
    public ResponseEntity<Profile> create(@RequestBody Profile profile) throws ResourceCreationException {
        profile = profileService.create(profile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Profile>>getAll(){
        List<Profile> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Profile profile = profileService.getById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<Profile> getByUserName(@PathVariable("userName") String userName) throws ResourceNotFoundException {
        Profile profile= profileService.getByUserName(userName);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> update(@PathVariable("id") Long id, @RequestBody Profile profileDetail) throws ResourceNotFoundException {
        profileService.update(id, profileDetail);
        return new ResponseEntity<>(profileDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        profileService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
