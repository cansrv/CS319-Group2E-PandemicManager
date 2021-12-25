package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
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


    //Methods

    public Course getCourse(String courseName){
        return courseRepository.getById(courseName);
    }

    public Course getCourse(Course course){
        return courseRepository.getById(course.getCourseName());
    }

    public void updateCourse() {
        courseRepository.flush();
    }

    public String addCourse(Course course) {
        try{
            courseRepository.save(course);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addStudentToCourse(Student student, Course course){
        try{
            Course tempCourse = courseRepository.getById(course.getCourseName());
            tempCourse.getStudents().add(student);
            courseRepository.save(tempCourse);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addInstructorToCourse(Instructor instructor, Course course){
        try{
            Course tempCourse = courseRepository.getById(course.getCourseName());
            tempCourse.getInstructors().add(instructor);
            courseRepository.save(tempCourse);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addTAsToCourse(TA ta, Course course){
        try{
            Course tempCourse = courseRepository.getById(course.getCourseName());
            tempCourse.getTAs().add(ta);
            courseRepository.save(tempCourse);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }


    public String addLecture(Course course, Section section, Lecture lecture){
        try{
            Course tempCourse = courseRepository.getById(course.getCourseName());
            Section tempSection;
            for(Section listSection : tempCourse.getSections()){
                if(listSection.getId() == section.getId()){
                    listSection.addLecture(lecture);
                }
            }
            courseRepository.save(tempCourse);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
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
