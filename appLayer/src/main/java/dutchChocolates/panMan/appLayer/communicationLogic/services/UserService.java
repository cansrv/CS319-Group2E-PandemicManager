package dutchChocolates.panMan.appLayer.communicationLogic.services;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Staff;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.covidInformatics.*;
import dutchChocolates.panMan.appLayer.repositories.InstructorRepository;
import dutchChocolates.panMan.appLayer.repositories.StaffRepository;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import dutchChocolates.panMan.appLayer.repositories.TARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    //Properties
    @Resource
    private StudentRepository studentRepository;

    @Resource
    private StaffRepository staffRepository;

    @Resource
    private InstructorRepository instructorRepository;

    @Resource
    private TARepository taRepository;

    //Methods


    /**
     * public User searchUser(String mail){
     * User tempUser;
     * try {
     * if (mail.contains("@ug")) {
     * tempUser = studentRepository.getById(mail);
     * return tempUser;
     * } else if (mail.contains("@staff")) {
     * tempUser = staffRepository.getById(mail);
     * return tempUser;
     * } else if (mail.contains("@ta")) {
     * tempUser = taRepository.getById(mail);
     * return tempUser;
     * } else {
     * tempUser = instructorRepository.getById(mail);
     * return tempUser;
     * }
     * }catch(Exception e){
     * e.printStackTrace();
     * return null;
     * }
     * }
     **/

    public User editHESCode(String mail, String hes) {

        if (mail.contains("@ug")) {
            Student std = studentRepository.getById(mail);
            std.getCovidInformationCard().getHesCodes().remove(0);
            std.getCovidInformationCard().getHesCodes().add(hes);
            studentRepository.saveAndFlush(std);
            return std;
        } else if (mail.contains("@staff")) {
            Staff staff = staffRepository.getById(mail);
            staff.getCovidInformationCard().getHesCodes().remove(0);
            staff.getCovidInformationCard().getHesCodes().add(hes);
            staffRepository.saveAndFlush(staff);
            return staff;
        } else if (mail.contains("@ta")) {
            TA ta = taRepository.getById(mail);
            ta.getCovidInformationCard().getHesCodes().remove(0);
            ta.getCovidInformationCard().getHesCodes().add(hes);
            taRepository.saveAndFlush(ta);
            return ta;
        } else {
            Instructor instructor = instructorRepository.getById(mail);
            instructor.getCovidInformationCard().getHesCodes().remove(0);
            instructor.getCovidInformationCard().getHesCodes().add(hes);
            instructorRepository.saveAndFlush(instructor);
            return instructor;
        }
    }

    public User searchUser(String sKey) {
        System.out.println(sKey);
        ArrayList<User> users = new ArrayList<>(studentRepository.findAll());
        users.addAll(staffRepository.findAll());
        users.addAll(taRepository.findAll());
        users.addAll(instructorRepository.findAll());
        System.out.println(users);
        for (User u : users) {
            if (u.getId().equals(sKey) || u.getFullName().equals(sKey))
                return u;
        }
        return null;
    }


    public List<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>(studentRepository.findAll());
        users.addAll(staffRepository.findAll());
        users.addAll(taRepository.findAll());
        users.addAll(instructorRepository.findAll());
        return users;
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

    public User getUser(String mail) {
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

    public void updateDBs() {
        staffRepository.flush();
        studentRepository.flush();
        instructorRepository.flush();
        taRepository.flush();
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

    public List<Course> getInstructorCourses(String mail) {
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

    public String setUserGroups(User user, ArrayList<Group> userGroups) {
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

    public VaccinationCard getVaccinationCard(String mail) {
        User tempUser = getUser(mail);
        return tempUser.getCovidInformationCard().getVaccinationCard();
    }

    public String setVaccinationCard(String mail, VaccinationCard vaccinationCard) {
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

    public List<Vaccine> getVaccines(String mail) {
        User tempUser = getUser(mail);
        return tempUser.getCovidInformationCard().getVaccinationCard().getVaccines();
    }

    public String setVaccines(String mail, List<Vaccine> vaccines) {
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

    public String addTest(String mail, Test test) {
        try {
            User tempUser = getUser(mail);
            tempUser.getCovidInformationCard().getTests().add(test);
            setUser(tempUser);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addVaccine(String mail, Vaccine vaccine) {
        try {
            User tempUser = getUser(mail);
            tempUser.getCovidInformationCard().getVaccinationCard().addVaccine(vaccine);
            setUser(tempUser);
            return "Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }

    public String addVaccinationCard(String mail, VaccinationCard vaccinationCard) {
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


}
