package com.nbsaas.life.product.data.repository;

import com.nbsaas.life.product.data.entity.ProductSku;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ProductSkuRepository  extends  JpaRepositoryImplementation<ProductSku, Serializable>{

}