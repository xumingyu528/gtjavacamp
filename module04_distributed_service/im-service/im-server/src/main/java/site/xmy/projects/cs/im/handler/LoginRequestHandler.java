package site.xmy.projects.cs.im.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import site.xmy.projects.cs.im.packet.LoginRequestPacket;
import site.xmy.projects.cs.im.packet.LoginResponsePacket;
import site.xmy.projects.cs.im.util.LoginUtil;
import site.xmy.projects.cs.im.util.Session;
import site.xmy.projects.cs.im.util.SessionUtil;

@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    private LoginRequestHandler(){}

    private static LoginRequestHandler instance = new LoginRequestHandler();

    public static LoginRequestHandler getInstance(){
        return instance;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        ctx.channel().writeAndFlush(login(ctx,loginRequestPacket));
    }
    private LoginResponsePacket login(ChannelHandlerContext ctx, LoginRequestPacket packet) {
        LoginResponsePacket response = new LoginResponsePacket();

        if(checkLogin(ctx, packet)) {
            response.setCode("0000");
            response.setMsg("登录成功");

            //表示和设置该用户的登录状态
            LoginUtil.markAsLogin(ctx.channel());

            //绑定Session和Channel的关系：最重要的一步
            SessionUtil.bindSession(new Session(packet.getUserId(), packet.getUserName()), ctx.channel());
        } else {
            response.setCode("1001");
            response.setMsg("登录失败");
        }

        return response;
    }

    private boolean checkLogin(ChannelHandlerContext ctx, LoginRequestPacket packet) {
        //判断是否登录过
        return !SessionUtil.hasLogin(ctx.channel());
    }
}
