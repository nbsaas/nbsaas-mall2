package com.nbsaas.life.shop.data.repository;

import com.nbsaas.life.shop.data.entity.ShopCategory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopCategoryRepository  extends  JpaRepositoryImplementation<ShopCategory, Serializable>{

}