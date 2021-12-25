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


    /*
    return args -> {
            Student testStudent = studentRepository.getById("can.surav@ug.bilkent.edu.tr");
            Course course = new Course(new ArrayList<Exam>(), new ArrayList<Section>(), studentRepository.findAll(), instructorRepository.findAll(), taRepository.findAll(), "CS319");
            courseRepository.save(course);
        };
     */

    //Methods

    public String getCourse(String courseName){
        return
    }

    public String addUserToCourse(User user){
        return
    }

    public String addCourse(List<String> loginList) {

        for(int i = 0; i < loginList.size(); i++) {
            Course course = new Course();
            course.setCourseName(loginList.get(i));
            courseRepository.save(course);
        }
        return "Successful";
    }

    public String editCourse(List<String> loginList){
        return
    }

    public String getSection(String sectionName){
        return
    }

    public String setSection(List<String> sectionList){
        return
    }

    public String getLecture(String lectureName){
        return
    }

    public String setLecture(List<String> lectureList){
        return
    }

    public List<String> getSectionsOfCourse(Course course){
        return
    }

    public String setSectionsOfCourse(List<String> sectionList){

    }

    public List<String> getLecturesOfSection(Section section){
        return
    }

    public String setLecturesOfSection(List<String> lectureList){
        return
    }




}
