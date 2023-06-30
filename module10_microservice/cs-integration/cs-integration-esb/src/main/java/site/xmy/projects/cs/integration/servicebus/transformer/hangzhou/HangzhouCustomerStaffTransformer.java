package site.xmy.projects.cs.integration.servicebus.transformer.hangzhou;

import com.alibaba.fastjson.JSON;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.integration.domain.enums.Gender;
import site.xmy.projects.cs.integration.domain.enums.Status;
import site.xmy.projects.cs.integration.servicebus.router.hangzhou.dto.HangzhouCustomerStaff;
import site.xmy.projects.cs.integration.servicebus.transformer.CustomerStaffTransformer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class HangzhouCustomerStaffTransformer implements CustomerStaffTransformer<HangzhouCustomerStaff> {
    @Override
    public List<PlatformCustomerStaff> transformerCustomerStaffs(List<HangzhouCustomerStaff> hangzhouCustomerStaffs) {
        List<PlatformCustomerStaff> customerStaffs = new ArrayList<>();
        String string = JSON.toJSONString(hangzhouCustomerStaffs);
        List<HangzhouCustomerStaff> list = JSON.parseArray(string, HangzhouCustomerStaff.class);
        for (HangzhouCustomerStaff hangzhouCustomerStaff : list) {
            PlatformCustomerStaff customerStaff = new PlatformCustomerStaff();

            customerStaff.setStaffName(hangzhouCustomerStaff.getNickname());
            customerStaff.setNickname(hangzhouCustomerStaff.getNickname());
            customerStaff.setPhone(hangzhouCustomerStaff.getPhone());
            customerStaff.setRemark(hangzhouCustomerStaff.getRemark());
            customerStaff.setGoodAt(hangzhouCustomerStaff.getGoodAt());
            customerStaff.setAvatar(hangzhouCustomerStaff.getAvatar());

            if (hangzhouCustomerStaff.getGender() != null)
                customerStaff.setGender(Gender.valueOf(hangzhouCustomerStaff.getGender()));

            if (hangzhouCustomerStaff.getCreatedAt() != null){
                ZoneId zone = ZoneId.systemDefault();
                Instant createdTimeInstance = hangzhouCustomerStaff.getCreatedAt().toInstant();
                LocalDateTime createdTimeLocalDateTime = LocalDateTime.ofInstant(createdTimeInstance,zone);
                customerStaff.setCreateTime(createdTimeLocalDateTime);
            }

            customerStaff.setAccountId(-1L);
            customerStaff.setStatus(Status.OFFLINE);
            customerStaffs.add(customerStaff);

        }

        return customerStaffs;
    }
}
