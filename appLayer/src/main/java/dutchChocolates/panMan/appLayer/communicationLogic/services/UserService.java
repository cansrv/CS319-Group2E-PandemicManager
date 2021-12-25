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
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
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
    public User getUser(String sKey) {
        if (studentRepository.findStudentByBilkentID(sKey).getBilkentID().equals(sKey))
            return studentRepository.findStudentByBilkentID(sKey);
        else if (studentRepository.findStudentByFullName(sKey).getFullName().equals(sKey))
            return studentRepository.findStudentByFullName(sKey);

        else if (taRepository.findTAByBilkentID(sKey).getBilkentID().equals(sKey))
            return taRepository.findTAByBilkentID(sKey);
        else if(taRepository.findTAByFullName(sKey).getFullName().equals(sKey))
            return taRepository.findTAByFullName(sKey);

        else if (staffRepository.findStaffByBilkentID(sKey).getBilkentID().equals(sKey))
            return staffRepository.findStaffByBilkentID(sKey);
        else if( staffRepository.findStaffByFullName(sKey).getFullName().equals(sKey))
            return staffRepository.findStaffByFullName(sKey);

        else if (instructorRepository.findInstructorByBilkentID(sKey).getBilkentID().equals(sKey))
            return instructorRepository.findInstructorByBilkentID(sKey);
        else if(instructorRepository.findInstructorByFullName(sKey).getFullName().equals(sKey))
            return instructorRepository.findInstructorByFullName(sKey);

        else
            return null;
    }

    public String setUser(String jsonUser) {
        return null;
    }

    public String checkAccess(Student student) {
        return null;
    }

    public List<String> getStudentCourses(Student student) {
        return null;
    }

    public String setStudentCourse(Student student, List<String> jsonStudentCourses) {
        return null;
    }

    public List<String> getInstructorCourses(Instructor instructor) {
        return null;
    }

    public String setInstructorCourses(Instructor instructor, List<String> jsonInstructorCourses) {
        return null;
    }

    public String getUserCovidInformation(User user) {
        return null;
    }

    public String setUserCovidInformation(User user, List<String> jsonCovidInformation) {
        return null;
    }

    public List<String> getUserGroups(User user) {
        return null;
    }

    public String setUserGroup(User user, List<String> jsonUserGroups) {
        return null;
    }
}
