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
    public String signInMethod(String mail, String password) throws EntityNotFoundException, NullPointerException {


        String userJson = "{\n" +
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

        // CHANGE FOR ARBITRARY REPO TYPES
        User tempUser;

        try {
            if (mail.contains("@ug")) {
                tempUser = studentRepository.getById(mail);
                userJson = userJson.replace("USER_TYPE", "Student");
            } else if (mail.contains("@staff")) {
                tempUser = staffRepository.getById(mail);
                userJson = userJson.replace("USER_TYPE", "Staff");

            } else if (mail.contains("@ta")) {
                tempUser = taRepository.getById(mail);
                userJson = userJson.replace("USER_TYPE", "TA");
            } else {
                tempUser = instructorRepository.getById(mail);
                userJson = userJson.replace("USER_TYPE", "Instructor");
            }

            userJson = userJson.replace("USERNAME", tempUser.getUsername());
            userJson = userJson.replace("FULL_NAME", tempUser.getFullName());
            userJson = userJson.replace("PASSWORD", tempUser.getPassword());
            userJson = userJson.replace("MAIL", tempUser.getMail());
            userJson = userJson.replace("BILKENT_ID", tempUser.getBilkentID());
            userJson = userJson.replace("GROUPS_CREATED", tempUser.getGroupsCreated().toString());
            userJson = userJson.replace("GROUPS_PARTICIPATED", tempUser.getGroupsParticipated().toString());
            userJson = userJson.replace("COVID_INFORMATION_CARD", tempUser.getCovidInformationCard().toString());

        }
        catch (Exception ex) {
            if(ex.getClass().equals(EntityNotFoundException.class)) {
                ex.printStackTrace();
                return "Entity Not Found";
            }
            ex.printStackTrace();
        }


        return userJson;

    }


}
