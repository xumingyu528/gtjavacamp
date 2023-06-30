package site.xmy.projects.cs.im.packet;

import site.xmy.projects.cs.im.protocol.Command;

public class DefaultErrorPacket extends BaseResponsePacket {
    @Override
    public Byte getCommand() {
        return Command.DEFAULT_ERROR;
    }
}
