package site.xmy.projects.cs.im.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.xmy.projects.cs.im.packet.HeartBeatPacket;

public class ClientIdleHandler extends IdleStateHandler {
    private static int HEAT_BEAT_TIME = 50;
    private static Logger logger = LoggerFactory.getLogger(ClientIdleHandler.class);

    public ClientIdleHandler() {
        super(0, 0, HEAT_BEAT_TIME);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        logger.info("发送心跳");
        ctx.writeAndFlush(new HeartBeatPacket());
    }
}
