package com.nbsaas.boot.product.data.repository;

import com.nbsaas.boot.product.data.entity.Product;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ProductRepository  extends  JpaRepositoryImplementation<Product, Serializable>{

}