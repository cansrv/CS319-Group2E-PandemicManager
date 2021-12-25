package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserService;
import dutchChocolates.panMan.appLayer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //Properties
    @Autowired
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

        return jsonVaccine.get("mail").getAsString();

    }

    @PostMapping("/searchUser")
    public String searchUser(@RequestBody String searchKey) {
        JsonObject jsonObject = new JsonParser().parse(searchKey).getAsJsonObject();

        String sKey = jsonObject.get("sKey").getAsString();
        try {
            User u = userService.searchUser(sKey);
            return u.toString();
        } catch (Exception ex) {
            if(ex.getClass().equals(NullPointerException.class)) {
                ex.printStackTrace();
                return "No such user exists";
            }
        }
        return "Fatal Error";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
