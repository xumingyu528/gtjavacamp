package site.xmy.projects.cs.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.context.annotation.Configuration;
import site.xmy.projects.cs.mapper.CustomerStaffMapper;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Endpoint(id = "customerStaffCount",enableByDefault = true)
public class CustomerStaffCountEndpoint {

    @Autowired
    private CustomerStaffMapper customerStaffMapper;

    @ReadOperation
    public Map<String,Object> countCustomerStaffs(){
        Map<String,Object> result = new HashMap<>();
        result.put("count: ",customerStaffMapper.countCustomerStaffs());
        return result;
    }
}
