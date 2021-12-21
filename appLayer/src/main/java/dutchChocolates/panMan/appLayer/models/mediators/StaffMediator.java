package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.groups.StaffCreatedGroup;
import dutchChocolates.panMan.appLayer.models.messages.MessageType;

import java.util.List;

public class StaffMediator {
    private static StaffMediator staffMediator = null;
    private StaffMediator() {}
    public StaffMediator getInstance() {
        if (staffMediator == null) {
            staffMediator = new StaffMediator();
        }
        return staffMediator;
    }

    public boolean sendMessage(MessageType messageType, List<String> destinationAddress, String body, String header) {
        return true;
    }

    public StaffCreatedGroup createStaffGroup(List<User> participants) {
        return null;
    }

    public boolean endStaffCreatedGroup(StaffCreatedGroup staffCreatedGroup) {
        return true;
    }

}
