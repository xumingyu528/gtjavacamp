package site.xmy.hangzhou.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import site.xmy.hangzhou.controller.vo.req.HangzhouCustomerStaffAddReqVO;
import site.xmy.hangzhou.controller.vo.req.HangzhouCustomerStaffUpdateReqVO;
import site.xmy.hangzhou.controller.vo.resp.HangzhouCustomerStaffRespVO;
import site.xmy.hangzhou.entity.HangzhouCustomerStaff;

import java.util.List;

@Mapper
public interface HangzhouCustomerStaffConverter {

    HangzhouCustomerStaffConverter INSTANCE = Mappers.getMapper(HangzhouCustomerStaffConverter.class);

    List<HangzhouCustomerStaffRespVO> convertListResp(List<HangzhouCustomerStaff> list);
    HangzhouCustomerStaffRespVO convertResp(HangzhouCustomerStaff entity);

    HangzhouCustomerStaff convertCreateReq(HangzhouCustomerStaffAddReqVO vo);
    HangzhouCustomerStaff convertUpdateReq(HangzhouCustomerStaffUpdateReqVO vo);


}
