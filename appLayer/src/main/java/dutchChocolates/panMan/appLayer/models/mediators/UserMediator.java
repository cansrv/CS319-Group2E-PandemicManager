package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.covidInformatics.TestType;
import dutchChocolates.panMan.appLayer.models.covidInformatics.Vaccine;

import java.util.Date;
import java.util.List;

public class UserMediator {
    private static UserMediator userMediator = null;

    private UserMediator() {}

    public UserMediator getInstance() {
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
        return null;
    }

    public Group createGroup(List<User> participants) {
        return null;
    }

    public boolean addToGroupsParticipated(User user, Group group) {
        return true;
    }

    public boolean addToGroupsParticipated(List<User> user, Group group) {
        return true;
    }

    public boolean getAppointment(User user, Date testDate, TestType testType) {
        return true;
    }

    public boolean addVaccination(User user, Vaccine vaccine) {
        return true;
    }

    public boolean markRisky(String name) {
        return true;
    }
}
