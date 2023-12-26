package com.nbsaas.life.shop.data.repository;

import com.nbsaas.life.shop.data.entity.ShopConfig;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopConfigRepository  extends  JpaRepositoryImplementation<ShopConfig, Serializable>{

}