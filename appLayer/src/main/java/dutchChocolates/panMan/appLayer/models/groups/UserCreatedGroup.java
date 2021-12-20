package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.ArrayList;
import java.util.Date;

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

    public UserCreatedGroup(ArrayList<User> participants, Location location, Date date){
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

    public ArrayList<User> getParticipants() {
        return super.getParticipants();
    }

    public boolean setParticipants(ArrayList<User> participants) {
        try{
            super.setParticipants(participants);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }


}
