package site.xmy.projects.cs.servicebus.filter.impl;

import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.servicebus.filter.AbstractCustomerStaffFilter;

import java.util.Objects;

public class CustomerStaffEmptyFilter extends AbstractCustomerStaffFilter {
    @Override
    public CustomerStaff execute(CustomerStaff customerStaff) {
        if (Objects.isNull(customerStaff.getStaffName()))
            return null;

        if (getNext() !=null)
            return getNext().execute(customerStaff);

        return customerStaff;
    }
}
