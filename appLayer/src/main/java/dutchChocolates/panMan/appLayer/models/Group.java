package dutchChocolates.panMan.appLayer.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Group {
    //Properties
    @Id
    @Column(name = "id")
    Long id;
    @ManyToMany
    List<User> participants;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    String groupName;

    //Constructors
    public Group(List<User> participants) {
        this.participants = participants;
    }

    public Group(long id, List<User> participants, String groupName) {
        this.id = id;
        this.participants = participants;
        this.groupName = groupName;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "{" + "\n" +
                "   id:" + "\"" + id + "\"" + ",\n" +
                "   participants:" + participants + "\n" +
                '}';
    }
}
