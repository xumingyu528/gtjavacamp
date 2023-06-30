package site.xmy.projects.cs.im.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import site.xmy.projects.cs.im.protocol.Packet;
import site.xmy.projects.cs.im.protocol.PacketCodeC;

import java.util.List;

@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {

    private PacketCodecHandler(){}

    private static PacketCodecHandler instance = new PacketCodecHandler();

    public static PacketCodecHandler getInstance(){
        return instance;
    }
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, List<Object> list) throws Exception {
        ByteBuf byteBuf = ctx.channel().alloc().ioBuffer();
        // 这一步意义？
        PacketCodeC.getInstance().encode(byteBuf,packet);
        list.add(byteBuf);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf buf, List<Object> list) throws Exception {
        list.add(PacketCodeC.getInstance().decode(buf));
    }
}
