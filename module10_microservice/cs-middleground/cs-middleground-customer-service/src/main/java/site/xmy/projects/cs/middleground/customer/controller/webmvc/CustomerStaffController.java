package site.xmy.projects.cs.middleground.customer.controller.webmvc;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;
import site.xmy.projects.cs.middleground.customer.controller.vo.req.AddCustomerStaffReqVO;
import site.xmy.projects.cs.middleground.customer.controller.vo.req.UpdateCustomerStaffReqVO;
import site.xmy.projects.cs.middleground.customer.controller.vo.resp.CustomerStaffRespVO;
import site.xmy.projects.cs.middleground.customer.converter.CustomerStaffConverter;
import site.xmy.projects.cs.middleground.customer.entity.staff.CustomerStaff;
import site.xmy.projects.cs.infrastructure.page.PageObject;
import site.xmy.projects.cs.infrastructure.vo.Result;
import site.xmy.projects.cs.middleground.customer.service.ICustomerStaffService;

import java.util.List;

@RestController
@RequestMapping("/customerStaffs")
public class CustomerStaffController {
    @Autowired
    ICustomerStaffService customerStaffService;


    @PostMapping("/")
    public Result<Long> addCustomerStaff(@RequestBody AddCustomerStaffReqVO addCustomerStaffReqVO) {
        //数据转换
        CustomerStaff customerStaff = CustomerStaffConverter.INSTANCE.convertCreateReq(addCustomerStaffReqVO);




        //调用Service层完成操作
        customerStaffService.createCustomerStaff(customerStaff);

        return Result.success(customerStaff.getId());
    }

    @PutMapping("/")
    public Result<Boolean> updateCustomerStaff(@RequestBody UpdateCustomerStaffReqVO updateCustomerStaffReqVO) {

        CustomerStaff customerStaff = CustomerStaffConverter.INSTANCE.convertUpdateReq(updateCustomerStaffReqVO);

        Boolean isUpdated = customerStaffService.updateCustomerStaff(customerStaff);

        return Result.success(isUpdated);
    }

    @PutMapping("/status")
    public Result<Boolean> updateCustomerStaffStatus(@RequestBody UpdateCustomerStaffReqVO updateCustomerStaffReqVO) {

        CustomerStaff customerStaff = CustomerStaffConverter.INSTANCE.convertUpdateReq(updateCustomerStaffReqVO);

        Boolean isUpdated = customerStaffService.updateCustomerStaff(customerStaff);

        return Result.success(isUpdated);
    }

    @GetMapping("/{staffId}")
    public Result<CustomerStaffRespVO> findCustomerStaffById(@PathVariable("staffId") Long staffId) {

        CustomerStaff customerStaff = customerStaffService.findCustomerStaffById(staffId);

        CustomerStaffRespVO customerStaffRespVO = CustomerStaffConverter.INSTANCE.convertResp(customerStaff);

        return Result.success(customerStaffRespVO);
    }

    @GetMapping("/page/{pageSize}/{pageIndex}")
    public Result<PageObject<CustomerStaffRespVO>> findCustomerStaffs(@PathVariable("pageSize") Long pageSize, @PathVariable("pageIndex") Long pageIndex) {

        PageObject<CustomerStaff> pagedCustomerStaff = customerStaffService.findCustomerStaffs(pageSize, pageIndex);

        List<CustomerStaffRespVO> customerStaffRespVOs = CustomerStaffConverter.INSTANCE.convertListResp(pagedCustomerStaff.getList());

        PageObject<CustomerStaffRespVO> result = new PageObject<CustomerStaffRespVO>()
                .setList(customerStaffRespVOs)
                .setTotal(pagedCustomerStaff.getTotal())
                .setPageIndex(pagedCustomerStaff.getPageIndex())
                .setPageSize(pagedCustomerStaff.getPageSize());

        return Result.success(result);
    }

    @DeleteMapping("/{staffId}")
    public Result<Boolean> deleteCustomerStaffById(@PathVariable("staffId") Long staffId) {

        Boolean isDeleted = customerStaffService.deleteCustomerStaffById(staffId);

        return Result.success(isDeleted);
    }

    @GetMapping("/async/{staffId}")
    public WebAsyncTask<CustomerStaffRespVO> asyncFindCustomerStaffById(@PathVariable("staffId") Long staffId) {
        System.out.println("The main Thread name is " + Thread.currentThread().getName());

        //启动异步任务
        WebAsyncTask<CustomerStaffRespVO> task = new WebAsyncTask<CustomerStaffRespVO>(5 * 1000L, () -> {
            System.out.println("The working Thread name is " + Thread.currentThread().getName());
            CustomerStaff customerStaff = customerStaffService.findCustomerStaffById(staffId);

            CustomerStaffRespVO customerStaffRespVO = CustomerStaffConverter.INSTANCE.convertResp(customerStaff);

            Thread.sleep(10*1000L);
            return customerStaffRespVO;
        });

        // 任务超时，添加类似熔断效果
        task.onTimeout( () -> {

            System.out.println(Thread.currentThread().getName() + " execute Timeout ...");
            return new CustomerStaffRespVO();
        });

        // 任务完成
        task.onCompletion( () -> {
            System.out.println(Thread.currentThread().getName() + " executed Complete !");
        });

        // 任务出错
        task.onError( () -> {
            System.out.println(Thread.currentThread().getName() + " execute Error ...");
            return new CustomerStaffRespVO();
        });

        // 模拟异步过程其它代码执行过程
        System.out.println("异步任务请求已提交，继续执行其它代码中 ...");

        return task;
    }


    @GetMapping("/phone/{phoneNum}")
    public Result<CustomerStaffRespVO> getCustomerByPhone(@PathVariable("phoneNum") String phoneNum){


        PageObject<CustomerStaff> pageObjectByPhone = customerStaffService.findCustomerStaffByPhone(phoneNum);

        return Result.success(pageObjectByPhone);
    }



    @GetMapping("/sync/{systemId}")
    public Result<Boolean> syncOutsourcingCustomerStaffsBySystemId(@PathVariable("systemId") Long systemId) {
        customerStaffService.syncOutsourcingCustomerStaffsBySystemId(systemId);

        return Result.success(true);
    }

}
