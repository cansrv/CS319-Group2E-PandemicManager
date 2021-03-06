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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    //Properties
    @Resource
    CourseRepository courseRepository;
    @Resource
    SectionRepository sectionRepository;
    @Resource
    LectureRepository lectureRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private StaffRepository staffRepository;
    @Resource
    private InstructorRepository instructorRepository;
    @Resource
    private TARepository taRepository;

    @Autowired
    UserService userService;

    //Methods
    public String addSection(Boolean isOnline, Integer sectionNumber, String courseName) {
        Section section = new Section();
        Course course = getCourse(courseName);
        section.setOnline(isOnline);
        section.setSectionNumber(sectionNumber);
        section.setCourse(course);
        course.getSections().add(section);
        updateCourse();
        return sectionRepository.saveAndFlush(section).toString();
    }

    public Course getCourse(String courseName) {
        return courseRepository.getById(courseName);
    }

    public void updateCourse(Course course) {
        courseRepository.saveAndFlush(course);
    }

    public Course getCourse(Course course) {
        return courseRepository.getById(course.getCourseName());
    }

    public String addCourse(Course course) {
        ArrayList<TA> tas = (ArrayList<TA>) course.getTAs();
        ArrayList<Instructor> instructors = (ArrayList<Instructor>) course.getInstructors();
        ArrayList<Student> students = (ArrayList<Student>) course.getStudents();

        for (Instructor instructor : instructors) {
            instructor.getCourses().add(course);
        }
        courseRepository.saveAndFlush(course);
        updateDBs();
        return "Successful";
    }

    public List<Course> getCoursesOfUser(User user) {
        ArrayList<Course> courses = (ArrayList<Course>) courseRepository.findAll();

        System.out.println(courseRepository.findAll());
        System.out.println(courses);

        if (user.getEmail().contains("@ug")) {
            courses.removeIf(course -> !course.getStudents().contains(user));
        } else if (user.getEmail().contains("@staff")) {
            courses = new ArrayList<>();
        } else if (user.getEmail().contains("@ta")) {
            courses.removeIf(course -> !course.getTAs().contains(user));
        } else {
            courses.removeIf(course -> !course.getInstructors().contains(user));
        }

        return courses;
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

    public String addStudentToCourse(Student student, Course course) {
        try {
            Course tempCourse = courseRepository.getById(course.getCourseName());
            tempCourse.getStudents().add(student);
            courseRepository.save(tempCourse);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addInstructorToCourse(Instructor instructor, Course course) {
        try {
            Course tempCourse = courseRepository.getById(course.getCourseName());
            tempCourse.getInstructors().add(instructor);
            courseRepository.save(tempCourse);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addTAsToCourse(TA ta, Course course) {
        try {
            Course tempCourse = courseRepository.getById(course.getCourseName());
            tempCourse.getTAs().add(ta);
            courseRepository.save(tempCourse);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addLecture(Course course, Section section, Lecture lecture) {
        try {
            Course tempCourse = courseRepository.getById(course.getCourseName());
            Section tempSection;
            for (Section listSection : tempCourse.getSections()) {
                if (listSection.getId().equals(section.getId())) {
                    listSection.addLecture(lecture);
                }
            }
            courseRepository.save(tempCourse);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public String getSectionsOfCourse(Course course) {
        return courseRepository.getById(course.getCourseName()).getSections().toString();
    }

    public String getLecturesOfSection(Section section) {
        return sectionRepository.getById(section.getId()).getLectures().toString();
    }

    public Exam getExam(Long id) {
        return (Exam) lectureRepository.getById(id);
    }

    public String deleteExam(Exam exam) {
        try {
            lectureRepository.delete(exam);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public String setExam(Exam exam) {
        try {
            lectureRepository.save(exam);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

}
