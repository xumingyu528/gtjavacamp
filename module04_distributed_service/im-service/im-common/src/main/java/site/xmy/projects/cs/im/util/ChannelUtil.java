package site.xmy.projects.cs.im.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import site.xmy.projects.cs.im.protocol.Packet;
import site.xmy.projects.cs.im.protocol.PacketCodeC;

public class ChannelUtil {
    public static void writeAndFlush(Channel channel, Packet packet){
        ByteBuf buf = PacketCodeC.getInstance().encode(packet);
        channel.writeAndFlush(buf);
    }
    public static void writeAndFlushWithCtx(ChannelHandlerContext ctx, Packet packet){
        ByteBuf buf = PacketCodeC.getInstance().encode(packet);
        ctx.writeAndFlush(buf);
    }
}
