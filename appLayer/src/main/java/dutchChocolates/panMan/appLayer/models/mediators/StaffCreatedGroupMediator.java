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
        // TODO: Add entrance time to DB.
        user.addToGroupsParticipated(group);
        return group.getParticipants().add(user);
    }

    public boolean addParticipants(Group group, List<User> users) {
        // TODO: Add entrance times of all users to DB.

        for (User user: users) {
            user.addToGroupsParticipated(group);
        }
        return group.getParticipants().addAll(users);
    }

    public boolean dismissFromGroup(Group group, User user) {
        // TODO: Add exit time to DB.
        group.getParticipants().remove(user);
        return user.getGroupsParticipated().remove(group);
    }

    public boolean endGroup(Group group) {
        // TODO: Add exit time to DB
        for (User user : group.getParticipants()) {
            user.getGroupsParticipated().remove(group);
        }

        return true;
    }

}
