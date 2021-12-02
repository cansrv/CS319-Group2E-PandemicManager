package dutchChocolates.panMan.appLayer.models.communications;

import java.util.ArrayList;

public class Message {

    String content;
    MessageType type;
    String header;
    ArrayList<String> destinationAddresses;

    public Message(String content, MessageType type, String header, ArrayList<String> destinationAddresses) {
        this.content = content;
        this.type = type;
        this.header = header;
        this.destinationAddresses = destinationAddresses;
    }


}
