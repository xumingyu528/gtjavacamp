package site.xmy.projects.cs.middleground.customer.service;

import site.xmy.projects.cs.middleground.customer.entity.tenant.OutsourcingSystem;
import site.xmy.projects.cs.infrastructure.page.PageObject;

import java.util.List;

public interface IOutsourcingSystemService {
    List<OutsourcingSystem> findAllOutsourcingSystems();
    PageObject<OutsourcingSystem> findPagedOutsourcingSystems(Long pageSize,Long pageIndex);
    OutsourcingSystem findOutsourcingSystemById(Long systemId);
    Boolean addOutsourcingSystem(OutsourcingSystem outsourcingSystem);
    Boolean updateOutsourcingSystem(OutsourcingSystem outsourcingSystem);
    Boolean deleteOutsourcingSystemById(Long systemId);
}
