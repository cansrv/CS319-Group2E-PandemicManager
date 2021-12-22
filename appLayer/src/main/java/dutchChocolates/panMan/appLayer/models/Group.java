package dutchChocolates.panMan.appLayer.models;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Inheritance
@DiscriminatorColumn(name = "groupType", discriminatorType = DiscriminatorType.STRING)public abstract class Group {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;
    @ManyToMany(targetEntity = User.class)
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
