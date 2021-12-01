package dutchChocolates.panMan.appLayer.models;

import dutchChocolates.panMan.appLayer.models.covidinformatics.CovidInformation;

import java.util.UUID;

public abstract class User {
    // Attributes


    CovidInformation covidInformation;
    String userName;
    String password;
    UUID identifier;

    public User() {}

    public User(CovidInformation covidInformation, String userName, String password, UUID identifier) {
        this.covidInformation = covidInformation;
        this.userName = userName;
        this.password = password;
        this.identifier = identifier;
    }

    public CovidInformation getCovidInformation() {
        return covidInformation;
    }

    public void setCovidInformation(CovidInformation covidInformation) {
        this.covidInformation = covidInformation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }
}
