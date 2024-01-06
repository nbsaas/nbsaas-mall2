package com.nbsaas.boot.store.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@CatalogClass
@FormAnnotation(title = "场馆分类管理",model = "场馆分类",menu = "1,63,65")
@Data
@Entity
@Table(name = "bs_store_catalog")
public class StoreCatalog extends CatalogEntity {


  @FieldConvert
  @JoinColumn(name = "parent_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private StoreCatalog parent;


  @OneToMany(fetch = FetchType.LAZY,mappedBy = "parent")
  private List<StoreCatalog> children;
  
  /**
   * 保护范围
   */
  @FormField(title = "保护范围")
  private Integer distance;

  @FormField(title = "分类图标",type = InputType.image)
  private String logo;

  @FormField(title = "分类图标",type = InputType.image)
  private String icon;

  @FormField(title = "分类图标",type = InputType.image)
  private String icon2;

  /**
   * 会员商家图标
   */
  @FormField(title = "会员商家图标",type = InputType.image)
  private String vip;


  /**
   * 协议商家图标
   */
  @FormField(title = "协议商家图标",type = InputType.image)
  private String single;

  @FormField(title = "展示渠道")
  private String  channel;
  
  @Override
  public Long getParentId() {
    if (parent != null) {
      return parent.getId();
    }
    return null;
  }
  
}
