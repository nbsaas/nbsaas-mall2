package com.nbsaas.life.product.data.repository;

import com.nbsaas.life.product.data.entity.Brand;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface BrandRepository  extends  JpaRepositoryImplementation<Brand, Serializable>{

}