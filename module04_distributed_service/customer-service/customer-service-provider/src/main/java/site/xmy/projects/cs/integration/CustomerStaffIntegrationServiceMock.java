package site.xmy.projects.cs.integration;

import org.springframework.stereotype.Component;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.integration.service.CustomerStaffIntegrationService;

import java.util.List;

@Component
public class CustomerStaffIntegrationServiceMock implements CustomerStaffIntegrationService {

    @Override
    public List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystemDTO) {
        return null;
    }
}