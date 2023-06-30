package site.xmy.projects.cs.im.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import site.xmy.projects.cs.im.packet.*;

import java.util.HashMap;
import java.util.Map;

public class PacketCodeC {

    public static final int MAGIC_NUMBER = 0x88888888;

    public static PacketCodeC instance = new PacketCodeC();

    public static PacketCodeC getInstance() {
        return instance;
    }

    private static final Map<Byte, Class<? extends Packet>> packetTypeMap;
    private static final Map<Byte, Serializer> serializerMap;

    static {
        packetTypeMap = new HashMap<Byte, Class<? extends Packet>>();
        packetTypeMap.put(Command.DEFAULT_ERROR, DefaultErrorPacket.class);
        packetTypeMap.put(Command.HEART_BEAT, HeartBeatPacket.class);
        packetTypeMap.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(Command.LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(Command.MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(Command.MESSAGE_RESPONSE, MessageResponsePacket.class);

        serializerMap = new HashMap<Byte, Serializer>();
        Serializer serializer = new JsonSerializer();
        serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
    }

    private static Serializer serializer = new JsonSerializer();




    /**
     * 编码
     * <p>
     * 魔数（4字节） + 版本号（1字节） + 序列化算法（1字节） + 指令（1字节） + 数据长度（4字节） + 数据（N字节）
     */
    public ByteBuf encode(Packet packet) {
        return encode(ByteBufAllocator.DEFAULT, packet);
    }


    public ByteBuf encode(ByteBufAllocator alloc,Packet packet){
        ByteBuf buf = alloc.ioBuffer();
        return encode(buf,packet);
    }

    public ByteBuf encode(ByteBuf buf,Packet packet) {

        byte[] objBytes = serializer.serialize(packet);

        // encode过程，组装包
        buf.writeInt(MAGIC_NUMBER);
        buf.writeByte(packet.getVersion());
        buf.writeByte(serializer.getSerializerAlgorithm());
        buf.writeByte(packet.getCommand());
        buf.writeInt(objBytes.length);
        buf.writeBytes(objBytes);

        return buf;
    }


    /**
     * 解码
     * @param buf
     * @return Packet
     * 魔数（4字节） + 版本号（1字节） + 序列化算法（1字节） + 指令（1字节） + 数据长度（4字节） + 数据（N字节）
     */

    public Packet decode(ByteBuf buf){
        // 校验魔数
        buf.skipBytes(4);
        // 版本号
        buf.skipBytes(1);
        // 序列化算法
        byte serializeAlgorithm = buf.readByte();
        // 指令
        byte command = buf.readByte();
        // 数据长度
        int len = buf.readInt();

        // 数据
        byte[] dataBytes = new byte[len];
        buf.readBytes(dataBytes);


        Class<? extends Packet> packetType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);
        if (packetType != null && serializer != null) {
            return serializer.deSerialize(packetType, dataBytes);
        }

        return null;

    }



    // 根据序列化算法获取对应的serializer
    public Serializer getSerializer(byte serializeAlgorithm) {
        return serializerMap.get(serializeAlgorithm);
    }

    // 根据指令类型获取对应的packet
    private Class<? extends Packet> getRequestType(byte command) {
        return packetTypeMap.get(command);
    }

    public static void setSerializer(Serializer serializer) {
        PacketCodeC.serializer = serializer;
    }
}
