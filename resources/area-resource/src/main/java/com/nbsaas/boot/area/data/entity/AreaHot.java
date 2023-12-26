package com.nbsaas.boot.area.data.entity;
/*
 * 版权声明和许可协议
 *
 * 版权所有 (c) 2023 纽百特®
 * 版权所有，保留所有权利
 *
 * 更多信息，请访问我们的网站：
 *
 *   http://www.newbyte.ltd
 *
 * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.jpa.data.entity.SortEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 地区
 *
 * @author 年高
 */

@Data
@Entity
@Table(name = "sys_common_area_hot")
public class AreaHot extends SortEntity {


    @Comment("区域id")
    @FieldConvert
    @FieldName
    @ManyToOne
    private Area area;


}
