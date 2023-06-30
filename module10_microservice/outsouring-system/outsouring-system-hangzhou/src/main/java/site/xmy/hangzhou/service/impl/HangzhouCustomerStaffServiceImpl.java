package site.xmy.hangzhou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.xmy.hangzhou.entity.HangzhouCustomerStaff;
import site.xmy.hangzhou.repository.HangzhouCustomerStaffRepository;
import site.xmy.hangzhou.service.HangzhouCustomerStaffService;

import java.util.Date;
import java.util.List;

@Service
public class HangzhouCustomerStaffServiceImpl implements HangzhouCustomerStaffService {

    @Autowired
    HangzhouCustomerStaffRepository customerStaffRepository;

    @Override
    public List<HangzhouCustomerStaff> findAllCustomerStaffs() {
        return customerStaffRepository.findByIsDeletedFalse();
    }

    @Override
    public List<HangzhouCustomerStaff> findCustomerStaffsByUpdatedTime(Date updateAt) {
        return customerStaffRepository.findByUpdatedAtAfter(updateAt);
    }

    @Override
    public HangzhouCustomerStaff createCustomerStaff(HangzhouCustomerStaff customerStaff) {
        customerStaff.setIsDeleted(false);
        return customerStaffRepository.save(customerStaff);
    }

    @Override
    public HangzhouCustomerStaff updateCustomerStaff(HangzhouCustomerStaff customerStaff) {
        HangzhouCustomerStaff preCustomerStaff = customerStaffRepository.getById(customerStaff.getId());
        customerStaff.setCreatedAt(preCustomerStaff.getCreatedAt());
        customerStaff.setIsDeleted(preCustomerStaff.getIsDeleted());
        return customerStaffRepository.save(customerStaff);
    }

    @Override
    public HangzhouCustomerStaff deleteCustomerStaffById(Long id) {
        HangzhouCustomerStaff customerStaff = customerStaffRepository.getById(id).setIsDeleted(true);

        return customerStaffRepository.save(customerStaff);
    }
}
