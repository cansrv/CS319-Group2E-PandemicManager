package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Staff extends User {
    // Constructors
    public Staff() {
    }

    public Staff(String username, String password, String mail, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, String fullName) {
        super(username, password, mail, bilkentID, groupsCreated, groupsParticipated, covidInformationCard, fullName);
    }

    public Staff(String password, String mail, String name, String surname, String bilkentID, String HESCode) {
        super(password, mail, name, surname, bilkentID, HESCode);
    }
}
