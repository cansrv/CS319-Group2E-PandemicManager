package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.User;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
@Entity
public class Student extends User {
    // Attributes
    @ManyToMany
    List<Section> sections;

    // Constructors


    public Student(String password, String mail, String name, String surname, String bilkentID, String HESCode) {
        super(password, mail, name, surname, bilkentID, HESCode);
    }

    public Student(String username, String password, String mail, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, List<Section> sections, String fullName) {
        super(username, password, mail, bilkentID, groupsParticipated, covidInformationCard, fullName);
        this.sections = sections;
    }

    public Student() {
    }

    // Getters & Setters


    public List<Section> getSections() {
        return sections;
    }

    public boolean setSections(List<Section> sections) {
        this.sections = sections;
        return true;
    }


}
