package site.xmy.projects.cs.integration.servicebus.filter.impl;

import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.integration.servicebus.filter.AbstractCustomerStaffFilter;

import java.util.Objects;

public class CustomerStaffEmptyFilter extends AbstractCustomerStaffFilter {
    @Override
    public PlatformCustomerStaff execute(PlatformCustomerStaff customerStaff) {
        if (Objects.isNull(customerStaff.getStaffName()))
            return null;

        if (getNext() !=null)
            return getNext().execute(customerStaff);

        return customerStaff;
    }
}
