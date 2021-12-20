package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.Date;
import java.util.List;

public class UserCreatedGroup extends Group {
    //Properties
    private Location location;
    private Date date;

    //Constructors
    public UserCreatedGroup(){}

    public UserCreatedGroup(Location location){
        this.location = location;
    }

    public UserCreatedGroup(Location location, Date date){
        this.location = location;
        this.date = date;
    }

    public UserCreatedGroup(List<User> participants, Location location, Date date){
        super.setParticipants(participants);
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

    public List<User> getParticipants() {
        return super.getParticipants();
    }

    public boolean setParticipants(List<User> participants) {
            super.setParticipants(participants);
            return true;
    }


}
