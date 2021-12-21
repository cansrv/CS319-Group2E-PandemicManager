package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;

import java.util.List;

public class UserCreatedGroupMediator {

    private static UserCreatedGroupMediator userCreatedGroupMediator  = null;

    private UserCreatedGroupMediator() {}

    public static UserCreatedGroupMediator getInstance() {
        if (userCreatedGroupMediator == null) {
            userCreatedGroupMediator = new UserCreatedGroupMediator();
        }
        return userCreatedGroupMediator;
    }

    public boolean addParticipant(Group group, User user) {
        return true;
    }

    public boolean addParticipants(Group group, List<User> users) {
        return true;
    }

    public boolean exitGroup(Group group) {
        return true;
    }

    public boolean dismissFromGroup(Group group, User user) {
        return true;
    }

    public boolean endGroup(Group group) {
        return true;
    }
}
