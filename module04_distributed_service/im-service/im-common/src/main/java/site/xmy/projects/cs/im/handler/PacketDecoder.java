package site.xmy.projects.cs.im.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import site.xmy.projects.cs.im.protocol.PacketCodeC;

import java.util.List;

public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List list) throws Exception {
        list.add(PacketCodeC.getInstance().decode(byteBuf));
    }
}
