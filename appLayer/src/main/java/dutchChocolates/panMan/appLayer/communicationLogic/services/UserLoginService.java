package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Staff;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.repositories.InstructorRepository;
import dutchChocolates.panMan.appLayer.repositories.StaffRepository;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import dutchChocolates.panMan.appLayer.repositories.TARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserLoginService {
    //Properties
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private TARepository taRepository;
    @Resource
    private StaffRepository staffRepository;
    @Resource
    private InstructorRepository instructorRepository;

    //Constructors

    //Methods
    @Transactional
    public User signInMethod(String mail, String password) throws EntityNotFoundException, NullPointerException {
        User tempUser;

        try {
            if (mail.contains("@ug")) {
                tempUser = studentRepository.getById(mail);
                //userJson = userJson.replace("USER_TYPE", "Student");
            } else if (mail.contains("@staff")) {
                tempUser = staffRepository.getById(mail);
                //userJson = userJson.replace("USER_TYPE", "Staff");
            } else if (mail.contains("@ta")) {
                tempUser = taRepository.getById(mail);
                //userJson = userJson.replace("USER_TYPE", "TA");
            } else {
                tempUser = instructorRepository.getById(mail);
                //userJson = userJson.replace("USER_TYPE", "Instructor");
            }
            if (tempUser.getPassword().equals(password))
                return tempUser;
            else
                return null;
        } catch (Exception ex) {
            if (ex.getClass().equals(EntityNotFoundException.class)) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public String getUserType(String mail) {
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
