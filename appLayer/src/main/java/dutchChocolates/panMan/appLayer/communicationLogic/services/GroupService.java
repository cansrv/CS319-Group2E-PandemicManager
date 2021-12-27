package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.groups.UserCreatedGroup;
import dutchChocolates.panMan.appLayer.models.mediators.UserCreatedGroupMediator;
import dutchChocolates.panMan.appLayer.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    //Properties
    @Resource
    GroupRepository groupRepository;

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private StaffRepository staffRepository;

    @Resource
    private InstructorRepository instructorRepository;

    @Resource
    private TARepository taRepository;
    //Constructors
    @Autowired
    private UserService userService;


    //Methods
    public Group getGroup(Long id) {
        UserCreatedGroup tempGroup = (UserCreatedGroup) groupRepository.getById(id);
        return tempGroup;
    }

    public void updateDBs() {
        staffRepository.flush();
        studentRepository.flush();
        instructorRepository.flush();
        taRepository.flush();
        groupRepository.flush();
    }

    public String setGroup(Group group) {
        try {
            System.out.println(group.toString());
            UserCreatedGroupMediator.getInstance().addParticipants(group, group.getParticipants());
            for (User u : userService.getAllUsers()) {
                u.getGroupsParticipated().add(group);
            }
            updateDBs();
            groupRepository.save((UserCreatedGroup) group);
            updateDBs();
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public ArrayList<Group> getGroupsOfUser(User user) {
        ArrayList<Group> groups = (ArrayList<Group>) groupRepository.findAll();

        System.out.println(groupRepository.findAll());
        System.out.println(groups);

        groups.removeIf(group -> !group.getParticipants().contains(user));

        return groups;
    }

    public String removeGroup(Group group) {
        try {
            groupRepository.delete(group);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public User searchRiskyInGroup() {
        return null;
    }

    public String searchUserInGroup(Group group, User user) {
        return null;
    }


}
