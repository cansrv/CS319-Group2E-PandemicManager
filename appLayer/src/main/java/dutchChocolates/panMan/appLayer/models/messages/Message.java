package dutchChocolates.panMan.appLayer.models.messages;


import java.util.List;

public class Message {

    // Attributes
    MessageType messageType;
    List<String> destinationAddress;
    String body;
    String header;

    // Constructors


    public Message(MessageType messageType, List<String> destinationAddress, String body, String header) {
        this.messageType = messageType;
        this.destinationAddress = destinationAddress;
        this.body = body;
        this.header = header;
    }

    public Message() {
    }
}
