package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Staff;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.repositories.InstructorRepository;
import dutchChocolates.panMan.appLayer.repositories.StaffRepository;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import dutchChocolates.panMan.appLayer.repositories.TARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class UserLoginService {
    //Properties
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TARepository taRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private InstructorRepository instructorRepository;

    //Constructors

    //Methods
    @Transactional
    public User signInMethod(String mail, String password) throws EntityNotFoundException, NullPointerException {
        // CHANGE FOR ARBITRARY REPO TYPES
        User tempUser;

        try {
            if (mail.contains("@ug")) {
                tempUser = studentRepository.getById(mail);
                return tempUser;
                //userJson = userJson.replace("USER_TYPE", "Student");
            } else if (mail.contains("@staff")) {
                tempUser = staffRepository.getById(mail);
                return tempUser;
                //userJson = userJson.replace("USER_TYPE", "Staff");
            } else if (mail.contains("@ta")) {
                tempUser = taRepository.getById(mail);
                return tempUser;
                //userJson = userJson.replace("USER_TYPE", "TA");
            } else {
                tempUser = instructorRepository.getById(mail);
                return tempUser;
                //userJson = userJson.replace("USER_TYPE", "Instructor");
            }
        }
        catch (Exception ex) {
            if(ex.getClass().equals(EntityNotFoundException.class)) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public String getUserType(String mail){
        if (mail.contains("@ug")) {
            return "student";
        } else if (mail.contains("@staff")) {
            return "staff";
        } else if (mail.contains("@ta")) {
            return "ta";
        } else {
            return "instructor";
        }
    }


}
