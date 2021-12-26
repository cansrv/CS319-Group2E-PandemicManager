package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Exam;
import dutchChocolates.panMan.appLayer.models.classes.Lecture;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.repositories.*;
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
    @Autowired
    LectureRepository lectureRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private TARepository taRepository;

    @Autowired
    UserService userService;

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

    public Course getCourse(String courseName){
        return courseRepository.getById(courseName);
    }

    public Course getCourse(Course course){
        return courseRepository.getById(course.getCourseName());
    }

    public String addCourse(Course course) {
        ArrayList<TA> tas = (ArrayList<TA>) course.getTAs();
        ArrayList<Instructor> instructors = (ArrayList<Instructor>) course.getInstructors();
        ArrayList<Student> students = (ArrayList<Student>) course.getStudents();

        for (Instructor instructor: instructors) {
            instructor.getCourses().add(course);
        }
        courseRepository.saveAndFlush(course);
        updateDBs();
        return "Successful";
    }

    public List<Course> getCoursesOfInstructor(Instructor instructor){
        ArrayList<Course> courseList = (ArrayList<Course>) courseRepository.findAll();

        for(Course course : courseList){
            if(!course.getInstructors().contains(instructor)){
                courseList.remove(course);
            }
        }

        return courseList;
    }

    public void updateDBs() {
        staffRepository.flush();
        studentRepository.flush();
        instructorRepository.flush();
        taRepository.flush();
    }


    public void updateCourse() {
        courseRepository.flush();
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
                if(listSection.getId().equals(section.getId())){
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

    public String getLecturesOfSection(Section section){
        return sectionRepository.getById(section.getId()).getLectures().toString();
    }

    public Exam getExam(Long id){
        return (Exam) lectureRepository.getById(id);
    }

    public String deleteExam(Exam exam){
        try{
            lectureRepository.delete(exam);
            return "Success";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    public String setExam(Exam exam){
        try{
            lectureRepository.save(exam);
            return "Success";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

}
