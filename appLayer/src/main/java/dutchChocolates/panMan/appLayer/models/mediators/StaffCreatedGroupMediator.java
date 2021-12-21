package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.List;

public class StaffCreatedGroupMediator {


    private static StaffCreatedGroupMediator staffCreatedGroupMediator = null;

    private StaffCreatedGroupMediator() {
    }

    public static StaffCreatedGroupMediator getInstance() {
        if (staffCreatedGroupMediator == null) {
            staffCreatedGroupMediator = new StaffCreatedGroupMediator();
        }
        return staffCreatedGroupMediator;
    }

    public boolean addParticipant(Group group, User user) {
        return true;
    }

    public boolean addParticipants(Group group, List<User> users) {
        return true;
    }

    public boolean dismissFromGroup(Group group, User user) {
        return true;
    }

    public boolean endGroup(Group group) {
        return true;
    }

}
