package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.*;
import com.sun.istack.Nullable;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserLoginService;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserService;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.mediators.UserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserLoginController {
    //Properties
    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private UserService userService;


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

        Gson gson = new GsonBuilder().setExclusionStrategies().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();

        System.out.println("PRE GSON");
        String tempJson = gson.toJson(userLoginService.signInMethod(loginList.get(0), loginList.get(1)));
        System.out.println("AFTER GSONf");
        jsonLogin = new JsonParser().parse(tempJson).getAsJsonObject();

        String mail = jsonLogin.get("email").getAsString();
        JsonElement typeValue = new JsonParser().parse(userLoginService.getUserType(mail));
        jsonLogin.add("accountType", typeValue);

        String json = gson.toJson(jsonLogin);

        return json;

    }


}
