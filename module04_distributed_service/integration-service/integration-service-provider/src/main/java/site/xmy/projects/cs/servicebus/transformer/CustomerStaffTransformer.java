package site.xmy.projects.cs.servicebus.transformer;

import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;

import java.util.List;

public interface CustomerStaffTransformer<T> {
    List<PlatformCustomerStaff> transformerCustomerStaffs(List<T> customerStaffs);
}
