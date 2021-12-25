package dutchChocolates.panMan.appLayer.communicationLogic.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Staff;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.covidInformatics.VaccinationCard;
import dutchChocolates.panMan.appLayer.models.covidInformatics.Vaccine;
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
    public User searchUser(String sKey) {
        if (studentRepository.findStudentByBilkentID(sKey).getBilkentID().equals(sKey))
            return studentRepository.findStudentByBilkentID(sKey);
        else if (studentRepository.findStudentByFullName(sKey).getFullName().equals(sKey))
            return studentRepository.findStudentByFullName(sKey);

        else if (taRepository.findTAByBilkentID(sKey).getBilkentID().equals(sKey))
            return taRepository.findTAByBilkentID(sKey);
        else if (taRepository.findTAByFullName(sKey).getFullName().equals(sKey))
            return taRepository.findTAByFullName(sKey);

        else if (staffRepository.findStaffByBilkentID(sKey).getBilkentID().equals(sKey))
            return staffRepository.findStaffByBilkentID(sKey);
        else if (staffRepository.findStaffByFullName(sKey).getFullName().equals(sKey))
            return staffRepository.findStaffByFullName(sKey);

        else if (instructorRepository.findInstructorByBilkentID(sKey).getBilkentID().equals(sKey))
            return instructorRepository.findInstructorByBilkentID(sKey);
        else if (instructorRepository.findInstructorByFullName(sKey).getFullName().equals(sKey))
            return instructorRepository.findInstructorByFullName(sKey);

        else
            return null;
    }

    public User getUser(User user) {
        User tempUser;

        if (user.getMail().contains("@ug")) {
            tempUser = studentRepository.getById(user.getMail());
        } else if (user.getMail().contains("@staff")) {
            tempUser = staffRepository.getById(user.getMail());
        } else if (user.getMail().contains("@ta")) {
            tempUser = taRepository.getById(user.getMail());
        } else {
            tempUser = instructorRepository.getById(user.getMail());
        }

        return tempUser;
    }

    public String setUser(User user) {
        try {
            if (user.getMail().contains("@ug")) {
                studentRepository.save((Student) user);
            } else if (user.getMail().contains("@staff")) {
                staffRepository.save((Staff) user);
            } else if (user.getMail().contains("@ta")) {
                taRepository.save((TA) user);
            } else {
                instructorRepository.save((Instructor) user);
            }
            return "Successful";
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return "Fail";
        }

    }

    public String checkAccess(User user) {
        return null;
    }

    public List<Section> getStudentSections(Student student) {
        Student tempStudent = studentRepository.getById(student.getMail());
        return tempStudent.getSections();
    }

    public String setStudentSections(Student student, List<Section> studentSections) {
        try {
            student.setSections(studentSections);
            studentRepository.saveAndFlush(student);
            return "Successful";
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return "Fail";
        }
    }

    public List<Section> getInstructorSections(Instructor instructor) {
        Instructor instructorFromDatabase = instructorRepository.getById(instructor.getMail());
        return instructorFromDatabase.getSections();
    }

    public String setInstructorCourses(Instructor instructor, List<Course> instructorCourses) {
        try {
            instructor.setCourses(instructorCourses);
            setUser(instructor);
            return "Successful";
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return "Fail";
        }
    }

    public CovidInformationCard getUserCovidInformation(User user) {
        User tempUser = getUser(user);
        return tempUser.getCovidInformationCard();
    }

    public String setUserCovidInformation(User user, CovidInformationCard covidInformationCard) {
        try {
            User tempUser = getUser(user);
            tempUser.setCovidInformationCard(covidInformationCard);
            setUser(user);
            return "Successful";
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return "Fail";
        }
    }

    public List<Group> getUserGroups(User user) {
        User tempUser = getUser(user);
        return tempUser.getGroupsParticipated();
    }

    public String setUserGroup(User user, List<Group> userGroups) {
        try {
            User tempUser = getUser(user);
            tempUser.setGroupsParticipated(userGroups);
            setUser(user);
            return "Successful";
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return "Fail";
        }
    }
}
