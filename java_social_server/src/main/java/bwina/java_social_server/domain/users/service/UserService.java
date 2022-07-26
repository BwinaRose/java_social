package bwina.java_social_server.domain.users.service;

import bwina.java_social_server.domain.users.models.UserProfile;

public interface UserService {
    UserProfile create(UserProfile userProfile);
    Boolean doesExist(String id);
}
