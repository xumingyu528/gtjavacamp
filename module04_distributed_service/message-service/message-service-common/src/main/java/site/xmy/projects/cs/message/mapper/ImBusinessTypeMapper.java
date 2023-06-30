package site.xmy.projects.cs.message.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.xmy.projects.cs.message.entity.ImBusinessType;

@Mapper
public interface ImBusinessTypeMapper{

    ImBusinessType findBusinessTypeByCode(@Param("businessTypeCode") String businessTypeCode);
}
