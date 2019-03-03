package com.shimh.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.Type;

import com.shimh.common.entity.BaseEntity;


@Entity
@Table(name = "me_article_body")
@Data
public class ArticleBody extends BaseEntity<Long> {

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type = "text")
    private String content; // 内容

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type = "text")
    private String contentHtml;
}
