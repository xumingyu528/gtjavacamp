package site.xmy.projects.cs.rpc;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.integration.service.CustomerStaffIntegrationService;
import site.xmy.projects.cs.servicebus.endpoint.CustomerStaffEndpoint;

import java.util.List;

@DubboService(version = "${integration.service.version}")
public class CustomerStaffIntegrationServiceImpl implements CustomerStaffIntegrationService {
    @Autowired
    CustomerStaffEndpoint customerStaffEndpoint;

    @Override
    public List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystemDTO) {
        return customerStaffEndpoint.fetchCustomerStaffs(outsourcingSystemDTO);
    }
}
