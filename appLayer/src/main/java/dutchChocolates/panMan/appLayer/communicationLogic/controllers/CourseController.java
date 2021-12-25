package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.communicationLogic.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    //Properties
    @Autowired
    CourseService courseService;


    //Constructors



    //Methods
    @PostMapping("/coursePopulator")
    @ResponseBody
    public String addCourse(@RequestBody String courseName){
        List<String> courseList = new ArrayList<String>();
        JsonObject jsonLogin = new JsonParser().parse(courseName).getAsJsonObject();

        courseList.add(jsonLogin.get("course_name").getAsString());

        return courseService.addCourse(courseList);

    }


    @PostMapping("/sectionPopulator")
    @ResponseBody
    public String addSection(@RequestBody String sectionBody) {
        List<Object> sectionList = new ArrayList<>();
        JsonObject jsonLogin = new JsonParser().parse(sectionBody).getAsJsonObject();
        Boolean isOnline = jsonLogin.get("is_online").getAsBoolean();
        Integer sectionNum = jsonLogin.get("section_number").getAsInt();
        String courseName = jsonLogin.get("course_course_name").getAsString();
        return courseService.addSection(isOnline, sectionNum, courseName);

    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


}
