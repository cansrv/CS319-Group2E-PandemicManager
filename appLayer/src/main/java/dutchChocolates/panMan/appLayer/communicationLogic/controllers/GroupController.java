package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import dutchChocolates.panMan.appLayer.communicationLogic.services.GroupService;
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
        return null;
    }

    @PostMapping("/createGroup")
    @ResponseBody
    @CrossOrigin
    public String injectGroup(@RequestBody String groupJson){
        return null;
    }

    @PostMapping("/deleteGroup")
    @ResponseBody
    @CrossOrigin
    public String deleteGroup(@RequestBody Long id){
        return null;
    }


    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }



}
