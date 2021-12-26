package dutchChocolates.panMan.appLayer.communicationLogic.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.communicationLogic.services.CourseService;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.classes.*;
import dutchChocolates.panMan.appLayer.models.groups.UserCreatedGroup;
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
    public String requestExam(@RequestBody Long id){
        Exam exam = (Exam) courseService.getExam(id);

        Gson gson = new GsonBuilder().setExclusionStrategies().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();
        return gson.toJson(exam);
    }

    @PostMapping("/createExam")
    @ResponseBody
    public String createExam(@RequestBody String examJson){
        Gson gson = new GsonBuilder().setExclusionStrategies().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();

        Exam exam = gson.fromJson(examJson, Exam.class);
        courseService.setExam(exam);

        return examJson;
    }

    @PostMapping("/deleteExam")
    @ResponseBody
    public String deleteExam(@RequestBody Long id){
        try{
            Exam exam = courseService.getExam(id);
            courseService.deleteExam(exam);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
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
