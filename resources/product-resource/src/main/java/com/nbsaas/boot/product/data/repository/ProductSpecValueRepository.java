package com.nbsaas.boot.product.data.repository;

import com.nbsaas.boot.product.data.entity.ProductSpecValue;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ProductSpecValueRepository  extends  JpaRepositoryImplementation<ProductSpecValue, Serializable>{

}