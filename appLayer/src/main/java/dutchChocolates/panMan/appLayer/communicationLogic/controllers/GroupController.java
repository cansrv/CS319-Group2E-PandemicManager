package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dutchChocolates.panMan.appLayer.communicationLogic.services.GroupService;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.groups.UserCreatedGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {
    //Properties
    @Autowired
    GroupService groupService;


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
    public String injectGroup(@RequestBody String groupJson){
        System.out.println(groupJson);
        Gson gson = new GsonBuilder().setExclusionStrategies().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();

        UserCreatedGroup group = (UserCreatedGroup) gson.fromJson(groupJson, Group.class);
        groupService.setGroup(group);

        return groupJson;
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
