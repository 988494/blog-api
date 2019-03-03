package com.shimh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Data;

import com.alibaba.fastjson.annotation.JSONField;
import com.shimh.common.entity.BaseEntity;

@Entity
@Table(name = "sys_user")
@Data
public class User extends BaseEntity<Long> {

    @NotBlank
    @Column(name = "account", unique = true, length = 10)
    private String account;

    /**
     * 使用md5(username + original password + salt)加密存储
     */
    @NotBlank
    @Column(name = "password", length = 64)
    private String password;

    /**
     * 头像
     */
    private String avatar;

    @Column(name = "email", unique = true, length = 20)
    private String email;  // 邮箱

    @NotBlank
    @Column(name = "nickname", length = 10)
    private String nickname;

    @Column(name = "mobile_phone_number", length = 20)
    private String mobilePhoneNumber;


    /**
     * 加密密码时使用的种子
     */
    private String salt;


    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    /*TemporalType.TIMESTAMP---->在页面端取值：2011-04-12 22:51:34.0
     TemporalType.DATE---->在页面端取值：2011-04-12
     TemporalType.TIME---->在页面端取值：22:50:30
    */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


    /**
     * 最后一次登录时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    /**
     * 系统用户的状态
     */
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.normal;

    /**
     * 是否是管理员
     */
    private Boolean admin = false;

    /**
     * 逻辑删除flag
     */
    private Boolean deleted = Boolean.FALSE;
}
