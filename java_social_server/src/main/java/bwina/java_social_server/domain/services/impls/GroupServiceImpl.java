package bwina.java_social_server.domain.services.impls;

import bwina.java_social_server.core.exceptions.ResourceNotFoundException;
import bwina.java_social_server.domain.models.Group;
import bwina.java_social_server.domain.models.Profile;
import bwina.java_social_server.domain.repos.GroupRepo;
import bwina.java_social_server.domain.repos.ProfileRepo;
import bwina.java_social_server.domain.services.interfaces.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    private ProfileRepo profileRepo;
    private GroupRepo groupRepo;

    @Override
    public void create(Long userId, Group group, String groupName) {
        Profile admin = profileRepo.getReferenceById(userId);
        groupRepo.save(group);
    }

    @Override
    public Group getGroupById(Long id) {
        Optional<Group> optional = groupRepo.findById(id);
        return optional.get();
    }

    @Override
    public List<Profile> getAllMembers(Long id) {
        Optional<Group> optional = groupRepo.findById(id);
        return optional.get().getGroupMembers();
    }

}
