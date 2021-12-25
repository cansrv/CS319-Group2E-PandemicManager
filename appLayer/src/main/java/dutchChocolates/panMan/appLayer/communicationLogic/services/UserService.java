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
        return null;
    }

    public String setUser(String jsonUser){
        return null;
    }

    public String checkAccess(Student student){
        return null;
    }

    public List<String> getStudentCourses(Student student){
        return null;
    }

    public String setStudentCourse(Student student, List<String> jsonStudentCourses){
        return null;
    }

    public List<String> getInstructorCourses(Instructor instructor){
        return null;
    }

    public String setInstructorCourses(Instructor instructor, List<String> jsonInstructorCourses){
        return null;
    }

    public String getUserCovidInformation(User user){
        return null;
    }

    public String setUserCovidInformation(User user, List<String> jsonCovidInformation){
        return null;
    }

    public List<String> getUserGroups(User user){
        return null;
    }

    public String setUserGroup(User user, List<String> jsonUserGroups){
        return null;
    }
}
