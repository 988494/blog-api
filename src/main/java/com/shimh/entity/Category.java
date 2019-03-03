package com.shimh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

import com.shimh.common.entity.BaseEntity;


@Entity
@Table(name = "me_category")
@Data
public class Category extends BaseEntity<Integer> {

    @NotBlank
    private String categoryname;

    private String description;

    @NotBlank
    private String avatar;

}
