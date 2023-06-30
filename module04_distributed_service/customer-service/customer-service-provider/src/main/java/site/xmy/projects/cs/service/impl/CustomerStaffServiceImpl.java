package site.xmy.projects.cs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.xmy.projects.cs.endpoint.CustomerStaffEndpoint;
import site.xmy.projects.cs.entity.staff.CustomerStaff;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;
import site.xmy.projects.cs.infrastructure.exception.BizException;
import site.xmy.projects.cs.infrastructure.page.PageObject;
import site.xmy.projects.cs.integration.CustomerStaffIntegrationClient;
import site.xmy.projects.cs.mapper.CustomerStaffMapper;
import site.xmy.projects.cs.service.ICustomerStaffService;
import site.xmy.projects.cs.service.IOutsourcingSystemService;

import java.util.List;
import java.util.Objects;


@Service
public class CustomerStaffServiceImpl extends ServiceImpl<CustomerStaffMapper,CustomerStaff> implements ICustomerStaffService {

    @Autowired
    IOutsourcingSystemService outsourcingSystemService;

    @Autowired
    CustomerStaffIntegrationClient customerStaffIntegrationClient;



    @Override
    public PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex) {
        return getCustomerStaffPageObject(null,pageSize,pageIndex);
    }

    @Override
    public List<CustomerStaff> findCustomerStaffs() {
        LambdaQueryWrapper<CustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex) {
        return getCustomerStaffPageObject(staffName,pageSize,pageIndex);
    }


    private PageObject<CustomerStaff> getCustomerStaffPageObject(String staffName, Long pageSize, Long pageIndex){
        LambdaQueryWrapper<CustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(CustomerStaff::getIsDeleted,false);

        if (!Objects.isNull(staffName))
            queryWrapper.like(CustomerStaff::getStaffName,staffName);
        queryWrapper.orderByDesc(CustomerStaff::getCreateTime);

        IPage<CustomerStaff> page = new Page<>(pageIndex,pageSize);
        IPage<CustomerStaff> pageResult = baseMapper.selectPage(page,queryWrapper);

        PageObject<CustomerStaff> pageObject = new PageObject<>();
        pageObject.buildPage(pageResult.getRecords(),pageResult.getTotal(),pageResult.getCurrent(),pageResult.getSize());

        return pageObject;
    }

    @Override
    public CustomerStaff findCustomerStaffById(Long staffId) {
        return baseMapper.selectById(staffId);
    }



    @Override
    public PageObject<CustomerStaff> findCustomerStaffByPhone(String phoneNum){
        return baseMapper.findCustomerStaffByPhone(phoneNum);
    }


    @Override
    public Boolean createCustomerStaff(CustomerStaff customerStaff) throws BizException {
        return this.save(customerStaff);
    }

    @Override
    public Boolean updateCustomerStaff(CustomerStaff customerStaff) {
        return this.updateById(customerStaff);
    }

    @Override
    public Boolean deleteCustomerStaffById(Long staffId) {
        return this.removeById(staffId);
    }

    @Override
    public void syncOutsourcingCustomerStaffsBySystemId(Long systemId) {
        OutsourcingSystem outsourcingSystem = outsourcingSystemService.findOutsourcingSystemById(systemId);

        //远程获取客服信息
//        List<CustomerStaff> customerStaffs = outsourcingSystemClient.getCustomerStaffs(outsourcingSystem);
        List<CustomerStaff> customerStaffs = customerStaffIntegrationClient.getCustomerStaffs(outsourcingSystem);



        this.saveBatch(customerStaffs);

    }
}
