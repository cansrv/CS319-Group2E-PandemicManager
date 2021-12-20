package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.List;
import java.util.UUID;

public class SystemCreatedGroup extends Group {
    //Properties
    Location location;

    //Constructors
    public SystemCreatedGroup(List<User> participants, Location location) {
        super(participants);
        this.location = location;
    }

    public SystemCreatedGroup(UUID identifier, List<User> participants, Location location) {
        super(identifier, participants);
        this.location = location;
    }

    public SystemCreatedGroup() {

    }

    //Methods
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<User> getParticipants(){
        return super.getParticipants();
    }

    public boolean setParticipants(List<User> participants){
            super.setParticipants(participants);
            return true;
    }

}
