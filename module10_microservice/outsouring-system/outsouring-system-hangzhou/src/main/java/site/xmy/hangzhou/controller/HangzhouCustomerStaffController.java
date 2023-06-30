package site.xmy.hangzhou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.xmy.hangzhou.controller.vo.req.HangzhouCustomerStaffAddReqVO;
import site.xmy.hangzhou.controller.vo.req.HangzhouCustomerStaffUpdateReqVO;
import site.xmy.hangzhou.controller.vo.resp.HangzhouCustomerStaffRespVO;
import site.xmy.hangzhou.converter.HangzhouCustomerStaffConverter;
import site.xmy.hangzhou.entity.HangzhouCustomerStaff;
import site.xmy.hangzhou.service.HangzhouCustomerStaffService;
import site.xmy.projects.cs.infrastructure.vo.Result;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customerStaffs/hangzhou/")
public class HangzhouCustomerStaffController {

    @Autowired
    private HangzhouCustomerStaffService hangzhouCustomerStaffService;

    //查询
//    @GetMapping("/")
//    public List<HangzhouCustomerStaffRespVO> listAll(){
//        return HangzhouCustomerStaffConverter.INSTANCE.convertListResp(hangzhouCustomerStaffService.findAllCustomerStaffs());
//    }
//
    @GetMapping("/")
    public Result<HangzhouCustomerStaffRespVO> listAll(){
        return Result.success(HangzhouCustomerStaffConverter.INSTANCE.convertListResp(hangzhouCustomerStaffService.findAllCustomerStaffs()));
    }

    @GetMapping("/updated")
    public List<HangzhouCustomerStaffRespVO> listById(@RequestParam ("updatedTime") Long updatedTime){
        return HangzhouCustomerStaffConverter.INSTANCE.convertListResp(hangzhouCustomerStaffService.findCustomerStaffsByUpdatedTime(new Date(updatedTime)));
    }

    //新增
    @PostMapping("/")
    public HangzhouCustomerStaff add(@RequestBody HangzhouCustomerStaffAddReqVO customerStaffAddReqVO){
        HangzhouCustomerStaff customerStaff = HangzhouCustomerStaffConverter.INSTANCE.convertCreateReq(customerStaffAddReqVO);
        return hangzhouCustomerStaffService.createCustomerStaff(customerStaff);
    }


    //更新
    @PutMapping("/")
    public HangzhouCustomerStaff update(@RequestBody HangzhouCustomerStaffUpdateReqVO customerStaffUpdateReqVO){
        HangzhouCustomerStaff customerStaff = HangzhouCustomerStaffConverter.INSTANCE.convertUpdateReq(customerStaffUpdateReqVO);
        return hangzhouCustomerStaffService.updateCustomerStaff(customerStaff);
    }


    //删除
    @DeleteMapping("/")
    public HangzhouCustomerStaff deleteCustomerById(@RequestParam ("id") Long id){
        return hangzhouCustomerStaffService.deleteCustomerStaffById(id);
    }
}
