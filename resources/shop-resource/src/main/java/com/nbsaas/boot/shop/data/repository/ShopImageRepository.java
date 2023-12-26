package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.ShopImage;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopImageRepository  extends  JpaRepositoryImplementation<ShopImage, Serializable>{

}