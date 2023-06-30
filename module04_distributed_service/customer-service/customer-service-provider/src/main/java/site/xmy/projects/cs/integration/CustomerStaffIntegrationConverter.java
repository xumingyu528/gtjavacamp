package site.xmy.projects.cs.integration;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;

import java.util.List;

@Mapper
public interface CustomerStaffIntegrationConverter {
    CustomerStaffIntegrationConverter INSTANCE = Mappers.getMapper(CustomerStaffIntegrationConverter.class);

    //Entity->DTO
    OutsourcingSystemDTO convertOutsourcingSystem(OutsourcingSystem entity);

    //DTO->Entity
    List<CustomerStaff> convertCustomerStaffListDTO(List<PlatformCustomerStaff> dtos);
}
