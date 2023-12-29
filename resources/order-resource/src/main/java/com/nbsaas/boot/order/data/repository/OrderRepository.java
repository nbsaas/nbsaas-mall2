package com.nbsaas.boot.order.data.repository;

import com.nbsaas.boot.order.data.entity.Order;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface OrderRepository  extends  JpaRepositoryImplementation<Order, Serializable>{

}