package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.User;


import java.time.Clock;
import java.util.Date;
import java.util.List;


public class StaffCreatedGroup extends UserCreatedGroup {
    //Properties


    //Constructors
    public StaffCreatedGroup() {
        super();
    }

    public StaffCreatedGroup(Location location, List<User> users) {
        super(users, location);
        setDate(Date.from(Clock.systemDefaultZone().instant()));
    }

    public StaffCreatedGroup(long identifier, List<User> participants, Location location, Date date) {
        super(identifier, participants, location, date);
    }

    //Methods


}
