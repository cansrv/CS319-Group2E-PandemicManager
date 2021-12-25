package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

public class UserService {
    //Properties
    @Autowired
    private StudentRepository studentRepository;


    //Constructors
    public UserService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    //Methods



}
