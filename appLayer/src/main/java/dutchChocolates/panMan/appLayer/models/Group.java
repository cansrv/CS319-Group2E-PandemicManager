package dutchChocolates.panMan.appLayer.models;

import java.util.UUID;

public abstract class Group {
    // Attributes

    UUID identifier;
    User participants;

    // Constructors


    public Group(User participants) {
        this.participants = participants;
    }

    public Group(UUID identifier, User participants) {
        this.identifier = identifier;
        this.participants = participants;
    }

    public Group() {
    }


}
