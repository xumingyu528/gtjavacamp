package site.xmy.projects.cs.integration.servicebus.router.hangzhou.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HangzhouCustomerStaff {

    private Long id;

    /**
     * 昵称
     */
    private String nickname;


    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private String gender;

    /**
     * 擅长领域
     */
    private String goodAt;


    /**
     * 备注
     */
    private String remark;

    private Date createdAt;


}
