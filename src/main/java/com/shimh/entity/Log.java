package com.shimh.entity;

import com.shimh.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_log")
@Data
public class Log extends BaseEntity<Integer> {

    @Column(name = "userid")
    private Long userId;

    @Column(name = "nickname", length = 10)
    private String nickname;

    @Column(name = "module", length = 10)
    private String module;

    @Column(name = "operation", length = 25)
    private String operation;

    @Column(name = "method", length = 100)
    private String method;

    @Column(name = "params")
    private String params;

    @Column(name = "time")
    private Long time;

    @Column(name = "ip", length = 15)
    private String ip;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public Log() {
        super();
    }

}
