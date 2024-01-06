package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.ShopHotWord;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopHotWordRepository  extends  JpaRepositoryImplementation<ShopHotWord, Serializable>{

}