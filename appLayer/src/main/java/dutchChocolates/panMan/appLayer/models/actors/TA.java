package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.classes.Section;

import java.util.List;
import java.util.UUID;

public class TA extends Student {
    // Attributes

    List<Section> sectionsTaught;

    // Constructors

    public TA(String username, String password, UUID identifier, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, List<Section> sections, List<Section> sectionsTaught) {
        super(username, password, identifier, mail, phoneNumber, bilkentID, groupsCreated, groupsParticipated, covidInformationCard, sections);
        this.sectionsTaught = sectionsTaught;
    }

    public TA(String password, String mail, String phoneNumber, String bilkentID) {
        super(password, mail, phoneNumber, bilkentID);
    }

    public TA() {
    }

    // Operations


    public List<Section> getSectionsTaught() {
        return sectionsTaught;
    }

    public boolean setSectionsTaught(List<Section> sectionsTaught) {
        this.sectionsTaught = sectionsTaught;
        return true;
    }
}
