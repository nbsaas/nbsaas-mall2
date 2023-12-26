package com.nbsaas.life.product.data.repository;

import com.nbsaas.life.product.data.entity.ProductSpec;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ProductSpecRepository  extends  JpaRepositoryImplementation<ProductSpec, Serializable>{

}