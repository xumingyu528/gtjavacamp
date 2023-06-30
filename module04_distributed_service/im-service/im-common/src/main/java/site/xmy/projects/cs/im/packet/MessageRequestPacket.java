package site.xmy.projects.cs.im.packet;

import lombok.Data;
import site.xmy.projects.cs.im.protocol.Command;
import site.xmy.projects.cs.im.protocol.Packet;

@Data
public class MessageRequestPacket extends Packet {
    private String message;

    private String toUserId;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
