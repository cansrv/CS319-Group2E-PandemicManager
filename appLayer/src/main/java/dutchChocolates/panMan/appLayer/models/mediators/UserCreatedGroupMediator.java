package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.List;

public class UserCreatedGroupMediator {

    private static UserCreatedGroupMediator userCreatedGroupMediator = null;

    private UserCreatedGroupMediator() {
    }

    public static UserCreatedGroupMediator getInstance() {
        if (userCreatedGroupMediator == null) {
            userCreatedGroupMediator = new UserCreatedGroupMediator();
        }
        return userCreatedGroupMediator;
    }

    public boolean addParticipant(Group group, User user) {
        // TODO: Add entrance time to DB.
        return group.getParticipants().add(user);
    }

    public boolean addParticipants(Group group, List<User> users) {
        // TODO: Add entrance times of all users to DB.

        return group.getParticipants().addAll(users);
    }

    public boolean exitGroup(Group group, User user) {
        // TODO: Add exit time to DB.
        group.getParticipants().remove(user);
        return user.getGroupsCreated().remove(group);
    }

    public boolean dismissFromGroup(Group group, User user) {
        // TODO: Add exit time to DB.

        group.getParticipants().remove(user);
        return user.getGroupsParticipated().remove(group);
    }

    public boolean endGroup(Group group, User user) {
        // TODO: Add exit times of all users to DB.

        for (int i = 0; i < group.getParticipants().size(); i++) {
            group.getParticipants().get(i).getGroupsParticipated().remove(group);
        }
        return user.getGroupsCreated().remove(group);
    }
}
