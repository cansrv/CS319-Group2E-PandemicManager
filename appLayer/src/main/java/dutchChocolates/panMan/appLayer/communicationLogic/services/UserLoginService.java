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

    private String userJson = "{\n" +
            "    \"username\": \"USERNAME\",\n" +
            "    \"fullName\": \"FULL_NAME\",\n" +
            "    \"password\": \"PASSWORD\",\n" +
            "    \"mail\": \"MAIL\",\n" +
            "    \"bilkentID\": \"BILKENT_ID\",\n" +
            "    \"groupsCreated\": \"GROUPS_CREATED\",\n" +
            "    \"groupsParticipated\": \"GROUPS_PARTICIPATED\",\n" +
            "    \"covidInformationCard\": \"COVID_INFORMATION_CARD\",\n" +
            "    \"userType\": \"USER_TYPE\" \n" +
            "}";

    //Constructors

    //Methods
    @Transactional
    public String getByMail(String mail) throws EntityNotFoundException, NullPointerException {
        User tempUser =  studentRepository.getById(mail);

        userJson.replace("USERNAME", tempUser.getUsername());
        userJson.replace("FULL_NAME", tempUser.getFullName());
        userJson.replace("PASSWORD", tempUser.getPassword());
        userJson.replace("MAIL", tempUser.getMail());
        userJson.replace("BILKENT_ID", tempUser.getBilkentID());
        userJson.replace("GROUPS_CREATED", tempUser.getGroupsCreated().toString());
        userJson.replace("GROUPS_PARTICIPATED", tempUser.getGroupsParticipated().toString());
        userJson.replace("COVID_INFORMATION_CARD", tempUser.getCovidInformationCard().toString());

        if(tempUser.getClass().toString().contains("Student")){
            userJson.replace("USER_TYPE", "Student");
        }else if(tempUser.getClass().toString().contains("Instructor")){
            userJson.replace("USER_TYPE", "Instructor");
        }else if(tempUser.getClass().toString().contains("Staff")){
            userJson.replace("USER_TYPE", "Staff");
        }else{
            userJson.replace("USER_TYPE", "TA");
        }

        return userJson;

    }


}
