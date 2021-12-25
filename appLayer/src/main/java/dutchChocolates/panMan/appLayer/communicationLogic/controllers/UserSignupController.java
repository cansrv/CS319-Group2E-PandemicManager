package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserSignupController {
    //Properties
    @Autowired
    UserSignupService userSignupService;

    private final String SIGNUP_NAME = "name";
    private final String SIGNUP_EMAIL = "email";
    private final String SIGNUP_SURNAME = "surname";
    private final String SIGNUP_ID = "id";
    private final String SIGNUP_PASSWORD = "password";
    private final String SIGNUP_HES_CODE =  "HEScode";

    //Methods
    @PostMapping("/signup")
    @ResponseBody
    @CrossOrigin
    public String signUp(@RequestBody String jsonSignupRequest){
        List<String> signupList = new ArrayList<String>();
        JsonObject jsonSignup = new JsonParser().parse(jsonSignupRequest).getAsJsonObject();
        signupList.add(jsonSignup.get(SIGNUP_PASSWORD).getAsString());
        signupList.add(jsonSignup.get(SIGNUP_EMAIL).getAsString());
        signupList.add(jsonSignup.get(SIGNUP_NAME).getAsString());
        signupList.add(jsonSignup.get(SIGNUP_SURNAME).getAsString());
        signupList.add(jsonSignup.get(SIGNUP_ID).getAsString());
        signupList.add(jsonSignup.get(SIGNUP_HES_CODE).getAsString());

        return userSignupService.signUpUser(signupList);
    }


    public UserSignupService getUserSignupService() {
        return userSignupService;
    }

    public void setUserSignupService(UserSignupService userSignupService) {
        this.userSignupService = userSignupService;
    }


}
