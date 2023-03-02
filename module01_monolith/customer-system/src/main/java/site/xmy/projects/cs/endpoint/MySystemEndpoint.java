package site.xmy.projects.cs.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Endpoint(id = "mysystem",enableByDefault = true)
public class MySystemEndpoint {

    @ReadOperation
    public Map<String,Object> getMySystemInfo(){
        Map<String,Object> result = new HashMap<>();
        Map<String,String> sysenv = System.getenv();
        result.put("username",sysenv.get("USERNAME"));
        result.put("computername",sysenv.get("COMPUTERNAME"));
        return result;
    }
}
