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
        return null;
    }

    public User searchByID(String bilkentID) {
        return null;
    }

    public Group createGroup() {
        return new UserCreatedGroup();
    }

    public Group createGroup(List<User> participants, String loc) {
        Location location = new Location(loc);

        return new UserCreatedGroup(participants, location);
    }

    public boolean addToGroupsParticipated(User user, Group group) {
        user.addToGroupsParticipated(group);
        return UserCreatedGroupMediator.getInstance().addParticipant(group, user);
    }

    public boolean addToGroupsParticipated(List<User> user, Group group) {
        for (User value : user) {
            value.addToGroupsParticipated(group);
        }
        return UserCreatedGroupMediator.getInstance().addParticipants(group, user);
    }

    public boolean getAppointment(User user, Date testDate, TestType testType) {
        return user.getCovidInformationCard().addTest(testDate, testType);
    }

    public boolean addVaccination(User user, Vaccine vaccine) {
        return user.getCovidInformationCard().getVaccinationCard().addVaccine(vaccine);
    }

    public boolean markRisky(String name) {

        return searchByName(name).getCovidInformationCard().setCovidStatus(CovidStatus.Marked);
    }
}
