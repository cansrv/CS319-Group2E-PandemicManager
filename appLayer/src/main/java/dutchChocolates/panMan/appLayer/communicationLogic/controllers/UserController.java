package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserService;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.covidInformatics.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    //Properties
    @Autowired
    UserService userService;


    //Constructors


    //Methods
    @PostMapping("/addCovidInformationCard")
    @ResponseBody
    public String addCovidInformationCard(@RequestBody String jsonCovidInformationCard) throws ParseException {
        JsonObject jsonCovidInfo = new JsonParser().parse(jsonCovidInformationCard).getAsJsonObject();
        String sKey = jsonCovidInfo.get("sKey").getAsString();
        CovidInformationCard covidInformationCard = new CovidInformationCard();
        covidInformationCard.setCovidStatus(CovidStatus.valueOf(jsonCovidInfo.getAsJsonObject("covidStatus").getAsString()));
        List<String> hesCodes = new ArrayList<>();
        JsonArray hesList = jsonCovidInfo.getAsJsonArray("hesCodes");
        for(int i = 0; i < hesList.size(); i++) {
            hesCodes.add(hesList.get(i).getAsString());
        }
        List<Test> tests = new ArrayList<>();
        JsonArray testList = jsonCovidInfo.getAsJsonArray("tests");
        for(int i = 0; i < testList.size(); i++) {
            tests.add(addTest(testList.getAsJsonObject()));
        }

        covidInformationCard.setHesCodes(hesCodes);
        covidInformationCard.setHesCodeStatus(HESCodeStatus.valueOf(jsonCovidInfo.getAsJsonObject("hesCodeStatus").getAsString()));
        covidInformationCard.setTests(tests);
        // TODO: Create VaccinationCard.


        return userService.setUserCovidInformation(userService.getUser(sKey), covidInformationCard);
    }

    @PostMapping("/addVaccine")
    @ResponseBody
    @CrossOrigin
    public String addVaccine(@RequestBody String jsonVaccineRequest) {
        // TODO: Fill this method to make sense.
        JsonObject jsonVaccine = new JsonParser().parse(jsonVaccineRequest).getAsJsonObject();
        return jsonVaccine.get("mail").getAsString();


    }

    @PostMapping("/addTest")
    @CrossOrigin
    public String addTest(@RequestBody String test) throws ParseException {
        return userService.addTest(new JsonParser().parse(test).getAsJsonObject().getAsJsonObject("mail").getAsString(),
                 addTest(new JsonParser().parse(test).getAsJsonObject().getAsJsonObject("test")));
    }


    @PostMapping("/markSomeoneRisky")
    @CrossOrigin
    public String markSomeoneRisky(@RequestBody String searchKey) {
        JsonObject jsonObject = new JsonParser().parse(searchKey).getAsJsonObject();

        String sKey = jsonObject.get("input").getAsString();
        try {
            User u = userService.markUserRisky(sKey);
            return u.toString();
        } catch (Exception ex) {
            if (ex.getClass().equals(NullPointerException.class)) {
                ex.printStackTrace();
                return "No such user exists";
            }
        }
        return "Fatal Error";
    }
    @PostMapping("/markSelfRisky")
    @CrossOrigin
    public String marSelfRisky(@RequestBody String searchKey) {
        JsonObject jsonObject = new JsonParser().parse(searchKey).getAsJsonObject();

        String sKey = jsonObject.get("email").getAsString();
        try {
            User u = userService.getUser(sKey);
            u.getCovidInformationCard().setCovidStatus(CovidStatus.Risky);
            userService.updateDBs();


        } catch (Exception ex) {
            if (ex.getClass().equals(NullPointerException.class)) {
                ex.printStackTrace();
                return "No such user exists";
            }
        }
        return "Fatal Error";
    }


    @PostMapping("/searchUser")
    @CrossOrigin
    public String searchUser(@RequestBody String searchKey) {
        JsonObject jsonObject = new JsonParser().parse(searchKey).getAsJsonObject();

        String sKey = jsonObject.get("sKey").getAsString();
        try {
            User u = userService.searchUser(sKey);
            return u.toString();
        } catch (Exception ex) {
            if (ex.getClass().equals(NullPointerException.class)) {
                ex.printStackTrace();
                return "No such user exists";
            }
        }
        return "Fatal Error";
    }

    private VaccinationCard vaccinationCardParser(JsonObject vaccinationCardObject) throws ParseException {
        VaccinationCard tempVaccinationCard = new VaccinationCard();

        tempVaccinationCard.setFirstName(vaccinationCardObject.get("firstName").getAsString());
        tempVaccinationCard.setMiddleName(vaccinationCardObject.get("middleName").getAsString());
        tempVaccinationCard.setLastName(vaccinationCardObject.get("lastName").getAsString());
        tempVaccinationCard.setPersonalIdNumber(vaccinationCardObject.get("personalIdNumber").getAsString());

        String idStr = vaccinationCardObject.get("id").getAsString();
        Long id = Long.valueOf(idStr);
        tempVaccinationCard.setId(id);

        Date date = DateFormat.getInstance().parse(vaccinationCardObject.get("date").getAsString());
        tempVaccinationCard.setBirthDate(date);

        JsonArray vaccineArray = vaccinationCardObject.get("vaccines").getAsJsonArray();

        return tempVaccinationCard;
    }


    private Test addTest(JsonObject testObject) throws ParseException {
        Date testDate = DateFormat.getInstance().parse(testObject.get("testDate").getAsString());
        TestType testType = TestType.valueOf(testObject.get("testType").getAsString());
        ResultType resultType = ResultType.valueOf(testObject.get("resultType").getAsString());
        VariantType variantType = VariantType.valueOf(testObject.get("variantType").getAsString());
        return new Test(testDate, testType, resultType, variantType);
    }

}
