package site.xmy.projects.cs.integration.servicebus.filter;

import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;

public interface CustomerStaffFilter {
    PlatformCustomerStaff execute(PlatformCustomerStaff customerStaff);
    void setNext(CustomerStaffFilter filter);
    CustomerStaffFilter getNext();
    CustomerStaffFilter getLast();
}
