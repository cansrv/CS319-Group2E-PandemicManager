package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.User;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    public StaffCreatedGroup(UUID identifier, List<User> participants, Location location, Date date) {
        super(identifier, participants, location, date);
    }

    //Methods



}
