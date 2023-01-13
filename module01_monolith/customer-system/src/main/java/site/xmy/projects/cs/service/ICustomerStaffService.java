package site.xmy.projects.cs.service;

import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.infrastructure.exception.BizException;
import site.xmy.projects.cs.infrastructure.page.PageObject;

import java.util.List;

public interface ICustomerStaffService {

    PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex);

    PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex);

    CustomerStaff findCustomerStaffById(Long staffId);

    Boolean createCustomerStaff(CustomerStaff customerStaff) throws BizException;

    Boolean updateCustomerStaff(CustomerStaff customerStaff);

    Boolean deleteCustomerStaffById(Long staffId);
}
