package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

public class UserLoginService {
    //Properties
    @Autowired
    private StudentRepository studentRepository;


    //Constructors
    public UserLoginService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    //Methods
    @Transactional
    public String getByMail(String mail) throws EntityNotFoundException {
        User tempUser =  studentRepository.getByMail(mail);

        if(tempUser == null){
            return "Amnskim student yok nooooo";
        }else{
            return "Found the student yeeeee";
        }

    }


}
