package com.nbsaas.life.product.data.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.bean.StoreStateBean;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@StoreStateBean
@Data
@FormAnnotation(title = "品牌", model = "品牌")
@Entity
@Table(name = "bs_brand")
@org.hibernate.annotations.Table(appliesTo = "bs_brand",comment = "品牌")
public class Brand extends AbstractEntity {


}
