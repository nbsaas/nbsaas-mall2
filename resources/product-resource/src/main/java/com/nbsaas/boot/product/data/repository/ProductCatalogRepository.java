package com.nbsaas.boot.product.data.repository;

import com.nbsaas.boot.product.data.entity.ProductCatalog;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ProductCatalogRepository  extends  JpaRepositoryImplementation<ProductCatalog, Serializable>{

}