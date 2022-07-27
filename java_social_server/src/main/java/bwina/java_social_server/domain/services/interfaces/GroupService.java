package bwina.java_social_server.domain.services.interfaces;

import bwina.java_social_server.domain.models.Group;
import bwina.java_social_server.domain.models.Profile;

import java.util.List;

public interface GroupService {
    void create(Long userId, Group group, String groupName);
    Group getGroupById(Long id);
    List<Profile> getAllMembers(Long id);
}
