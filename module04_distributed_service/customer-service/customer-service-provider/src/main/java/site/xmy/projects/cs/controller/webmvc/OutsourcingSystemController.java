package site.xmy.projects.cs.controller.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.xmy.projects.cs.controller.vo.req.AddCustomerStaffReqVO;
import site.xmy.projects.cs.controller.vo.req.AddOutsourcingSystemReqVO;
import site.xmy.projects.cs.controller.vo.req.UpdateCustomerStaffReqVO;
import site.xmy.projects.cs.controller.vo.resp.CustomerStaffRespVO;
import site.xmy.projects.cs.controller.vo.resp.OutsourcingSystemRespVO;
import site.xmy.projects.cs.converter.CustomerStaffConverter;
import site.xmy.projects.cs.converter.OutsourcingSystemConverter;
import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;
import site.xmy.projects.cs.infrastructure.page.PageObject;
import site.xmy.projects.cs.infrastructure.vo.Result;
import site.xmy.projects.cs.service.IOutsourcingSystemService;

import java.util.List;

@RestController
@RequestMapping("/outsourcingSystems")
public class OutsourcingSystemController {
    @Autowired
    IOutsourcingSystemService outsourcingSystemService;


    @PostMapping("/")
    public Result<Long> addOutsourcingSystem(@RequestBody AddOutsourcingSystemReqVO addOutsourcingSystemReqVO) {

        OutsourcingSystem outsourcingSystem = OutsourcingSystemConverter.INSTANCE.convertCreateReq(addOutsourcingSystemReqVO);

        //调用Service层完成操作
        outsourcingSystemService.addOutsourcingSystem(outsourcingSystem);

        return Result.success(outsourcingSystem.getId());
    }


    @GetMapping("/{systemId}")
    public Result<OutsourcingSystemRespVO> findOutsourcingSystemById(@PathVariable("systemId") Long systemId) {

        OutsourcingSystem outsourcingSystem = outsourcingSystemService.findOutsourcingSystemById(systemId);

        OutsourcingSystemRespVO outsourcingSystemRespVO = OutsourcingSystemConverter.INSTANCE.convertResp(outsourcingSystem);

        return Result.success(outsourcingSystemRespVO);
    }

    @GetMapping("/page/{pageSize}/{pageIndex}")
    public Result<PageObject<OutsourcingSystemRespVO>> findOutsourcingSystems(@PathVariable("pageSize") Long pageSize, @PathVariable("pageIndex") Long pageIndex) {

        PageObject<OutsourcingSystem> pagedOutsourcingSystem = outsourcingSystemService.findPagedOutsourcingSystems(pageSize, pageIndex);

        List<OutsourcingSystemRespVO> outsourcingSystemRespVOs = OutsourcingSystemConverter.INSTANCE.convertListResp(pagedOutsourcingSystem.getList());

        PageObject<OutsourcingSystemRespVO> result = new PageObject<OutsourcingSystemRespVO>()
                .setList(outsourcingSystemRespVOs)
                .setTotal(pagedOutsourcingSystem.getTotal())
                .setPageIndex(pagedOutsourcingSystem.getPageIndex())
                .setPageSize(pagedOutsourcingSystem.getPageSize());

        return Result.success(result);
    }

    @DeleteMapping("/{systemId}")
    public Result<Boolean> deleteOutsourcingSystemById(@PathVariable("systemId") Long systemId) {

        Boolean isDeleted = outsourcingSystemService.deleteOutsourcingSystemById(systemId);

        return Result.success(isDeleted);
    }


}
