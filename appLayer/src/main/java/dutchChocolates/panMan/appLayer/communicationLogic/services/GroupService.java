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
    public String getGroup(String name){
        return
    }

    public String setGroup(List<String> groupList){
        return
    }

    public List<String> getUsersOfString(Group group){
        return
    }

    public String setUsersOfGroup(Group group, List<User> userList){
        return
    }

    public String searchUserInGroup(Group group, User user ){
        return
    }

    public String searchUserByName(Group group, String name){
        return
    }

    public String removeUser(Group group, User user){
        return
    }

}
