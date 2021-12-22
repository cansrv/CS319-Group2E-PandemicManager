package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@DiscriminatorValue("USERCREATEDGROUP")
public class UserCreatedGroup extends Group {
    //Properties
    @OneToOne
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
