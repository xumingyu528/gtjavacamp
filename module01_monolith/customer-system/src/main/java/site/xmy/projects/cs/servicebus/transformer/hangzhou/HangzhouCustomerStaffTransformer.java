package site.xmy.projects.cs.servicebus.transformer.hangzhou;

import com.alibaba.fastjson.JSON;
import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.entity.staff.enums.Gender;
import site.xmy.projects.cs.entity.staff.enums.Status;
import site.xmy.projects.cs.servicebus.router.hangzhou.dto.HangzhouCustomerStaff;
import site.xmy.projects.cs.servicebus.transformer.CustomerStaffTransformer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class HangzhouCustomerStaffTransformer implements CustomerStaffTransformer<HangzhouCustomerStaff> {
    @Override
    public List<CustomerStaff> transformerCustomerStaffs(List<HangzhouCustomerStaff> hangzhouCustomerStaffs) {
        List<CustomerStaff> customerStaffs = new ArrayList<>();
        String string = JSON.toJSONString(hangzhouCustomerStaffs);
        List<HangzhouCustomerStaff> list = JSON.parseArray(string, HangzhouCustomerStaff.class);
        for (HangzhouCustomerStaff hangzhouCustomerStaff : list) {
            CustomerStaff customerStaff = new CustomerStaff();

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
