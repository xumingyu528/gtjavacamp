//package site.xmy.projects.cs.mapper;
//
//import org.apache.ibatis.annotations.*;
//import site.xmy.projects.cs.entity.staff.CustomerStaff;
//
//@Mapper
//public interface MybatisCustomerStaffMapper {
//
//    @Select("select * from customer_staff where id=#{staffId}")
//    CustomerStaff findCustomerStaffById(Long staffId);
//
//    @Insert("insert into customer_staff(group_id, nickname, account_id, staff_name, gender, status) values(#{groupId}, #{nickname}, #{accountId}, #{staffName}, #{gender}, #{status})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    Boolean createCustomerStaff(CustomerStaff customerStaff);
//
//
//    @Update("update customer_staff set group_id = #{groupId}, nickname = #{nickname}, avatar = #{avatar}, good_at = #{goodAt}, welcome_message = #{welcomeMessage}, remark = #{remark}, status = #{status} where id = #{id} ")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    Boolean updateCustomerStaff(CustomerStaff customerStaff);
//}
