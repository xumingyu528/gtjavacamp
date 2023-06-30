package site.xmy.projects.cs.integration.servicebus.router.hangzhou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import site.xmy.projects.cs.infrastructure.vo.Result;
import site.xmy.projects.cs.integration.servicebus.router.OutsourcingSystemRouter;
import site.xmy.projects.cs.integration.servicebus.router.hangzhou.dto.HangzhouCustomerStaff;

import java.util.List;

@Component
public class HangzhouOutsourcingSystemRouter implements OutsourcingSystemRouter {
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<HangzhouCustomerStaff> fetchOutsourcingCustomerStaffs(String systemUrl) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Result> result = restTemplate.exchange(
                systemUrl,
                HttpMethod.GET,
                null,
                Result.class
        );
        List<HangzhouCustomerStaff> hangzhouCustomerStaff = (List<HangzhouCustomerStaff>) result.getBody().getData();
        return hangzhouCustomerStaff;
    }
}
