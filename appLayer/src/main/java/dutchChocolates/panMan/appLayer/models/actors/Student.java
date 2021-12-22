package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {
    // Attributes
    @OneToMany
    List<Section> sections;

    // Constructors


    public Student(String password, String mail, String name, String surname, String bilkentID, String HESCode) {
        super(password, mail, name, surname, bilkentID, HESCode);
    }

    public Student(String username, String password, long identifier, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, List<Section> sections, String fullName) {
        super(username, password, identifier, mail, phoneNumber, bilkentID, groupsCreated, groupsParticipated, covidInformationCard, fullName);
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
