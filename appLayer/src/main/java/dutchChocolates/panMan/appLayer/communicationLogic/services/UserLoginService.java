package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
@Service
public class UserLoginService {
    //Properties
    @Autowired
    private StudentRepository studentRepository;


    //Constructors

    //Methods
    @Transactional
    public String getByMail(String mail) throws EntityNotFoundException {
        User tempUser =  studentRepository.getById(mail);


            return tempUser.toString();


    }


}
