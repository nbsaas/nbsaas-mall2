package com.nbsaas.boot.shop.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@org.hibernate.annotations.Table(appliesTo = "shop_tag", comment = "店铺标签")
@Data
@Entity
@Table(name = "shop_tag")
public class ShopTag extends AbstractEntity {


	@Comment("商家标签名称")
	@Column(length = 100)
	private String name;

	@Comment("使用的店铺标签数量")
	private Integer size;


}
