package site.xmy.projects.cs.im.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import site.xmy.projects.cs.im.protocol.Packet;
import site.xmy.projects.cs.im.protocol.PacketCodeC;

public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf byteBuf) throws Exception {
        PacketCodeC.getInstance().encode(byteBuf,packet);
    }
}
