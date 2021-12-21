package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.List;
import java.util.UUID;

public class Staff extends User {
    // Constructors
    public Staff() {
    }

    public Staff(String username, String password, UUID identifier, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, String fullName) {
        super(username, password, identifier, mail, phoneNumber, bilkentID, groupsCreated, groupsParticipated, covidInformationCard, fullName);
    }

    public Staff(String password, String mail, String phoneNumber, String bilkentID) {
        super(password, mail);
    }
}
