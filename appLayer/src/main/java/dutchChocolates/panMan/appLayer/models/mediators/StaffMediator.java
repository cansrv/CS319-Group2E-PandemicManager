package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Staff;
import dutchChocolates.panMan.appLayer.models.groups.Location;
import dutchChocolates.panMan.appLayer.models.groups.StaffCreatedGroup;
import dutchChocolates.panMan.appLayer.models.messages.Message;
import dutchChocolates.panMan.appLayer.models.messages.MessageType;

import java.util.List;

public class StaffMediator {
    private static StaffMediator staffMediator = null;

    private StaffMediator() {
    }

    public static StaffMediator getInstance() {
        if (staffMediator == null) {
            staffMediator = new StaffMediator();
        }
        return staffMediator;
    }

    public boolean sendMessage(MessageType messageType, List<String> destinationAddress, String body, String header) {
        return MessageMediator.getInstance().sendMessage(new Message(messageType, destinationAddress, body, header));
    }

    public boolean createStaffGroup(List<User> participants, String location, Staff staff) {
        StaffCreatedGroup group = new StaffCreatedGroup(new Location(location), null);
        StaffCreatedGroupMediator.getInstance().addParticipants(group,participants);
        return staff.addToGroupsCreated(group);
    }


}
