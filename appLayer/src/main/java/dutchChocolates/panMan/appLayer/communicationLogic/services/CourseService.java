package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    //Properties
    @Autowired
    CourseRepository courseRepository;

    public String addCourse(List<String> courseList) {
        for(int i = 0; i < courseList.size(); i++) {
            Course course = new Course();
            course.setCourseName(courseList.get(i));
            courseRepository.save(course);
        }
        return "Successful";
    }

    //Constructors



    //Methods



}
