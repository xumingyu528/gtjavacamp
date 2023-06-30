package site.xmy.projects.cs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;
import site.xmy.projects.cs.infrastructure.page.PageObject;
import site.xmy.projects.cs.mapper.OutsourcingSystemMapper;
import site.xmy.projects.cs.service.IOutsourcingSystemService;

import java.util.List;

@Service
public class OutsourcingSystemServiceImpl extends ServiceImpl<OutsourcingSystemMapper,OutsourcingSystem> implements IOutsourcingSystemService {


    //查询所有记录，List形式
    @Override
    public List<OutsourcingSystem> findAllOutsourcingSystems() {
        LambdaQueryWrapper<OutsourcingSystem> queryWrapper = new LambdaQueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    //按分页查询记录，返回PageObject形式
    @Override
    public PageObject<OutsourcingSystem> findPagedOutsourcingSystems(Long pageSize, Long pageIndex) {
        IPage<OutsourcingSystem> pageResult = baseMapper.findPageOutsourcingSystems(pageSize,pageIndex);
        PageObject<OutsourcingSystem> pageObject = new PageObject<>();
        pageObject.buildPage(pageResult.getRecords(),pageResult.getTotal(),pageResult.getCurrent(),pageResult.getSize());

        return pageObject;
    }

    @Override
    public OutsourcingSystem findOutsourcingSystemById(Long systemId) {
        return baseMapper.selectById(systemId) ;
    }

    @Override
    public Boolean addOutsourcingSystem(OutsourcingSystem outsourcingSystem) {
        return this.save(outsourcingSystem);
    }

    @Override
    public Boolean updateOutsourcingSystem(OutsourcingSystem outsourcingSystem) {
        return this.updateById(outsourcingSystem);
    }

    @Override
    public Boolean deleteOutsourcingSystemById(Long systemId) {
        return this.removeById(systemId);
    }
}
