package site.xmy.projects.cs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import site.xmy.projects.cs.entity.tenant.OutsourcingSystem;

public interface OutsourcingSystemMapper extends BaseMapper<OutsourcingSystem> {
    default IPage findPageOutsourcingSystems(Long pageSize,Long pageIndex){
        IPage<OutsourcingSystem> page = selectPage(new Page<>(pageIndex,pageSize),null);
        return page;
    }
}
