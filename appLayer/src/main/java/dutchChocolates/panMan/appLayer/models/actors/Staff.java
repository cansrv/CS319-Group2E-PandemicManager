package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.CovidInformationCard;
import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.List;
import java.util.UUID;

public class Staff extends User {
    // Constructors
    public Staff() {
    }

    public Staff(String username, String password, UUID identifier, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard) {
        super(username, password, identifier, mail, phoneNumber, bilkentID, groupsCreated, groupsParticipated, covidInformationCard);
    }

    public Staff(String password, String mail, String phoneNumber, String bilkentID) {
        super(password, mail, phoneNumber, bilkentID);
    }
}
