package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Lecture;
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



    public String addSection(Boolean isOnline, Integer sectionNumber,  String courseName) {
        Section section = new Section();
        Course course = getCourse(courseName);
        section.setOnline(isOnline);
        section.setSectionNumber(sectionNumber);
        section.setCourse(course);
        course.getSections().add(section);
        updateCourse();
        return sectionRepository.saveAndFlush(section).toString();
    }


    /*
    return args -> {
            Student testStudent = studentRepository.getById("can.surav@ug.bilkent.edu.tr");
            Course course = new Course(new ArrayList<Exam>(), new ArrayList<Section>(), studentRepository.findAll(), instructorRepository.findAll(), taRepository.findAll(), "CS319");
            courseRepository.save(course);
        };
     */

    //Methods

    public Course getCourse(String courseName){
        return courseRepository.getById(courseName);
    }

    public void updateCourse() {
        courseRepository.flush();
    }

    public String addCourse(List<String> courseList) {
        for(int i = 0; i < courseList.size(); i++) {
            Course course = new Course();
            course.setCourseName(courseList.get(i));
            courseRepository.save(course);
        }
        return "Successful";
    }

    public String editCourse(String key, Course course) {
        return "";
    }

    public String addUserToCourse(User user, Course course){
        return "";
    }



    public String setLecture(Section section, Lecture lecture){
        return "";
    }

    public String getSectionsOfCourse(Course course){
        return courseRepository.getById(course.getCourseName()).getSections().toString();
    }

    public String setSectionsOfCourse(List<String> sectionList){
        return "";
    }

    public String getLecturesOfSection(Section section){
        return sectionRepository.getById(section.getId()).getLectures().toString();
    }

    public String setLecturesOfSection(List<String> lectureList){
        return "";
    }

}
