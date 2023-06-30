package site.xmy.projects.cs.search.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import site.xmy.projects.cs.search.entity.PinnedQueryConfig;
import site.xmy.projects.cs.search.mapper.PinnedQueryConfigMapper;

public interface PinnedQueryConfigService {
    //用于前台查询
    PinnedQueryConfig findActivePinnedQueryConfigBySubjectWord(String subjectWord, Integer businessType);
}
