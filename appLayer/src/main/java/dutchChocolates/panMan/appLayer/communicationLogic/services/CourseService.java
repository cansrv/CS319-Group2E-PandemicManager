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

    public String addCourse(List<String> loginList) {

        for(int i = 0; i < loginList.size(); i++) {
            Course course = new Course();
            course.setCourseName(loginList.get(i));
            courseRepository.save(course);
        }
        return "Successful";
    }

    //Constructors

    /*
    return args -> {
            Student testStudent = studentRepository.getById("can.surav@ug.bilkent.edu.tr");
            Course course = new Course(new ArrayList<Exam>(), new ArrayList<Section>(), studentRepository.findAll(), instructorRepository.findAll(), taRepository.findAll(), "CS319");
            courseRepository.save(course);
        };
     */

    //Methods



}
