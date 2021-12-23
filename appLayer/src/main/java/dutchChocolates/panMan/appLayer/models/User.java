package dutchChocolates.panMan.appLayer.models;

import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidInformationCard;


import java.util.List;



public abstract class User {
    // Attributes
    Long id;
    private String username;
    private String fullName;
    private String password;
    private String mail;
    private String phoneNumber;
    private String bilkentID;
    private List<Group> groupsCreated;
    private List<Group> groupsParticipated;
    private CovidInformationCard covidInformationCard;

    // Constructors
    public User(String password, String mail, String name, String surname, String bilkentID, String hesCode) {
        this.password = password;
        this.mail = mail;
        this.fullName = name + " " + surname;
        this.bilkentID = bilkentID;
        this.setCovidInformationCard(new CovidInformationCard(hesCode));
    }

    public User(String username, String password, Long id, String mail, String phoneNumber, String bilkentID, List<Group> groupsCreated, List<Group> groupsParticipated, CovidInformationCard covidInformationCard, String fullName) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.bilkentID = bilkentID;
        this.groupsCreated = groupsCreated;
        this.groupsParticipated = groupsParticipated;
        this.covidInformationCard = covidInformationCard;
        this.fullName = fullName;
    }

    public User() {
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

    public Long getId() {
        return id;
    }

    public boolean setId(long id) {
        this.id = id;
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
