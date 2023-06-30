package site.xmy.projects.cs.integration;


import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.integration.service.CustomerStaffIntegrationService;

import java.util.List;

@Component
public class CustomerStaffIntegrationClient {

    @DubboReference(version = "${integration.service.version}", timeout = 5000, loadbalance = "roundrobin", retries = 2,
            mock = "site.xmy.projects.cs.integration.CustomerStaffIntegrationServiceMock")
    private CustomerStaffIntegrationService customerStaffIntegrationService;

    public List<CustomerStaff> getCustomerStaffs(OutsourcingSystem outsourcingSystem){

        OutsourcingSystemDTO outsourcingSystemDTO = CustomerStaffIntegrationConverter.INSTANCE.convertOutsourcingSystem(outsourcingSystem);

        List<PlatformCustomerStaff> platformCustomerStaffs =customerStaffIntegrationService.fetchCustomerStaffs(outsourcingSystemDTO);

        return CustomerStaffIntegrationConverter.INSTANCE.convertCustomerStaffListDTO(platformCustomerStaffs);

    }
}
