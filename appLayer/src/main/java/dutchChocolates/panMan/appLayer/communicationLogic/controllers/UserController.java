package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import dutchChocolates.panMan.appLayer.communicationLogic.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //Properties
    UserService userService;


    //Constructors



    //Methods


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
