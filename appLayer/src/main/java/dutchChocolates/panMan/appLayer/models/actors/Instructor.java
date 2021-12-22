package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.*;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;
@Entity
@DiscriminatorValue("INSTRUCTOR")
public class Instructor extends User {
    @ManyToMany(targetEntity = Course.class)
    List<Course> courses;
    @ManyToMany(targetEntity = Section.class)
    List<Section> sections;

    //Constructors


    public Instructor(String password, String mail, String name, String surname, String bilkentID, String HESCode) {
        super(password, mail, name, surname, bilkentID, HESCode);
    }

    public Instructor(String username, String password, long identifier, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, List<Course> courses, List<Section> sections, String fullName) {
        super(username, password, identifier, mail, phoneNumber, bilkentID, groupsCreated, groupsParticipated, covidInformationCard, fullName);
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
