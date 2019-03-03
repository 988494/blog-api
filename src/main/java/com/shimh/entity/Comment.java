package com.shimh.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.alibaba.fastjson.annotation.JSONField;
import com.shimh.common.entity.BaseEntity;

@Entity
@Table(name = "me_comment")
@Data
public class Comment extends BaseEntity<Integer> {

    @NotBlank
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    /**
     * 类型 0 文章的评论 1 评论的评论 2 评论的回复 @
     */
    @Column(name = "level",length = 1)
    private String level;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy.MM.dd HH:mm")
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @OneToMany
    @JoinColumn(name = "parent_id",nullable = true)
    private List<Comment> childrens;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @NotFound(action= NotFoundAction.IGNORE)
    private Comment parent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_uid")
    private User toUser;
}
