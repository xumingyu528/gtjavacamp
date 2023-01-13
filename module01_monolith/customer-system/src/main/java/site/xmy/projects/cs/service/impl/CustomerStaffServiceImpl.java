package site.xmy.projects.cs.service.impl;

import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.infrastructure.exception.BizException;
import site.xmy.projects.cs.infrastructure.page.PageObject;
import site.xmy.projects.cs.service.ICustomerStaffService;

public class CustomerStaffServiceImpl implements ICustomerStaffService {
    @Override
    public PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex) {
        return null;
    }

    @Override
    public PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex) {
        return null;
    }

    @Override
    public CustomerStaff findCustomerStaffById(Long staffId) {
        return null;
    }

    @Override
    public Boolean createCustomerStaff(CustomerStaff customerStaff) throws BizException {
        return null;
    }

    @Override
    public Boolean updateCustomerStaff(CustomerStaff customerStaff) {
        return null;
    }

    @Override
    public Boolean deleteCustomerStaffById(Long staffId) {
        return null;
    }
}
