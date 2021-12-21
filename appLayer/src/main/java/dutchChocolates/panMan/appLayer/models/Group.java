package dutchChocolates.panMan.appLayer.models;

import java.util.List;
import java.util.UUID;

public abstract class Group {
    //Properties
    UUID identifier;
    List<User> participants;

    //Constructors
    public Group(List<User> participants) {
        this.participants = participants;
        this.identifier = UUID.randomUUID();
    }

    public Group(UUID identifier, List<User> participants) {
        this.identifier = identifier;
        this.participants = participants;
    }

    public Group() {
    }

    //Methods
    public List<User> getParticipants() {
        return this.participants;
    }

    public boolean setParticipants(List<User> participants) {
        this.participants = participants;
        return true;
    }

}
