package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.*;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor extends User {

    @ManyToMany
    List<Course> courses;
    @ManyToMany
    List<Section> sections;

    //Constructors


    public Instructor(String password, String mail, String name, String surname, String bilkentID, String HESCode) {
        super(password, mail, name, surname, bilkentID, HESCode);
    }

    public Instructor(String username, String password, String mail, String bilkentID, ArrayList<Group> groupsParticipated, CovidInformationCard covidInformationCard, List<Course> courses, List<Section> sections, String fullName) {
        super(username, password, mail, bilkentID, groupsParticipated, covidInformationCard, fullName);
        this.courses = courses;
        this.sections = sections;
    }

    public Instructor() {
    }

    //Methods
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
