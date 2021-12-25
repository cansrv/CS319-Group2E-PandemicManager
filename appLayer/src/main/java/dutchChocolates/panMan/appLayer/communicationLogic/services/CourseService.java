package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.repositories.CourseRepository;
import dutchChocolates.panMan.appLayer.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    //Properties

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    SectionRepository sectionRepository;

    //Methods

    public String addCourse(List<String> loginList) {

        for (String s : loginList) {
            Course course = new Course();
            course.setCourseName(s);
            courseRepository.save(course);
        }
        return "Successful";
    }

    public String addSection(Boolean isOnline, Integer sectionNumber,  String courseName) {
        Section section = new Section();
        Course course = getCourse(courseName);
        section.setOnline(isOnline);
        section.setSectionNumber(sectionNumber);
        section.setCourse(course);
        course.getSections().add(section);
        updateCourse(course);
        return sectionRepository.saveAndFlush(section).toString();
    }


    public Course getCourse(String name) {
        return courseRepository.getById(name);
    }

    public void updateCourse(Course course) {
        courseRepository.flush();
    }





}
