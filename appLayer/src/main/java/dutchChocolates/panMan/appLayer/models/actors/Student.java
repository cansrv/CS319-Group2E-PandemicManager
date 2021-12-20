package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.Section;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.List;
import java.util.UUID;

public class Student extends User {
    // Attributes

    List<Section> sections;

    // Constructors


    public Student(String password, String mail, String phoneNumber, String bilkentID) {
        super(password, mail, phoneNumber, bilkentID);
    }

    public Student(String username, String password, UUID identifier, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, List<Section> sections) {
        super(username, password, identifier, mail, phoneNumber, bilkentID, groupsCreated, groupsParticipated, covidInformationCard);
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
