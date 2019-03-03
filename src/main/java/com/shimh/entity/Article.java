package com.shimh.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Data;

import com.alibaba.fastjson.annotation.JSONField;
import com.shimh.common.entity.BaseEntity;


@Entity
@Table(name = "me_article")
@Data
public class Article extends BaseEntity<Integer> {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    @NotBlank
    @Column(name = "title", length = 40)
    private String title;

    @NotBlank
    @Column(name = "summary", length = 100)
    private String summary;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "body_id")
    private ArticleBody body;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "me_article_tag",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article", orphanRemoval = true)
    private List<Comment> comments;

    @Column(name = "comment_counts")
    private int commentCounts;

    @Column(name = "view_counts")
    private int viewCounts;

    /**
     * 置顶
     */
    private int weight = Article_Common;


    /**
     * 创建时间
     */
    @JSONField(format = "yyyy.MM.dd HH:mm")
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
}
