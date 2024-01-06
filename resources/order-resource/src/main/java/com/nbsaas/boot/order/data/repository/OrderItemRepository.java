package com.nbsaas.boot.order.data.repository;

import com.nbsaas.boot.order.data.entity.OrderItem;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface OrderItemRepository  extends  JpaRepositoryImplementation<OrderItem, Serializable>{

}