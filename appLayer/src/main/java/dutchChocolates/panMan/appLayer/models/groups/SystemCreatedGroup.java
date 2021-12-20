package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.ArrayList;

public class SystemCreatedGroup extends Group {
    //Properties
    Location location;

    //Constructors
    public SystemCreatedGroup(){
    }

    public SystemCreatedGroup(Location location){
        this.location = location;
    }

    public SystemCreatedGroup(ArrayList<User> participants, Location location){
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

    public ArrayList<User> getParticipants(){
        return super.getParticipants();
    }

    public boolean setParticipants(ArrayList<User> participants){
        try{
            super.setParticipants(participants);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

}
