package com.nbsaas.boot.order.data.repository;

import com.nbsaas.boot.order.data.entity.OrderHotelItem;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface OrderHotelItemRepository  extends  JpaRepositoryImplementation<OrderHotelItem, Serializable>{

}