package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserSignupService {
    //Properties
    @Autowired
    StudentRepository studentRepository;

    //Constructors



    //Methods
    @Transactional
    public String signUpUser(List<String> parameters) {
        try {
            Student student = new Student(parameters.get(0),parameters.get(1), parameters.get(2), parameters.get(3), parameters.get(4), parameters.get(5));
            studentRepository.save(student);
            return "Successful";
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "FAILED";
        }





    }


}
