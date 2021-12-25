package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserLoginService;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserLoginController {
    //Properties
    @Autowired
    private UserLoginService userLoginService;


    private final String LOGIN_MAIL = "mail";
    private final String LOGIN_PASSWORD = "password";

    //Constructors



    @PostMapping("")
    @ResponseBody
    @CrossOrigin
    public User method() {
        return new Student();
    }

    //Methods
    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin

    public String login(@RequestBody String jsonLoginRequest){
        List<String> loginList = new ArrayList<String>();
        JsonObject jsonLogin = new JsonParser().parse(jsonLoginRequest).getAsJsonObject();

        loginList.add(jsonLogin.get(LOGIN_MAIL).getAsString());
        loginList.add(jsonLogin.get(LOGIN_PASSWORD).getAsString());

        System.out.println("-----------------\n" + jsonLoginRequest + "-----------------\n");

        return userLoginService.signInMethod(loginList.get(0), loginList.get(1));

    }


}
