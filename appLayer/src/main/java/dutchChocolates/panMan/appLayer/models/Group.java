package dutchChocolates.panMan.appLayer.models;

import dutchChocolates.panMan.appLayer.models.groups.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Group {
    //Properties
    UUID identifier;
    ArrayList<User> participants;

    //Constructors
    public Group(ArrayList<User> participants) {
        this.participants = participants;
    }

    public Group(UUID identifier, ArrayList<User> participants) {
        this.identifier = identifier;
        this.participants = participants;
    }

    public Group() {
    }

    //Methods
    public ArrayList<User> getParticipants(){
        return this.participants;
    }

    public boolean setParticipants(ArrayList<User> participants){
        this.participants = participants;
        return true;
    }

}
