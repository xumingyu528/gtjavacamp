package site.xmy.projects.cs.servicebus.endpoint;

import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;

import java.util.List;

public interface CustomerStaffEndpoint {
    List<CustomerStaff> fetchCustomerStaffs(OutsourcingSystem outsourcingSystem);
}
