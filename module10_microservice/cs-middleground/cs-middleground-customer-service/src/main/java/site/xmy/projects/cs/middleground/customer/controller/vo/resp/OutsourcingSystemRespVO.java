package site.xmy.projects.cs.controller.vo.resp;

import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class OutsourcingSystemRespVO {
    private Long id;
    private String systemName;
//    private String systemCode;
    private String description;
    private String systemUrl;
    private String appId;
    private String appKey;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
