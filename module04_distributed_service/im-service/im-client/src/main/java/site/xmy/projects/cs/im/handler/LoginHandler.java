package site.xmy.projects.cs.im.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import site.xmy.projects.cs.im.packet.LoginRequestPacket;

public class LoginHandler extends ChannelInboundHandlerAdapter {
    private String userId;
    private String userName;

    public LoginHandler(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LoginRequestPacket packet = getLoginRequestPacket();
        ctx.channel().writeAndFlush(packet);
    }

    public LoginRequestPacket getLoginRequestPacket(){
        LoginRequestPacket packet = new LoginRequestPacket();
        packet.setUserId(this.userId);
        packet.setUserName(this.userName);
        return packet;
    }
}
