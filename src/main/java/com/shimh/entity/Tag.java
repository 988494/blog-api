package com.shimh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;


import com.shimh.common.entity.BaseEntity;

@Entity
@Table(name = "me_tag")
@Data
public class Tag extends BaseEntity<Integer> {

    @NotBlank
    //标签名称
    private String tagname;

    @NotBlank
    private String avatar;

}
