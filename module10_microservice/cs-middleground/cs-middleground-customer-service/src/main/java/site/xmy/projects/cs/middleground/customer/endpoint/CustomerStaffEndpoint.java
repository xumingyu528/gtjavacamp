package site.xmy.projects.cs.middleground.customer.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.context.annotation.Configuration;
import site.xmy.projects.cs.middleground.customer.mapper.CustomerStaffMapper;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Endpoint(id = "customerStaff",enableByDefault = true)
public class CustomerStaffEndpoint {

    @Autowired
    private CustomerStaffMapper customerStaffMapper;

//    @ReadOperation(produces = "application/json; charset=utf-8")
    @ReadOperation
    public Map<String,Object> getCustomerStaffByPhone(@Selector String arg0 ){
        Map<String,Object> result = new HashMap<>();
        result.put(arg0,customerStaffMapper.findCustomerStaffByPhone(arg0));
        return result;
    }
}
