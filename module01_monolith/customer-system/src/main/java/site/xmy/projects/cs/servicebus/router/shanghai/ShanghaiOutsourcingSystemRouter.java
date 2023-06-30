package site.xmy.projects.cs.servicebus.router.shanghai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import site.xmy.projects.cs.servicebus.router.OutsourcingSystemRouter;

import java.util.List;

public class ShanghaiOutsourcingSystemRouter implements OutsourcingSystemRouter {
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List fetchOutsourcingCustomerStaffs(String systemUrl) {
        return null;
    }
}
