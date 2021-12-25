package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //Properties
    UserService userService;


    //Constructors



    //Methods
    @PostMapping("/addCovidInformationCard")
    @ResponseBody
    public String addCovidInformationCard(@RequestBody String jsonCovidInformationCard){
        JsonObject jsonCovidInfo = new JsonParser().parse(jsonCovidInformationCard).getAsJsonObject();

        return "a";
    }

    @PostMapping("/addVaccine")
    @ResponseBody
    public String addVaccine(@RequestBody String jsonVaccineRequest){
        JsonObject jsonVaccine = new JsonParser().parse(jsonVaccineRequest).getAsJsonObject();

        String userSpec = jsonVaccine.get("mail").getAsString();

        return userSpec;

    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
