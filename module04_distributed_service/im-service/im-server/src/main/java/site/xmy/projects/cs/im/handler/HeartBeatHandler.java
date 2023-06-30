package site.xmy.projects.cs.im.handler;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.xmy.projects.cs.im.packet.HeartBeatPacket;

@ChannelHandler.Sharable
public class HeartBeatHandler extends SimpleChannelInboundHandler<HeartBeatPacket> {
    private HeartBeatHandler() {
    }

    private static HeartBeatHandler instance = new HeartBeatHandler();

    public static HeartBeatHandler getInstance() {
        return instance;
    }

    private static Logger logger = LoggerFactory.getLogger(HeartBeatHandler.class);


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HeartBeatPacket heartBeatPacket) throws Exception {
        logger.info("收到心跳包：{}", JSON.toJSONString(heartBeatPacket));
        channelHandlerContext.writeAndFlush(heartBeatPacket);
    }
}
