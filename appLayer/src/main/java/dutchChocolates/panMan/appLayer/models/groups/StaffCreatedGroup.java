package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StaffCreatedGroup extends UserCreatedGroup {
    //Properties


    //Constructors
    public StaffCreatedGroup() {
    }

    public StaffCreatedGroup(List<User> participants, Location location, Date date) {
        super(participants, location, date);
    }

    public StaffCreatedGroup(UUID identifier, List<User> participants, Location location, Date date) {
        super(identifier, participants, location, date);
    }

    //Methods



}
