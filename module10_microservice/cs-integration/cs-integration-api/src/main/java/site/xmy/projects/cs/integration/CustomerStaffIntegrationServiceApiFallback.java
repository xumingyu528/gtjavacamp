package site.xmy.projects.cs.integration;

import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;

import java.util.List;

public class CustomerStaffIntegrationServiceApiFallback implements CustomerStaffIntegrationServiceApi {
    @Override
    public List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystem) {
        return null;
    }
}
