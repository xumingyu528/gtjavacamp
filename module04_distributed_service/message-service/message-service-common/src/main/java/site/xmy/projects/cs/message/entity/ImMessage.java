package site.xmy.projects.cs.message.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
//@TableName("im_message")
public class ImMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    //    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long fromUserId;
    private String fromUsername;
    private Long toUserId;
    private String toUsername;
    private String businessTypeCode;
    private String businessTypeName;
    private String message;
    private LocalDateTime createTime;
}
