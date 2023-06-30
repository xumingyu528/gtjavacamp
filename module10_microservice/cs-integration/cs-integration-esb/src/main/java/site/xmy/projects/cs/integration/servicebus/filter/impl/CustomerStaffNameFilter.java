package site.xmy.projects.cs.integration.servicebus.filter.impl;

import site.xmy.projects.cs.integration.domain.PlatformCustomerStaff;
import site.xmy.projects.cs.integration.servicebus.filter.AbstractCustomerStaffFilter;

import java.util.ArrayList;
import java.util.List;

public class CustomerStaffNameFilter extends AbstractCustomerStaffFilter {


    @Override
    public PlatformCustomerStaff execute(PlatformCustomerStaff customerStaff) {
        List<String> sensitiveWords = new ArrayList<>();
        sensitiveWords.add("tianyalan");

        if (!sensitiveWords.isEmpty()) {
            for (String sensitiveWord : sensitiveWords) {
                if (customerStaff.getStaffName().indexOf(sensitiveWord) == -1) {
                    continue;
                } else {
                    customerStaff.setStaffName("***");
                }
            }
        }

        return customerStaff;
    }
}
