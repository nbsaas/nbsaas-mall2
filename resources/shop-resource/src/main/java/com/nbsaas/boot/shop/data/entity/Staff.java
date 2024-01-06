package com.nbsaas.boot.shop.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@org.hibernate.annotations.Table(appliesTo = "user_info", comment = "客户表")
@CreateByUser
@ComposeView
@Data
@FormAnnotation(title = "客户", model = "客户", menu = "1,60,61", searchWidth = "100", viewWidth = "120")
@Entity
@Table(name = "user_info")
public class Staff extends LongEntity {

    @Comment("客户名称")
    @SearchItem(name = "name", key = "name", label = "客户名称")
    @FormField(title = "客户名称", width = "160", grid = true, required = true)
    @Column(length = 30)
    private String name;

    @Comment("联系电话")
    @FormField(title = "联系电话", width = "200", grid = true)
    @Column(length = 30)
    private String phone;

    @Comment("头像")
    private String avatar;

    /**
     * 项目内容
     */
    @Comment("内容")
    @FormField(title = "内容", sortNum = "10", type = InputType.richText, col = 23)
    private String note;


    @FormField(title = "注册日期", sortNum = "10", width = "10000", grid = true, ignore = true)
    @Comment("添加时间")
    private Date addDate;

    /**
     * 最新修改时间
     */
    @Comment("最新修改时间")
    private Date lastDate;
}
