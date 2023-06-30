package site.xmy.projects.cs.middleground.customer.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.xmy.projects.cs.integration.CustomerStaffIntegrationServiceApi;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.middleground.customer.entity.staff.CustomerStaff;
import site.xmy.projects.cs.middleground.customer.entity.tenant.OutsourcingSystem;

import java.util.List;

@Component
public class CustomerStaffIntegrationClient {
    @Autowired
    CustomerStaffIntegrationServiceApi customerStaffIntegrationServiceApi;

    public List<CustomerStaff> getCustomerStaffs(OutsourcingSystem outsourcingSystem){
        OutsourcingSystemDTO outsourcingSystemDTO = CustomerStaffIntegrationConverter.INSTANCE.convertOutsourcingSystem(outsourcingSystem);

        List<PlatformCustomerStaff> platformCustomerStaffs = customerStaffIntegrationServiceApi.fetchCustomerStaffs(outsourcingSystemDTO);

        return CustomerStaffIntegrationConverter.INSTANCE.convertCustomerStaffListDTO(platformCustomerStaffs);
    }
}
