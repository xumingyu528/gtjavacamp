package site.xmy.projects.cs.converter;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import site.xmy.projects.cs.controller.vo.req.AddCustomerStaffReqVO;
import site.xmy.projects.cs.controller.vo.req.UpdateCustomerStaffReqVO;
import site.xmy.projects.cs.controller.vo.resp.CustomerStaffRespVO;
import site.xmy.projects.cs.entity.staff.CustomerStaff;

import java.util.List;

@Mapper
public interface CustomerStaffConverter {

    CustomerStaffConverter INSTANCE = Mappers.getMapper(CustomerStaffConverter.class);

    //VO->Entity
    CustomerStaff convertCreateReq(AddCustomerStaffReqVO addCustomerStaffReqVO);
    CustomerStaff convertUpdateReq(UpdateCustomerStaffReqVO updateCustomerStaffReqVO);

    //Entity->VO
    CustomerStaffRespVO convertResp(CustomerStaff customerStaff);
    List<CustomerStaffRespVO> convertListResp(List<CustomerStaff> customerStaffs);

}
