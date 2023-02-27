package site.xmy.hangzhou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.xmy.hangzhou.entity.HangzhouCustomerStaff;

import java.util.Date;
import java.util.List;

public interface HangzhouCustomerStaffRepository extends JpaRepository<HangzhouCustomerStaff,Long> {
    List<HangzhouCustomerStaff> findByIsDeletedFalse();
    List<HangzhouCustomerStaff> findByUpdatedAtAfter(Date updatedAt);
}