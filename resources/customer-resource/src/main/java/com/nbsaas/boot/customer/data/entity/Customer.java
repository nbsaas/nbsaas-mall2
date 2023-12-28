package com.nbsaas.boot.customer.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.code.annotation.data.Dict;
import com.nbsaas.boot.code.annotation.data.DictItem;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@org.hibernate.annotations.Table(appliesTo = "user_info",comment = "客户表")
@CreateByUser
@ComposeView
@Data
@FormAnnotation(title = "客户", model = "客户", menu = "1,60,61",searchWidth = "100",viewWidth = "120")
@Entity
@Table(name = "user_info")
public class Customer extends AbstractEntity {

    @Comment("客户名称")
    @SearchItem(name = "name",key = "name",label = "客户名称")
    @FormField(title = "客户名称", sortNum = "1", grid = true,required = true)
    @Column(length = 30)
    private String name;

    @Comment("真实姓名")
    @SearchItem(name = "realName",key = "realName",label = "真实姓名")
    @FormField(title = "真实姓名", sortNum = "1", grid = true,required = true)
    @Column(length = 30)
    private String realName;

    @Comment("联系电话")
    @FormField(title = "联系电话", sortNum = "1", grid = true)
    @Column(length = 30)
    private String phone;

    @Comment("身份证号码")
    private String idNumber;

    @Comment("身份证前面")
    private String frontIdCard;

    @Comment("身份证后面")
    private String backIdCard;


    @Comment("自拍照")
    private String selfFile;

    @Comment("性别")
    private String sex;

    @Comment("生日")
    private String birthDate;

    @Comment("地址")
    private String address;

    @Comment("审核状态 0待审核,1审核通过,2审核失败")
    @Dict(items = {
            @DictItem(value = 0, label = "待审核"),
            @DictItem(value = 1, label = "审核通过"),
            @DictItem(value = 2, label = "审核失败")
    })
    private Integer auditState;

    @Comment("备注")
    private String comment;



}
