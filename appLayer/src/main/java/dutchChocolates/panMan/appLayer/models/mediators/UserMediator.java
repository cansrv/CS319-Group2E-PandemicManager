package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidStatus;
import dutchChocolates.panMan.appLayer.models.covidInformatics.TestType;
import dutchChocolates.panMan.appLayer.models.covidInformatics.Vaccine;
import dutchChocolates.panMan.appLayer.models.groups.Location;
import dutchChocolates.panMan.appLayer.models.groups.UserCreatedGroup;

import java.util.Date;
import java.util.List;

public class UserMediator {
    private static UserMediator userMediator = null;

    private UserMediator() {
    }

    public static UserMediator getInstance() {
        if (userMediator == null) {
            userMediator = new UserMediator();
        }
        return userMediator;
    }

    public User searchByName(String name) {
        //TODO: Add queries for searching by name

        return null;
    }

    public User searchByID(String bilkentID) {

        //TODO: Add queries for searching by ID

        return null;
    }

    public boolean createGroup(User user) {
        return user.addToGroupsCreated(new UserCreatedGroup());
    }


    public boolean addToGroupsParticipated(User user, Group group) {
        user.addToGroupsParticipated(group);
        return UserCreatedGroupMediator.getInstance().addParticipant(group, user);
    }

    public boolean addToGroupsParticipated(List<User> users, Group group) {
        for (User value : users) {
            value.addToGroupsParticipated(group);
        }
        return UserCreatedGroupMediator.getInstance().addParticipants(group, users);
    }

    public boolean getAppointment(User user, Date testDate, TestType testType) {
        return user.getCovidInformationCard().addTest(testDate, testType);
    }

    public boolean addVaccination(User user, Vaccine vaccine) {
        return user.getCovidInformationCard().getVaccinationCard().addVaccine(vaccine);
    }

    public boolean markRisky(String name) {
        User markPotential = searchByName(name);
        if(markPotential.getCovidInformationCard().getCovidStatus() == CovidStatus.Negative)
           return markPotential.getCovidInformationCard().setCovidStatus(CovidStatus.Marked);
        return false;
    }
}
