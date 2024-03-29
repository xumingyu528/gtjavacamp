package site.xmy.projects.cs.middleground.customer.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import site.xmy.projects.cs.infrastructure.page.PageObject;
import site.xmy.projects.cs.middleground.customer.entity.staff.CustomerStaff;

public interface CustomerStaffMapper extends BaseMapper<CustomerStaff> {
    default Long countCustomerStaffs(){
        LambdaQueryWrapper<CustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        return this.selectCount(queryWrapper);
    }


    default PageObject<CustomerStaff> findCustomerStaffByPhone(String phoneNum){
        LambdaQueryWrapper<CustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CustomerStaff::getPhone,phoneNum);

//        queryWrapper.eq()
//        LambdaQueryWrapper<CustomerStaff> customerStaffLambdaQueryWrapper = queryWrapper.like(CustomerStaff::getPhone, phoneNum);
//


        IPage<CustomerStaff> iPage = new Page<>(1,10);
        IPage<CustomerStaff> pageResult = this.selectPage(iPage,queryWrapper);

        PageObject<CustomerStaff> pageObject = new PageObject<>();
        pageObject.buildPage(pageResult.getRecords(),pageResult.getTotal(),pageResult.getCurrent(),pageResult.getSize());


        return pageObject;
    }
}
