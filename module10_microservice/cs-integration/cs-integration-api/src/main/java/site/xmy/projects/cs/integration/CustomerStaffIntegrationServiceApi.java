package site.xmy.projects.cs.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import site.xmy.projects.cs.infrastructure.config.FeignConfiguration;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;

import java.util.List;

import static site.xmy.projects.cs.integration.ApiConstants.PREFIX;
import static site.xmy.projects.cs.integration.ApiConstants.SERVICE_NAME;

@FeignClient(value = SERVICE_NAME,path = PREFIX + "/staffs",
        fallbackFactory = CustomerStaffIntegrationServiceApiFallback.class,
        configuration = FeignConfiguration.class
)
public interface CustomerStaffIntegrationServiceApi {
    @RequestMapping(value = "/",method = RequestMethod.POST)
    List<PlatformCustomerStaff> fetchCustomerStaffs(@RequestBody OutsourcingSystemDTO outsourcingSystem);

}
