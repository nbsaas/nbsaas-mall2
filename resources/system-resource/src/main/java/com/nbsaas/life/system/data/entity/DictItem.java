package com.nbsaas.life.system.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@org.hibernate.annotations.Table(appliesTo = "sys_dict_item", comment = "字典子项")
@Data
@Entity
@Table(name = "sys_dict_item")
public class DictItem extends AbstractEntity {


    @Comment("编码")
    private String dataCode;

    @Comment("键值")
    private String dataValue;

    @Comment("排序字段")
    private Integer sortNum;

    private StoreState storeState;

    @ManyToOne(fetch = FetchType.LAZY)
    @FieldConvert
    @FieldName(name = "title")
    private Dict dict;

}
