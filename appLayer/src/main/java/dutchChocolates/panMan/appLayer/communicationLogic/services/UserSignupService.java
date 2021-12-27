package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Staff;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import dutchChocolates.panMan.appLayer.repositories.InstructorRepository;
import dutchChocolates.panMan.appLayer.repositories.StaffRepository;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import dutchChocolates.panMan.appLayer.repositories.TARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserSignupService {
    //Properties
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    TARepository taRepository;
    @Autowired
    InstructorRepository instructorRepository;

    //Constructors



    //Methods
    @Transactional
    public String signUpUser(List<String> parameters) {
        String mail = parameters.get(1);
        User user;
        if(! mail.contains(".bilkent.edu.tr"))
            return null;
        if(mail.contains("@ug")) {
            user = new Student(parameters.get(0),parameters.get(1), parameters.get(2), parameters.get(3), parameters.get(4), parameters.get(5));
            return studentRepository.save(((Student) user)).toString();
        }
        else if(mail.contains("@staff")) {
            user = new Staff(parameters.get(0),parameters.get(1), parameters.get(2), parameters.get(3), parameters.get(4), parameters.get(5));
            return staffRepository.save(((Staff) user)).toString();
        }
        else if(mail.contains("@ta")) {
            user = new TA(parameters.get(0),parameters.get(1), parameters.get(2), parameters.get(3), parameters.get(4), parameters.get(5));
            return taRepository.save(((TA) user)).toString();
        }
        else {
            user = new Instructor(parameters.get(0),parameters.get(1), parameters.get(2), parameters.get(3), parameters.get(4), parameters.get(5));
            return instructorRepository.save(((Instructor) user)).toString();
        }



    }

    public String checkForUserName(String name){
        return null;
    }

    public String checkForUserID(String id){
        return null;
    }
}
