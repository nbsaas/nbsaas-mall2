package com.nbsaas.life.shop.data.repository;

import com.nbsaas.life.shop.data.entity.ShopImage;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopImageRepository  extends  JpaRepositoryImplementation<ShopImage, Serializable>{

}