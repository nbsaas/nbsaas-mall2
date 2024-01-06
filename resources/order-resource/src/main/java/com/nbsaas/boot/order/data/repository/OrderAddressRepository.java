package com.nbsaas.boot.order.data.repository;

import com.nbsaas.boot.order.data.entity.OrderAddress;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface OrderAddressRepository  extends  JpaRepositoryImplementation<OrderAddress, Serializable>{

}