package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.Shop;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopRepository  extends  JpaRepositoryImplementation<Shop, Serializable>{

}