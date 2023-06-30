package site.xmy.hangzhou.service;

import site.xmy.hangzhou.entity.HangzhouCustomerStaff;

import java.util.Date;
import java.util.List;

public interface HangzhouCustomerStaffService {

    List<HangzhouCustomerStaff> findAllCustomerStaffs();
    List<HangzhouCustomerStaff> findCustomerStaffsByUpdatedTime(Date updateTime);

    HangzhouCustomerStaff createCustomerStaff(HangzhouCustomerStaff customerStaff);
    HangzhouCustomerStaff updateCustomerStaff(HangzhouCustomerStaff customerStaff);
    HangzhouCustomerStaff deleteCustomerStaffById(Long id);
}
