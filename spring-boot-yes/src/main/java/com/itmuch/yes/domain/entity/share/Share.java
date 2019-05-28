package com.itmuch.yes.domain.entity.share;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author itmuch.com
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "share")
public class Share {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 发布人id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否原创 0:否 1:是
     */
    @Column(name = "is_original")
    private Byte isOriginal;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面
     */
    private String cover;

    /**
     * 概要信息
     */
    private String summary;

    /**
     * 价格（需要的积分）
     */
    private Integer price;

    /**
     * 下载地址
     */
    @Column(name = "download_url")
    private String downloadUrl;

    /**
     * 下载数
     */
    @Column(name = "buy_count")
    private Integer buyCount;

    /**
     * 是否显示 0:否 1:是
     */
    @Column(name = "show_flag")
    private Byte showFlag;

    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    @Column(name = "audit_status")
    private String auditStatus;

    /**
     * 审核不通过原因
     */
    private String reason;
}