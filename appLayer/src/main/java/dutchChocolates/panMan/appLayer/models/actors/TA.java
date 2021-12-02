package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.communications.Message;
import dutchChocolates.panMan.appLayer.models.covidinformatics.CovidInformation;

import java.util.UUID;

public class TA extends User {

    public TA(CovidInformation covidInformation, String userName, String password, UUID identifier) {
        super(covidInformation, userName, password, identifier);
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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public User searchUser(String name) {
        return null;
    }

    public void sendMessage(Message message) {

    }
}
