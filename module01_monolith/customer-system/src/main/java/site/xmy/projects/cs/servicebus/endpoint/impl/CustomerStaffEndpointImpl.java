package site.xmy.projects.cs.servicebus.endpoint.impl;

import org.springframework.stereotype.Service;
import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;
import site.xmy.projects.cs.servicebus.endpoint.CustomerStaffEndpoint;
import site.xmy.projects.cs.servicebus.filter.CustomerStaffFilterChain;
import site.xmy.projects.cs.servicebus.filter.impl.CustomerStaffEmptyFilter;
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
    }


    @Override
    public List<CustomerStaff> fetchCustomerStaffs(OutsourcingSystem outsourcingSystem) {
        OutsourcingSystemRouter outsourcingSystemRouter = OutsourcingSystemRouterFactory.createOutsourcingSystemRouter(outsourcingSystem);
        List<OutsourcingSystem> outsourcingSystems = outsourcingSystemRouter.fetchOutsourcingCustomerStaffs(outsourcingSystem.getSystemUrl());
        CustomerStaffTransformer transformer = CustomerStaffTransformerFactory.createCustomerStaffTransformer(outsourcingSystem);
        List<CustomerStaff> customerStaffs = transformer.transformerCustomerStaffs(outsourcingSystems);
        List<CustomerStaff> finalCustomerStaffs = new ArrayList<>();
        customerStaffs.forEach(staff -> {
            CustomerStaff filteredCustomerStaff = customerStaffFilterChain.execute(staff);
            if (filteredCustomerStaff != null)
                finalCustomerStaffs.add(filteredCustomerStaff);
        });

        return finalCustomerStaffs;
    }
}
