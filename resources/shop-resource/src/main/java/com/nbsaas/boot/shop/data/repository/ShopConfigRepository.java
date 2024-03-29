package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.ShopConfig;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopConfigRepository  extends  JpaRepositoryImplementation<ShopConfig, Serializable>{

    ShopConfig findByClassNameAndShopId(String simpleName, Long shop);
}