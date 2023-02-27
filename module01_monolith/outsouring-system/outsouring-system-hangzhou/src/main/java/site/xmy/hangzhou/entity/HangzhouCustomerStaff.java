package site.xmy.hangzhou.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
@Table(name = "hangzhou_customer_staff")
@EntityListeners(AuditingEntityListener.class)
public class HangzhouCustomerStaff implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 昵称
     */
    private String nickname;


    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private String gender;

    /**
     * 擅长领域
     */
    private String goodAt;


    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除，1=删除,0=未删除
     */


    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @CreatedDate
    private Date createdAt;

    /**
     * 更新时间
     */
    @LastModifiedDate
    private Date updatedAt;


}
