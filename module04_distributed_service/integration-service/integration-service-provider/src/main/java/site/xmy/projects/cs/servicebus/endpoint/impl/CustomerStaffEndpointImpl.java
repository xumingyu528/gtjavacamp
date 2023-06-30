package site.xmy.projects.cs.servicebus.endpoint.impl;

import org.springframework.stereotype.Service;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.servicebus.endpoint.CustomerStaffEndpoint;
import site.xmy.projects.cs.servicebus.filter.CustomerStaffFilter;
import site.xmy.projects.cs.servicebus.filter.CustomerStaffFilterChain;
import site.xmy.projects.cs.servicebus.filter.impl.CustomerStaffEmptyFilter;
import site.xmy.projects.cs.servicebus.filter.impl.CustomerStaffNameFilter;
import site.xmy.projects.cs.servicebus.router.OutsourcingSystemRouter;
import site.xmy.projects.cs.servicebus.router.OutsourcingSystemRouterFactory;
import site.xmy.projects.cs.servicebus.transformer.CustomerStaffTransformer;
import site.xmy.projects.cs.servicebus.transformer.CustomerStaffTransformerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerStaffEndpointImpl implements CustomerStaffEndpoint {

    private CustomerStaffFilterChain customerStaffFilterChain;

    public CustomerStaffEndpointImpl() {
        customerStaffFilterChain = new CustomerStaffFilterChain();
        customerStaffFilterChain.addFilter(new CustomerStaffEmptyFilter());
        customerStaffFilterChain.addFilter(new CustomerStaffNameFilter());
    }


    @Override
    public List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystem) {
        OutsourcingSystemRouter outsourcingSystemRouter = OutsourcingSystemRouterFactory.createOutsourcingSystemRouter(outsourcingSystem);
        List<OutsourcingSystemDTO> outsourcingSystems = outsourcingSystemRouter.fetchOutsourcingCustomerStaffs(outsourcingSystem.getSystemUrl());
        CustomerStaffTransformer transformer = CustomerStaffTransformerFactory.createCustomerStaffTransformer(outsourcingSystem);
        List<PlatformCustomerStaff> customerStaffs = transformer.transformerCustomerStaffs(outsourcingSystems);
        List<PlatformCustomerStaff> finalCustomerStaffs = new ArrayList<>();
        customerStaffs.forEach(staff -> {
            PlatformCustomerStaff filteredCustomerStaff = customerStaffFilterChain.execute(staff);
            if (filteredCustomerStaff != null)
                finalCustomerStaffs.add(filteredCustomerStaff);
        });

        return finalCustomerStaffs;
    }
}
