package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.classes.Section;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class TA extends Student {
    // Attributes
    @ManyToMany
    List<Section> sectionsTaught;

    // Constructors
    public TA(String username, String password, long identifier, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, List<Section> sections, List<Section> sectionsTaught, String fullName) {
        super(username, password, identifier, mail, phoneNumber, bilkentID, groupsCreated, groupsParticipated, covidInformationCard, sections, fullName);
        this.sectionsTaught = sectionsTaught;
    }

    public TA(String password, String mail, String name, String surname, String bilkentID, String HESCode) {
        super(password, mail, name, surname, bilkentID, HESCode);
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
