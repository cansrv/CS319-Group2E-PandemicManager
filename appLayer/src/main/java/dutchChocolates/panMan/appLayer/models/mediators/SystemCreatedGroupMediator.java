package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.groups.SystemCreatedGroup;

public class SystemCreatedGroupMediator {
    private static SystemCreatedGroupMediator systemCreatedGroupMediator = null;

    private SystemCreatedGroupMediator() {
    }

    public static SystemCreatedGroupMediator getInstance() {
        if (systemCreatedGroupMediator == null) {
            systemCreatedGroupMediator = new SystemCreatedGroupMediator();
        }
        return systemCreatedGroupMediator;
    }

    public boolean joinGroup(SystemCreatedGroup systemCreatedGroup, User user) {
        return systemCreatedGroup.getParticipants().add(user);
    }

    public boolean exitGroup(SystemCreatedGroup systemCreatedGroup, User user) {
        return systemCreatedGroup.getParticipants().remove(user);
    }

}
