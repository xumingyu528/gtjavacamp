package site.xmy.projects.cs.servicebus.endpoint;

import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;

import java.util.List;

public interface CustomerStaffEndpoint {
    List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystem);
}
