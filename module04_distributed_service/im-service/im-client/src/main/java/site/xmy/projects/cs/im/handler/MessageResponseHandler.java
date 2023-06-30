package site.xmy.projects.cs.im.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.xmy.projects.cs.im.packet.MessageRequestPacket;
import site.xmy.projects.cs.im.packet.MessageResponsePacket;

@ChannelHandler.Sharable
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    private MessageResponseHandler(){}

    private static MessageResponseHandler instance = new MessageResponseHandler();

    public static MessageResponseHandler getInstance(){
        return instance;
    }

    private static Logger logger = LoggerFactory.getLogger(MessageResponseHandler.class);


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket messageResponsePacket) throws Exception {
        logger.info("收到{}的消息：{}", messageResponsePacket.getFromUserId(),messageResponsePacket.getMessage());
    }
}
