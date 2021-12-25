package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroupService {
    //Properties
    @Autowired
    GroupRepository groupRepository;

    //Constructors



    //Methods
    public Group getGroup(String name){
        return null;
    }

    public String setGroup(Group group){
        return null;
    }

    public List<String> getUsersOfString(Group group){
        return null;
    }

    public String setUsersOfGroup(Group group, List<User> userList){
        return null;
    }

    public String searchUserInGroup(Group group, User user ){
        return null;
    }

    public String removeUser(Group group, User user) {
        return null;
    }

}
