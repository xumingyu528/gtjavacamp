package site.xmy.projects.cs.middleground.customer.integration;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import site.xmy.projects.cs.integration.domain.OutsourcingSystemDTO;
import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.middleground.customer.entity.staff.CustomerStaff;
import site.xmy.projects.cs.middleground.customer.entity.tenant.OutsourcingSystem;

import java.util.List;

@Mapper
public interface CustomerStaffIntegrationConverter {

    CustomerStaffIntegrationConverter INSTANCE = Mappers.getMapper(CustomerStaffIntegrationConverter.class);

    //Entity->DTO
    OutsourcingSystemDTO convertOutsourcingSystem(OutsourcingSystem entity);

    //DTO->Entity
    List<CustomerStaff> convertCustomerStaffListDTO(List<PlatformCustomerStaff> dtos);
}
