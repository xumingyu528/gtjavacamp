package site.xmy.projects.cs.controller.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import site.xmy.projects.cs.entity.staff.CustomerStaff;

@RestController
@RequestMapping("/reactive/customerStaffs")
public class ReactiveCustomerStafferController {
    @Autowired
    StubCustomerStaffService stubCustomerStaffService;

    @PostMapping("/")
    public Mono<Void> addCS(@RequestBody CustomerStaff customerStaff){
        Mono<Void> result = stubCustomerStaffService.createOrUpdateCustomerStaff(Mono.just(customerStaff));
        return result;
    }

    @PutMapping("/")
    public Mono<Void> updateCS(@RequestBody CustomerStaff customerStaff){
        Mono<Void> result = stubCustomerStaffService.createOrUpdateCustomerStaff(Mono.just(customerStaff));
        return result;
    }

    @GetMapping("/{staffId}")
    public Mono<CustomerStaff> getById(@PathVariable("staffId") Long id){
        return stubCustomerStaffService.getCustomerStuffById(id);
    }

    @GetMapping("/")
    public Flux<CustomerStaff> get(){
        return stubCustomerStaffService.getCustomerStuffs();
    }

    @DeleteMapping("/{staffId}")
    public Mono<CustomerStaff> delete(@PathVariable("staffId") Long id){
        return stubCustomerStaffService.deleteCustomerStaffById(id);
    }

}
