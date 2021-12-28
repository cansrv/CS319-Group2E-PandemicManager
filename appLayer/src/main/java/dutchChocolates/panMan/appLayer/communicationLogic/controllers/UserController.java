package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.*;
import dutchChocolates.panMan.appLayer.communicationLogic.services.UserService;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Exam;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.covidInformatics.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        for (int i = 0; i < hesList.size(); i++) {
            hesCodes.add(hesList.get(i).getAsString());
        }
        List<Test> tests = new ArrayList<>();
        JsonArray testList = jsonCovidInfo.getAsJsonArray("tests");
        for (int i = 0; i < testList.size(); i++) {
            tests.add(addTest(testList.getAsJsonObject()));
        }

        covidInformationCard.setHesCodes(hesCodes);
        covidInformationCard.setHesCodeStatus(HESCodeStatus.valueOf(jsonCovidInfo.getAsJsonObject("hesCodeStatus").getAsString()));
        covidInformationCard.setTests(tests);
        // TODO: Create VaccinationCard.


        return userService.setUserCovidInformation(userService.getUser(sKey), covidInformationCard);
    }

    @PostMapping("/getExams")
    @ResponseBody
    @CrossOrigin
    public String getExamsOfUser(@RequestBody String mail) {
        JsonObject jsonMail = new JsonParser().parse(mail).getAsJsonObject();
        String mailStr = jsonMail.get("mail").getAsString();

        ArrayList<Exam> exams = userService.getExamsOfUser(mailStr);
        JsonArray toReturn = new JsonArray();
        for (Exam e : exams) {
            JsonObject tempObject = new JsonObject();
            JsonArray jsonArraySIDs = new JsonArray();
            for (Student s : e.getAttendance().getStudents()) {
                jsonArraySIDs.add(s.getId());
            }
            tempObject.add("participants", jsonArraySIDs);
            for (Course c : e.getCourseCoordinator().getCourses()) {
                if (c.getExams().contains(e)) {
                    tempObject.addProperty("name", c.getCourseName());
                }
            }
            tempObject.addProperty("isOnline", !e.isSpareHour());
            tempObject.addProperty("date", SimpleDateFormat.getInstance().format(e.getAttendance().getDate()).substring(0,8));
            toReturn.add(tempObject);

        }

        return new Gson().toJson(toReturn);
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
        System.out.println(searchKey);

        JsonObject jsonObject = new JsonParser().parse(searchKey).getAsJsonObject();

        String sKey = jsonObject.get("input").getAsString();
        System.out.println("sKey is: " + sKey);
        try {
            User u = userService.searchUser(sKey);
            u.getCovidInformationCard().setCovidStatus(CovidStatus.Marked);
            userService.updateDBs();
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


    @PostMapping("/editHesCode")
    @CrossOrigin
    public String editHesCode(@RequestBody String request) {
        List<String> reqs = new ArrayList<String>();
        JsonObject jsonLogin = new JsonParser().parse(request).getAsJsonObject();

        reqs.add(jsonLogin.get("email").getAsString());
        reqs.add(jsonLogin.get("newHESCode").getAsString());

        return userService.editHESCode(reqs.get(0), reqs.get(1)).toString();

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
