package site.xmy.projects.cs.service;

import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.infrastructure.exception.BizException;
import site.xmy.projects.cs.infrastructure.page.PageObject;

import java.util.List;


public interface ICustomerStaffService {

    PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex);

    List<CustomerStaff> findCustomerStaffs();

    PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex);

    CustomerStaff findCustomerStaffById(Long staffId);

    PageObject<CustomerStaff> findCustomerStaffByPhone(String phoneNum);

    Boolean createCustomerStaff(CustomerStaff customerStaff) throws BizException;

    Boolean updateCustomerStaff(CustomerStaff customerStaff);

    Boolean deleteCustomerStaffById(Long staffId);

    //获取外部客服系统人员信息
    void syncOutsourcingCustomerStaffsBySystemId(Long systemId);
}
