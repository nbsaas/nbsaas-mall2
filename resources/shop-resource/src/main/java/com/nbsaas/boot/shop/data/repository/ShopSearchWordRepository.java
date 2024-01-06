package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.ShopSearchWord;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopSearchWordRepository  extends  JpaRepositoryImplementation<ShopSearchWord, Serializable>{

}