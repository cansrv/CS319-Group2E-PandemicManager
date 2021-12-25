package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;
import dutchChocolates.panMan.appLayer.repositories.InstructorRepository;
import dutchChocolates.panMan.appLayer.repositories.StaffRepository;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import dutchChocolates.panMan.appLayer.repositories.TARepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class UserService {
    //Properties
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private TARepository taRepository;

    //Methods
    public String getUser(String id){
        return
    }

    public String setUser(String jsonUser){
        return
    }

    public String checkAccess(Student student){
        return
    }

    public List<String> getStudentCourses(Student student){
        return
    }

    public String setStudentCourse(Student student, List<String> jsonStudentCourses){
        return
    }

    public List<String> getInstructorCourses(Instructor instructor){
        return
    }

    public String setInstructorCourses(Instructor instructor, List<String> jsonInstructorCourses){
        return
    }

    public String getUserCovidInformation(User user){
        return
    }

    public String setUserCovidInformation(User user, List<String> jsonCovidInformation){
        return
    }

    public List<String> getUserGroups(User user){
        return
    }

    public String setUserGroup(User user, List<String> jsonUserGroups){
        return
    }
}
