package site.xmy.projects.cs.im.protocol;

import lombok.Data;

@Data
public abstract class Packet {
    // 版本号
    private Byte version = 1;
    // 获取指令
    public abstract Byte getCommand();
}
