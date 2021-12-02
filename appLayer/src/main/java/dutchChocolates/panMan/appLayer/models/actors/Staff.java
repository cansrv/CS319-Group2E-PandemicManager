package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.covidinformatics.CovidInformation;
import dutchChocolates.panMan.appLayer.models.groups.EnforcedGroup;

import java.util.ArrayList;
import java.util.UUID;

public class Staff extends User {

    ArrayList<EnforcedGroup> groupsManaged;


    public Staff(CovidInformation covidInformation, String userName, String password,
                 UUID identifier, ArrayList<EnforcedGroup> groupsManaged) {
        super(covidInformation, userName, password, identifier);
        this.groupsManaged = groupsManaged;
    }

    public void createEnforcedGroup(EnforcedGroup enforcedGroup) {

    }

    public void endEnforcedGroup(EnforcedGroup enforcedGroup) {

    }

    public User searchUser(String name) {

        return null;
    }

    @Override
    public CovidInformation getCovidInformation() {
        return super.getCovidInformation();
    }

    @Override
    public void setCovidInformation(CovidInformation covidInformation) {
        super.setCovidInformation(covidInformation);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public UUID getIdentifier() {
        return super.getIdentifier();
    }

    @Override
    public void setIdentifier(UUID identifier) {
        super.setIdentifier(identifier);
    }

    @Override
    public String getMail() {
        return super.getMail();
    }

    @Override
    public void setMail(String mail) {
        super.setMail(mail);
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
