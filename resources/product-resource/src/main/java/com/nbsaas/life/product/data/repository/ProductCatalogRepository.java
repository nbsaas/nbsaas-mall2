package com.nbsaas.life.product.data.repository;

import com.nbsaas.life.product.data.entity.ProductCatalog;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ProductCatalogRepository  extends  JpaRepositoryImplementation<ProductCatalog, Serializable>{

}