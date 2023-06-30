package site.xmy.projects.cs.servicebus.transformer;

import site.xmy.projects.cs.entity.staff.CustomerStaff;

import java.util.List;

public interface CustomerStaffTransformer<T> {
    List<CustomerStaff> transformerCustomerStaffs(List<T> customerStaffs);
}
