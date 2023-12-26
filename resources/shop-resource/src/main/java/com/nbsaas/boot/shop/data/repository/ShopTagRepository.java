package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.ShopTag;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopTagRepository  extends  JpaRepositoryImplementation<ShopTag, Serializable>{

}