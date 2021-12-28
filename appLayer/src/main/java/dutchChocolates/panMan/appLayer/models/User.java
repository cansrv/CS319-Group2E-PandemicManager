package dutchChocolates.panMan.appLayer.models;

import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    // Attributes
    @CreationTimestamp
    @Column(name="entrytime", updatable = false)
    private Timestamp entryTime;
    @UpdateTimestamp
    @Column(name="exittime")
    private Timestamp exitTime;
    private String username;
    private String fullName;
    private String password;
    @Id
    @Column(name = "mail", unique = true)
    private String email;
    private String id;
    @ManyToMany
    private List<Group> groupsParticipated;
    @OneToOne(cascade=CascadeType.ALL)
    private CovidInformationCard covidInformationCard;

    // Constructors
    public User(String password, String mail, String name, String surname, String bilkentID, String hesCode) {
        this.password = password;
        this.email = mail;
        this.fullName = name + " " + surname;
        this.id = bilkentID;
        this.username = bilkentID + " " + fullName;
        groupsParticipated = new ArrayList<>();
        this.setCovidInformationCard(new CovidInformationCard(hesCode));
    }

    public User(String username, String password, String mail, String bilkentID, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, String fullName) {
        this.username = username;
        this.password = password;
        this.email = mail;
        this.id = bilkentID;
        this.groupsParticipated = groupsParticipated;
        this.covidInformationCard = covidInformationCard;
        this.fullName = fullName;
    }

    public User() {
    }

    //Operators
    public boolean addToGroupsCreated(Group groupsCreated) {
        return true;
    }

    public boolean addToGroupsParticipated(Group groupsParticipated) {
        this.groupsParticipated.add(groupsParticipated);
        return true;
    }

    //Methods


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        this.username = username;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }

    public String getEmail() {
        return email;
    }

    public boolean setMail(String mail) {
        this.email = mail;
        return true;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        return true;
    }

    public String getId() {
        return id;
    }

    public boolean setBilkentID(String bilkentID) {
        this.id = bilkentID;
        return true;
    }

    public boolean setGroupsCreated(List<Group> groupsCreated) {
        return true;
    }

    public List<Group> getGroupsParticipated() {
        return groupsParticipated;
    }

    public boolean setGroupsParticipated(ArrayList<Group> groupsParticipated) {
        this.groupsParticipated = groupsParticipated;
        return true;
    }

    public CovidInformationCard getCovidInformationCard() {
        return covidInformationCard;
    }

    public boolean setCovidInformationCard(CovidInformationCard covidInformationCard) {
        this.covidInformationCard = covidInformationCard;
        return true;
    }


    @Override
    public String toString() {
        return "{" +
                "   entryTime=" + entryTime +
                "   exitTime=" + exitTime +
                "   username='" + username +
                "   fullName='" + fullName +
                "   password='" + password +
                "   mail='" + email + '\'' +
                "   bilkentID='" + id + '\'' +
                "   covidInformationCard=" + covidInformationCard +
                '}';
    }
}
