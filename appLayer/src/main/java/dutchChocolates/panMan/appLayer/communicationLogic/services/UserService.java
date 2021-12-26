package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Staff;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.covidInformatics.Test;
import dutchChocolates.panMan.appLayer.models.covidInformatics.VaccinationCard;
import dutchChocolates.panMan.appLayer.models.covidInformatics.Vaccine;
import dutchChocolates.panMan.appLayer.repositories.InstructorRepository;
import dutchChocolates.panMan.appLayer.repositories.StaffRepository;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import dutchChocolates.panMan.appLayer.repositories.TARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (studentRepository.findStudentByBilkentID(sKey).getId().equals(sKey))
            return studentRepository.findStudentByBilkentID(sKey);
        else if (studentRepository.findStudentByFullName(sKey).getFullName().equals(sKey))
            return studentRepository.findStudentByFullName(sKey);

        else if (taRepository.findTAByBilkentID(sKey).getId().equals(sKey))
            return taRepository.findTAByBilkentID(sKey);
        else if (taRepository.findTAByFullName(sKey).getFullName().equals(sKey))
            return taRepository.findTAByFullName(sKey);

        else if (staffRepository.findStaffByBilkentID(sKey).getId().equals(sKey))
            return staffRepository.findStaffByBilkentID(sKey);
        else if (staffRepository.findStaffByFullName(sKey).getFullName().equals(sKey))
            return staffRepository.findStaffByFullName(sKey);

        else if (instructorRepository.findInstructorByBilkentID(sKey).getId().equals(sKey))
            return instructorRepository.findInstructorByBilkentID(sKey);
        else if (instructorRepository.findInstructorByFullName(sKey).getFullName().equals(sKey))
            return instructorRepository.findInstructorByFullName(sKey);

        else
            return null;
    }

    public User getUser(User user) {
        User tempUser;

        if (user.getEmail().contains("@ug")) {
            tempUser = studentRepository.getById(user.getEmail());
        } else if (user.getEmail().contains("@staff")) {
            tempUser = staffRepository.getById(user.getEmail());
        } else if (user.getEmail().contains("@ta")) {
            tempUser = taRepository.getById(user.getEmail());
        } else {
            tempUser = instructorRepository.getById(user.getEmail());
        }

        return tempUser;
    }

    public User getUser(String mail){
        User tempUser;

        if (mail.contains("@ug")) {
            tempUser = studentRepository.getById(mail);
        } else if (mail.contains("@staff")) {
            tempUser = staffRepository.getById(mail);
        } else if (mail.contains("@ta")) {
            tempUser = taRepository.getById(mail);
        } else {
            tempUser = instructorRepository.getById(mail);
        }

        return tempUser;
    }

    public String setUser(User user) {
        try {
            if (user.getEmail().contains("@ug")) {
                studentRepository.save((Student) user);
            } else if (user.getEmail().contains("@staff")) {
                staffRepository.save((Staff) user);
            } else if (user.getEmail().contains("@ta")) {
                taRepository.save((TA) user);
            } else {
                instructorRepository.save((Instructor) user);
            }
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }

    }

    public List<Section> getStudentSections(Student student) {
        Student tempStudent = studentRepository.getById(student.getEmail());
        return tempStudent.getSections();
    }

    public String setStudentSections(Student student, List<Section> studentSections) {
        try {
            student.setSections(studentSections);
            studentRepository.save(student);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public List<Section> getInstructorSections(String mail) {
        Instructor instructorFromDatabase = instructorRepository.getById(mail);
        return instructorFromDatabase.getSections();
    }

    public List<Course> getInstructorCourses(String mail){
        Instructor instructorFromDatabase = instructorRepository.getById(mail);
        return instructorFromDatabase.getCourses();
    }

    public String setInstructorCourses(Instructor instructor, List<Course> instructorCourses) {
        try {
            instructor.setCourses(instructorCourses);
            setUser(instructor);
            return "Successful";
        } catch (Exception e) {
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
            setUser(tempUser);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public List<Group> getUserGroups(User user) {
        User tempUser = getUser(user);
        return tempUser.getGroupsParticipated();
    }

    public String setUserGroups(User user, List<Group> userGroups) {
        try {
            User tempUser = getUser(user);
            tempUser.setGroupsParticipated(userGroups);
            setUser(tempUser);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public VaccinationCard getVaccinationCard(String mail){
        User tempUser = getUser(mail);
        return tempUser.getCovidInformationCard().getVaccinationCard();
    }

    public String setVaccinationCard(String mail, VaccinationCard vaccinationCard){
        try {
            User tempUser = getUser(mail);
            tempUser.getCovidInformationCard().setVaccinationCard(vaccinationCard);
            setUser(tempUser);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public List<Vaccine> getVaccines(String mail){
        User tempUser = getUser(mail);
        return tempUser.getCovidInformationCard().getVaccinationCard().getVaccines();
    }

    public String setVaccines(String mail, List<Vaccine> vaccines){
        try {
            User tempUser = getUser(mail);
            tempUser.getCovidInformationCard().getVaccinationCard().setVaccines(vaccines);
            setUser(tempUser);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addTest(String mail, Test test){
        try{
            User tempUser = getUser(mail);
            tempUser.getCovidInformationCard().getTests().add(test);
            setUser(tempUser);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addVaccine(String mail, Vaccine vaccine){
        try{
            User tempUser = getUser(mail);
            tempUser.getCovidInformationCard().getVaccinationCard().addVaccine(vaccine);
            setUser(tempUser);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addVaccinationCard(String mail, VaccinationCard vaccinationCard){
        try{
            User tempUser = getUser(mail);
            tempUser.getCovidInformationCard().setVaccinationCard(vaccinationCard);
            setUser(tempUser);
            return "Successful";
        }catch(Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }


}
