package site.xmy.projects.cs.converter;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import site.xmy.projects.cs.controller.vo.req.AddOutsourcingSystemReqVO;
import site.xmy.projects.cs.controller.vo.resp.OutsourcingSystemRespVO;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;

import java.util.List;

@Mapper
public interface OutsourcingSystemConverter {

    OutsourcingSystemConverter INSTANCE = Mappers.getMapper(OutsourcingSystemConverter.class);

    //VO->Entity
    OutsourcingSystem convertCreateReq(AddOutsourcingSystemReqVO addOutsourcingSystemReqVO);

    //Entity->VO
    OutsourcingSystemRespVO convertResp(OutsourcingSystem outsourcingSystem);
    List<OutsourcingSystemRespVO> convertListResp(List<OutsourcingSystem> outsourcingSystems);

}
