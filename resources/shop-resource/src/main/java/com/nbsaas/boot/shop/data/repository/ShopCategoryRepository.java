package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.ShopCategory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopCategoryRepository  extends  JpaRepositoryImplementation<ShopCategory, Serializable>{

}