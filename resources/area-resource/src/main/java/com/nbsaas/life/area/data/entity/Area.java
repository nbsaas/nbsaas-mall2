package com.nbsaas.life.area.data.entity;
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
 *
 */

import com.nbsaas.boot.code.annotation.CatalogClass;
import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@FormAnnotation(title = "地区", model = "地区")
@CatalogClass(lazyData = true)
@org.hibernate.annotations.Table(appliesTo = "sys_common_area", comment = "地区")
@Data
@Entity
@Table(name = "sys_common_area")
public class Area extends CatalogEntity {


    @Comment("经度")
    private Double lng;

    @Comment("纬度")
    private Double lat;

    @Comment("国标编码")
    private String govCode;

    @Comment("地区类型")
    private String areaType;

    @Comment("地区全称")
    private String fullName;

    @Comment("状态")
    private Integer state;

    @SearchItem(label = "父分类", name = "parent", key = "parent.id", operator = "eq", classType = Long.class)
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Area parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Area> children;

    @Override
    public Serializable getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
