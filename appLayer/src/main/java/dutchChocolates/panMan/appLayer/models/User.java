package dutchChocolates.panMan.appLayer.models;

import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;

import java.util.List;
import java.util.UUID;

public abstract class User {
    // Attributes
    String username;
    String fullName;
    String password;
    UUID identifier;
    String mail;
    String phoneNumber;
    String bilkentID;
    List<Group> groupsCreated;
    List<Group> groupsParticipated;
    CovidInformationCard covidInformationCard;

    // Constructors
    public User(String password, String mail) {
        this.identifier = UUID.randomUUID();
        this.password = password;
        this.mail = mail;
    }

    public User(String username, String password, UUID identifier, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, String fullName) {
        this.username = username;
        this.password = password;
        this.identifier = identifier;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.bilkentID = bilkentID;
        this.groupsCreated = groupsCreated;
        this.groupsParticipated = groupsParticipated;
        this.covidInformationCard = covidInformationCard;
        this.fullName = fullName;
    }

    public User() {
        identifier = UUID.randomUUID();
    }

    //Operators
    public boolean addToGroupsCreated(Group groupsCreated) {
        this.groupsCreated.add(groupsCreated);
        return true;
    }

    public boolean addToGroupsParticipated(Group groupsParticipated) {
        this.groupsParticipated.add(groupsParticipated);
        return true;
    }

    //Methods
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

    public UUID getIdentifier() {
        return identifier;
    }

    public boolean setIdentifier(UUID identifier) {
        this.identifier = identifier;
        return true;
    }

    public String getMail() {
        return mail;
    }

    public boolean setMail(String mail) {
        this.mail = mail;
        return true;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return true;
    }

    public String getBilkentID() {
        return bilkentID;
    }

    public boolean setBilkentID(String bilkentID) {
        this.bilkentID = bilkentID;
        return true;
    }

    public List<Group> getGroupsCreated() {
        return groupsCreated;
    }

    public boolean setGroupsCreated(List<Group> groupsCreated) {
        this.groupsCreated = groupsCreated;
        return true;
    }

    public List<Group> getGroupsParticipated() {
        return groupsParticipated;
    }

    public boolean setGroupsParticipated(List<Group> groupsParticipated) {
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

}
