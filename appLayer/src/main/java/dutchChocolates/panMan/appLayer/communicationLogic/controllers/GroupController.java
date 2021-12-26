package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.*;
import dutchChocolates.panMan.appLayer.communicationLogic.services.GroupService;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserService;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.groups.Location;
import dutchChocolates.panMan.appLayer.models.groups.UserCreatedGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class GroupController {
    //Properties
    @Autowired
    GroupService groupService;
    @Autowired
    UserService userService;

    //Constructors



    //Methods
    @PostMapping("/getGroup")
    @ResponseBody
    @CrossOrigin
    public String requestGroup(@RequestBody Long id){
        UserCreatedGroup group = (UserCreatedGroup) groupService.getGroup(id);

        Gson gson = new GsonBuilder().setExclusionStrategies().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();
        return gson.toJson(group);
    }

    @PostMapping("/addGroup")
    @ResponseBody
    @CrossOrigin
    public String injectGroup(@RequestBody String groupJson) throws ParseException {
        System.out.println(groupJson);
        Gson gson = new GsonBuilder().setExclusionStrategies().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();

        JsonObject jsonRepOfGroup = new JsonParser().parse(groupJson).getAsJsonObject();

        Long id = Long.valueOf(jsonRepOfGroup.get("id").getAsString());
        String groupName = jsonRepOfGroup.get("groupName").getAsString();

        String dateStr = jsonRepOfGroup.get("date").getAsString();
        System.out.println(dateStr);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);

        JsonArray jsonParticipantArray = jsonRepOfGroup.get("participants").getAsJsonArray();
        ArrayList<String> participantMailList = new ArrayList<String>();
        if(jsonParticipantArray != null){
            for(int i = 0; i < jsonParticipantArray.size(); i++){
                System.out.println(jsonParticipantArray.get(i).getAsString());
                participantMailList.add(jsonParticipantArray.get(i).getAsString());
            }
        }
        ArrayList<User> participants = new ArrayList<User>();
        for(String mail : participantMailList){
            if(userService.getUser(mail) != null){
                participants.add(userService.getUser(mail));
            }
        }

        String locationStr = jsonRepOfGroup.get("location").getAsString();
        Location location = new Location(locationStr);

        UserCreatedGroup group = new UserCreatedGroup();
        group.setId(id);
        group.setDate(date);
        group.setLocation(location);
        group.setParticipants(participants);

        return groupService.setGroup(group);
    }

    @PostMapping("/deleteGroup")
    @ResponseBody
    @CrossOrigin
    public String deleteGroup(@RequestBody Long id){
        try{
            UserCreatedGroup group = (UserCreatedGroup) groupService.getGroup(id);
            groupService.removeGroup(group);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }


    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }



}
