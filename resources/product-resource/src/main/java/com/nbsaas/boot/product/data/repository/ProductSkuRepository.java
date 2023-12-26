package com.nbsaas.boot.product.data.repository;

import com.nbsaas.boot.product.data.entity.ProductSku;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ProductSkuRepository  extends  JpaRepositoryImplementation<ProductSku, Serializable>{

}