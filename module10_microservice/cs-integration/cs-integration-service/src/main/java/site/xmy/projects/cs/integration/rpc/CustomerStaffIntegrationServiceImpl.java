package site.xmy.projects.cs.integration.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.integration.servicebus.endpoint.CustomerStaffEndpoint;

import java.util.List;

@RestController
@RequestMapping("/api/integration/staffs")
public class CustomerStaffIntegrationServiceImpl {
    @Autowired
    CustomerStaffEndpoint customerStaffEndpoint;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public List<PlatformCustomerStaff> fetchCustomerStaffs(@RequestBody OutsourcingSystemDTO outsourcingSystemDTO) {
        return customerStaffEndpoint.fetchCustomerStaffs(outsourcingSystemDTO);
    }
}
