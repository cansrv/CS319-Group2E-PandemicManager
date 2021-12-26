package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.groups.UserCreatedGroup;
import dutchChocolates.panMan.appLayer.models.mediators.UserCreatedGroupMediator;
import dutchChocolates.panMan.appLayer.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    //Properties
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private TARepository taRepository;
    //Constructors



    //Methods
    public Group getGroup(Long id){
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

    public String setGroup(Group group){
        try{
            System.out.println(group.toString());
            ArrayList<User> users = new ArrayList<>(group.getParticipants());
            UserCreatedGroupMediator.getInstance().addParticipants(group, group.getParticipants());

            updateDBs();
            groupRepository.save((UserCreatedGroup) group);
            updateDBs();
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
