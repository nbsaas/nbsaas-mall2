package com.nbsaas.boot.product.data.repository;

import com.nbsaas.boot.product.data.entity.ProductSpec;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ProductSpecRepository  extends  JpaRepositoryImplementation<ProductSpec, Serializable>{

}