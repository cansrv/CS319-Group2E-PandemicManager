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
    public String addCourse(@RequestBody String jsonCourseRequest){
        List<String> courseList = new ArrayList<String>();
        JsonObject jsonCourse = new JsonParser().parse(jsonCourseRequest).getAsJsonObject();

        courseList.add(jsonCourse.get("course_name").getAsString());

        return courseService.addCourse(courseList);
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


}
