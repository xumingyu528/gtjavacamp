package site.xmy.hangzhou.controller.vo.req;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HangzhouCustomerStaffUpdateReqVO {
    private Long id;
    private String nickname;
    private String avatar;
    private String phone;
    private String gender;
    private String goodAt;
    private String remark;
}
