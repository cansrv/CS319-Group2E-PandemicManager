package dutchChocolates.panMan.appLayer.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Group {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;
    @ManyToMany
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
