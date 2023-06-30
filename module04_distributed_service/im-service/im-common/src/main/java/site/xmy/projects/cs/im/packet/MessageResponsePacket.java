package site.xmy.projects.cs.im.packet;

import lombok.Data;
import site.xmy.projects.cs.im.protocol.Command;
import site.xmy.projects.cs.im.protocol.Packet;


@Data
public class MessageResponsePacket extends Packet {
    private String message;

    private String fromUserId;
    private String fromUserName;


    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
