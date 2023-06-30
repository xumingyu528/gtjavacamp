package site.xmy.projects.cs.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;
import site.xmy.projects.cs.infrastructure.vo.Result;

import java.util.List;

@Component
public class OutsourcingSystemClient {

    @Autowired
    RestTemplate restTemplate;

    public List<CustomerStaff> getCustomerStaffs(OutsourcingSystem outsourcingSystem){
        ResponseEntity<Result> result = restTemplate.exchange(
                outsourcingSystem.getSystemUrl(),
                HttpMethod.GET,
                null,
                Result.class
        );

        List<CustomerStaff> customerStaffs = (List<CustomerStaff>) result.getBody().getData();
        return customerStaffs;
    }


}
