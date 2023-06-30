package site.xmy.projects.cs.rpc;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import site.xmy.projects.cs.customer.service.CustomerStaffSyncService;
import site.xmy.projects.cs.service.ICustomerStaffService;

@DubboService(version = "${customer.service.version}")
public class CustomerStaffSyncServiceImpl implements CustomerStaffSyncService {
    @Autowired
    ICustomerStaffService customerStaffService;

    @Override
    public void syncOutsourcingCustomerStaffsBySystemId(Long systemId) {
        customerStaffService.syncOutsourcingCustomerStaffsBySystemId(systemId);
    }
}
