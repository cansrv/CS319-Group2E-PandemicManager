package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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



    //Methods
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody String jsonLoginRequest){
        List<String> loginList = new ArrayList<String>();
        JsonObject jsonLogin = new JsonParser().parse(jsonLoginRequest).getAsJsonObject();

        loginList.add(jsonLogin.get(LOGIN_MAIL).getAsString());
        loginList.add(jsonLogin.get(LOGIN_PASSWORD).getAsString());


        return userLoginService.signInMethod(loginList.get(0), loginList.get(1));

    }


}
