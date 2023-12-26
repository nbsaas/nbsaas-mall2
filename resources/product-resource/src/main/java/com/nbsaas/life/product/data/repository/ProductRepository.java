package com.nbsaas.life.product.data.repository;

import com.nbsaas.life.product.data.entity.Product;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ProductRepository  extends  JpaRepositoryImplementation<Product, Serializable>{

}