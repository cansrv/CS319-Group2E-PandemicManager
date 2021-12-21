package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.messages.Message;

public class MessageMediator {
    //Properties
    private static MessageMediator messageMediator = null;

    //Constructors
    private MessageMediator() {
    }

    //Methods
    public static MessageMediator getInstance() {
        if (messageMediator == null) {
            messageMediator = new MessageMediator();
        }
        return messageMediator;
    }

    public boolean sendMessage(Message message) {
        return true;
    }

}
