package dutchChocolates.panMan.appLayer.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Group {
    //Properties
    @Id
    @Column(name = "groupId")
    Long groupId;
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

    public Group(long groupId, List<User> participants, String groupName) {
        this.groupId = groupId;
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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long id) {
        this.groupId = id;
    }


    @Override
    public String toString() {
        return "{" + "\n" +
                "   id:" + "\"" + groupId + "\"" + ",\n" +
                "   participants:" + participants + "\n" +
                '}';
    }
}
