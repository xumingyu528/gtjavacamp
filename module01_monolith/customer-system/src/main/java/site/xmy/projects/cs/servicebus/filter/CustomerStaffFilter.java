package site.xmy.projects.cs.servicebus.filter;

import site.xmy.projects.cs.entity.staff.CustomerStaff;

public interface CustomerStaffFilter {
    CustomerStaff execute(CustomerStaff customerStaff);
    void setNext(CustomerStaffFilter filter);
    CustomerStaffFilter getNext();
    CustomerStaffFilter getLast();
}
