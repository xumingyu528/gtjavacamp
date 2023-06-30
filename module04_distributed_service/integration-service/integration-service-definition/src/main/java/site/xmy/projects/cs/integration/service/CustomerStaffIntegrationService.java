package site.xmy.projects.cs.integration.service;

import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;

import java.util.List;

public interface CustomerStaffIntegrationService {
    List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystemDTO);
}
