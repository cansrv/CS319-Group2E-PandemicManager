package dutchChocolates.panMan.appLayer.models;


import java.util.List;

public abstract class Group {
    //Properties
    Long id;
    List<User> participants;

    //Constructors
    public Group(List<User> participants) {
        this.participants = participants;
    }

    public Group(long id, List<User> participants) {
        this.id = id;
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
