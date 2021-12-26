package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.groups.UserCreatedGroup;
import dutchChocolates.panMan.appLayer.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    //Properties
    @Autowired
    GroupRepository groupRepository;

    //Constructors



    //Methods
    public Group getGroup(Long id){
        UserCreatedGroup tempGroup = (UserCreatedGroup) groupRepository.getById(id);
        return tempGroup;
    }

    public String setGroup(Group group){
        try{
            System.out.println(group.toString());
            groupRepository.save((UserCreatedGroup) group);
            return "Success";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    public String removeGroup(Group group){
        try{
            groupRepository.delete(group);
            return "Success";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    public User searchRiskyInGroup(){return null;}

    public String searchUserInGroup(Group group, User user ){
        return null;
    }


}
