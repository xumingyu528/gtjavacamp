package site.xmy.projects.cs.servicebus.transformer;

import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;
import site.xmy.projects.cs.servicebus.router.OutsourcingSystemRouter;
import site.xmy.projects.cs.servicebus.router.beijing.BeijingOutsourcingSystemRouter;
import site.xmy.projects.cs.servicebus.router.hangzhou.HangzhouOutsourcingSystemRouter;
import site.xmy.projects.cs.servicebus.router.shanghai.ShanghaiOutsourcingSystemRouter;
import site.xmy.projects.cs.servicebus.transformer.beijing.BeijingCustomerStaffTransformer;
import site.xmy.projects.cs.servicebus.transformer.hangzhou.HangzhouCustomerStaffTransformer;
import site.xmy.projects.cs.servicebus.transformer.shanghai.ShanghaiCustomerStaffTransformer;

public class CustomerStaffTransformerFactory {

    private static final String OUTSOURCING_SYSTEM_BEIJING = "beijing";
    private static final String OUTSOURCING_SYSTEM_SHANGHAI = "shanghai";
    private static final String OUTSOURCING_SYSTEM_HANGZHOU = "hangzhou";
    public static CustomerStaffTransformer createCustomerStaffTransformer(OutsourcingSystem outsourcingSystem){

        if (outsourcingSystem.getSystemCode().equals(OUTSOURCING_SYSTEM_BEIJING)){
            return new BeijingCustomerStaffTransformer();
        }else if(outsourcingSystem.getSystemCode().equals(OUTSOURCING_SYSTEM_SHANGHAI)){
            return new ShanghaiCustomerStaffTransformer();
        }else if(outsourcingSystem.getSystemCode().equals(OUTSOURCING_SYSTEM_HANGZHOU)){
            return new HangzhouCustomerStaffTransformer();
        }
        return null;
    }
}
