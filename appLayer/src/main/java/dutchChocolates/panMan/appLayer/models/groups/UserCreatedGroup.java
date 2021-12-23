package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;


import java.time.Clock;
import java.util.Date;
import java.util.List;


public class UserCreatedGroup extends Group {
    //Properties
    private Location location;
    private Date date;

    //Constructors

    public UserCreatedGroup(List<User> participants, Location location) {
        super(participants);
        this.location = location;
        this.date = Date.from(Clock.systemDefaultZone().instant());
    }

    public UserCreatedGroup(List<User> participants, Location location, Date date) {
        super(participants);
        this.location = location;
        this.date = date;
    }

    public UserCreatedGroup() {
        super();
    }

    public UserCreatedGroup(long identifier, List<User> participants, Location location, Date date) {
        super(identifier, participants);
        this.location = location;
        this.date = date;
    }

    //Methods
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
