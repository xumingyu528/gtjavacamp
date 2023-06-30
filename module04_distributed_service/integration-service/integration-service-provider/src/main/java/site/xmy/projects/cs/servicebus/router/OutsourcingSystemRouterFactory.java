package site.xmy.projects.cs.servicebus.router;


import org.springframework.stereotype.Component;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.servicebus.router.beijing.BeijingOutsourcingSystemRouter;
import site.xmy.projects.cs.servicebus.router.hangzhou.HangzhouOutsourcingSystemRouter;
import site.xmy.projects.cs.servicebus.router.shanghai.ShanghaiOutsourcingSystemRouter;

@Component
public class OutsourcingSystemRouterFactory {

    private static final String OUTSOURCING_SYSTEM_BEIJING = "beijing";
    private static final String OUTSOURCING_SYSTEM_SHANGHAI = "shanghai";
    private static final String OUTSOURCING_SYSTEM_HANGZHOU = "hangzhou";
    public static OutsourcingSystemRouter createOutsourcingSystemRouter(OutsourcingSystemDTO outsourcingSystem){

        if (outsourcingSystem.getSystemCode().equals(OUTSOURCING_SYSTEM_BEIJING)){
            return new BeijingOutsourcingSystemRouter();
        }else if(outsourcingSystem.getSystemCode().equals(OUTSOURCING_SYSTEM_SHANGHAI)){
            return new ShanghaiOutsourcingSystemRouter();
        }else if(outsourcingSystem.getSystemCode().equals(OUTSOURCING_SYSTEM_HANGZHOU)){
            return new HangzhouOutsourcingSystemRouter();
        }
        return null;
    }
}
