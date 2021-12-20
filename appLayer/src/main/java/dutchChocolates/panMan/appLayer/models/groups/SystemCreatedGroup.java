package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.List;

public class SystemCreatedGroup extends Group {
    //Properties
    Location location;

    //Constructors
    public SystemCreatedGroup(){
    }

    public SystemCreatedGroup(Location location){
        this.location = location;
    }

    public SystemCreatedGroup(List<User> participants, Location location){
        this.location = location;
        super.setParticipants(participants);
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
