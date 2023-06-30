package site.xmy.projects.cs.middleground.customer.controller.vo.req;

import lombok.Data;
import lombok.experimental.Accessors;
import site.xmy.projects.cs.middleground.customer.entity.staff.enums.Status;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class UpdateCustomerStaffReqVO {

    private Long id;
    private Long groupId;
    private String nickname;
    private String avatar;
    @NotNull(message = "客服人员状态不能为空")
    private Status status;
    private String goodAt;
    private String welcomeMessage;
    private String remark;
}