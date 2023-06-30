package site.xmy.projects.cs.im.handler;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.xmy.projects.cs.im.packet.LoginResponsePacket;
import site.xmy.projects.cs.im.util.LoginUtil;

@ChannelHandler.Sharable
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    private LoginResponseHandler(){}

    private static LoginResponseHandler instance = new LoginResponseHandler();

    public static LoginResponseHandler getInstance(){
        return instance;
    }

    private static Logger logger = LoggerFactory.getLogger(LoginResponseHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponsePacket loginResponsePacket) throws Exception {
        LoginResponsePacket response = loginResponsePacket;
        if (response.success()){
            logger.info("登录成功");
            LoginUtil.markAsLogin(channelHandlerContext.channel());
        }else {
            logger.info("登录失败"+ JSON.toJSONString(response));
        }
    }

}
