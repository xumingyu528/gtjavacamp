package site.xmy.projects.cs.im.packet;

import site.xmy.projects.cs.im.protocol.Command;

public class LoginResponsePacket extends BaseResponsePacket {
    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
