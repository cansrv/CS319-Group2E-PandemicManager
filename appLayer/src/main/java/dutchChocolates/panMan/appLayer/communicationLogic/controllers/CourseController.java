package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.communicationLogic.services.CourseService;
import dutchChocolates.panMan.appLayer.models.classes.*;
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
        List<String> courseList = new ArrayList<>();
        JsonObject jsonLogin = new JsonParser().parse(courseName).getAsJsonObject();

        courseList.add(jsonLogin.get("course_name").getAsString());

        //TODO need to be successfully connected with the course services add method.
        return null;

    }


    @PostMapping("/sectionPopulator")
    @ResponseBody
    public String addSection(@RequestBody String sectionBody) {
        Boolean isOnline =   new JsonParser().parse(sectionBody).getAsJsonObject().get("is_online").getAsBoolean();
        Integer sectionNum = new JsonParser().parse(sectionBody).getAsJsonObject().get("section_number").getAsInt();
        String courseName =  new JsonParser().parse(sectionBody).getAsJsonObject().get("course_course_name").getAsString();
        Section section = new Section();
        section.setSectionNumber(sectionNum);
        section.setOnline(isOnline);
        Course course =new Course();
        course.setCourseName(courseName);
        section.setCourse(course);
        return courseService.addSection(isOnline, sectionNum, courseName);

    }

    @PostMapping("/getExam")
    @ResponseBody
    public String requestExam(@RequestBody String mail){
        return null;
    }

    @PostMapping("/createExam")
    @ResponseBody
    public String createExam(@RequestBody String examJson){
        return null;
    }

    @PostMapping("/deleteExam")
    @ResponseBody
    public String deleteExam(@RequestBody String mail){
        return null;
    }

    private Attendance attendanceParser(JsonObject jsonObject) {
        return null;
    }

    private Lecture lectureParser(JsonObject jsonObject) {
        return null;
    }

    private Exam examParser(JsonObject jsonObject) {

        return null;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


}
