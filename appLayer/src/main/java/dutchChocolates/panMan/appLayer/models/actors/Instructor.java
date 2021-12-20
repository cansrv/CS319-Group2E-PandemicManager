package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.*;

import java.util.List;
import java.util.UUID;

public class Instructor extends User {
    List<Course> courses;
    List<Section> sections;

    // Constructors

    public Instructor(String username, String password, UUID identifier, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, List<Course> courses, List<Section> sections) {
        super(username, password, identifier, mail, phoneNumber, bilkentID, groupsCreated, groupsParticipated, covidInformationCard);
        this.courses = courses;
        this.sections = sections;
    }

    public Instructor(String password, String mail, String phoneNumber, String bilkentID) {
        super(password, mail, phoneNumber, bilkentID);
    }

    public Instructor() {
    }

    // Getters & Setters


    public List<Course> getCourses() {
        return courses;
    }

    public boolean setCourses(List<Course> courses) {
        this.courses = courses;
        return true;
    }

    public List<Section> getSections() {
        return sections;
    }

    public boolean setSections(List<Section> sections) {
        this.sections = sections;
        return true;
    }
}
