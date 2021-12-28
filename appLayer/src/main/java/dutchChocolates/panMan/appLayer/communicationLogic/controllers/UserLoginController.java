package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.*;
import com.sun.istack.Nullable;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserLoginService;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserService;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidStatus;
import dutchChocolates.panMan.appLayer.models.covidInformatics.Test;
import dutchChocolates.panMan.appLayer.models.mediators.UserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserLoginController {
    //Properties
    @Autowired
    private UserLoginService userLoginService;

    //Methods
    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin
    public String login(@RequestBody String jsonLoginRequest) {
        JsonObject userJson = new JsonObject();
        JsonObject jsonLogin = new JsonParser().parse(jsonLoginRequest).getAsJsonObject();
        Gson gson = new GsonBuilder().setExclusionStrategies().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();
        String mailStr = jsonLogin.get("mail").getAsString();
        String pwrd = jsonLogin.get("password").getAsString();
        User user = userLoginService.signInMethod(mailStr, pwrd);
        String[] nameArr = user.getFullName().split(" ");

        String userTypeTemp;

        if (mailStr.contains("@ug")) {
            userTypeTemp = "student";
        } else if (mailStr.contains("@staff")) {
            userTypeTemp = "staff";
        } else if (mailStr.contains("@ta")) {
            userTypeTemp = "ta";
        } else {
            userTypeTemp = "instructor";
        }

        List<String> hesCodes = user.getCovidInformationCard().getHesCodes();

        List<Test> tests = user.getCovidInformationCard().getTests();


        //CONSTRUCTION OF THE VALUES OF THE JSON
        String mail = user.getEmail();
        String password = user.getPassword();
        String name = nameArr[0];
        String surname = nameArr[nameArr.length - 1];
        String id = user.getId();
        String accountType = userTypeTemp;
        String HEScode = hesCodes.get(hesCodes.size() - 1);
        String covidStatus = String.valueOf(user.getCovidInformationCard().getCovidStatus());
        boolean vaccinated = false;
        if(user.getCovidInformationCard().getVaccinationCard() != null) {
            vaccinated = user.getCovidInformationCard().getVaccinationCard().getVaccines().size() >= 2;
        }
        boolean isAllowedOnCampus = (user.getCovidInformationCard().getCovidStatus() != CovidStatus.Risky)
                || (user.getCovidInformationCard().getCovidStatus() != CovidStatus.Positive);

        ArrayList<String> testDates = new ArrayList<>();
        ArrayList<String> testTypes = new ArrayList<>();
        ArrayList<String> testResults = new ArrayList<>();

        for (Test test : tests) {
            testDates.add(test.getTestDate().toString().replace("-", "/"));
            testTypes.add(test.getTestType().toString());
            testResults.add(test.getResultType().toString());
        }

        //CONSTRUCTION OF THE JSON OBJECT
        JsonObject userJsonRepresentation = new JsonObject();

        userJsonRepresentation.addProperty("email", mail);
        userJsonRepresentation.addProperty("fullName", name + " " + surname);
        userJsonRepresentation.addProperty("password", password);
        userJsonRepresentation.addProperty("name", name);
        userJsonRepresentation.addProperty("surname", surname);
        userJsonRepresentation.addProperty("id", id);
        userJsonRepresentation.addProperty("accountType", accountType);
        userJsonRepresentation.addProperty("HEScode", HEScode);
        userJsonRepresentation.addProperty("covidStatus", covidStatus);
        userJsonRepresentation.addProperty("vaccinated", vaccinated);
        userJsonRepresentation.addProperty("isAllowedOnCampus", isAllowedOnCampus);

        JsonArray testArray = new JsonArray();
        for (int i = 0; i < testDates.size(); i++) {
            JsonObject testObject = new JsonObject();
            testObject.addProperty("date", testDates.get(i));
            testObject.addProperty("test", testTypes.get(i));
            testObject.addProperty("result", testResults.get(i));

            testArray.add(testObject);
        }

        userJsonRepresentation.add("tests", testArray);

        userLoginService.signInMethod(userJsonRepresentation.get("email").getAsString(), userJsonRepresentation.get("password").getAsString());
        System.out.println(gson.toJson(userJsonRepresentation));
        return gson.toJson(userJsonRepresentation);

    }


}