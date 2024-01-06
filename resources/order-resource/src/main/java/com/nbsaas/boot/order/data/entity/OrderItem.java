package com.nbsaas.boot.order.data.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@org.hibernate.annotations.Table(appliesTo = "bs_order_item", comment = "订单明细")
@Data
@FormAnnotation(title = "订单明细")
@Entity
@Table(name = "bs_order_item")
public class OrderItem extends AbstractEntity {
}
