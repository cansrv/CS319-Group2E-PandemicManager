package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;
@Entity
@DiscriminatorValue("SYSTEMCREATEDGROUP")
public class SystemCreatedGroup extends Group {
    //Properties
    @OneToOne
    Location location;

    //Constructors
    public SystemCreatedGroup(List<User> participants, Location location) {
        super(participants);
        this.location = location;
    }

    public SystemCreatedGroup(long identifier, List<User> participants, Location location) {
        super(identifier, participants);
        this.location = location;
    }

    public SystemCreatedGroup() {
        super();
    }

    //Methods
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
