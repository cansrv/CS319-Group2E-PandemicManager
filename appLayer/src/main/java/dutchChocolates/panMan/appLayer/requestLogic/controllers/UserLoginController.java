package dutchChocolates.panMan.appLayer.requestLogic.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.requestLogic.services.UserLoginService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserLoginController {
    //Properties
    private UserLoginService userLoginService;


    //Constructors



    //Methods
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody String jsonRequest){
        List<String> emailPassword = new ArrayList<String>(2);
        JsonObject jsonLogin = new JsonParser().parse(jsonRequest).getAsJsonObject();

        String email = jsonLogin.get("email").getAsString();
        String password = jsonLogin.get("password").getAsString();

        emailPassword.add(email);
        emailPassword.add(password);

        return "Success or failure";
    }




    public UserLoginService getUserLoginService() {
        return userLoginService;
    }

    public void setUserLoginService(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

}
