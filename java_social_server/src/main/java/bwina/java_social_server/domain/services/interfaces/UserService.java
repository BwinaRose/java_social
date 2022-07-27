package bwina.java_social_server.domain.services.interfaces;

import bwina.java_social_server.domain.models.User;

public interface UserService {
    User create(User user);
    Boolean doesExist(String id);
}