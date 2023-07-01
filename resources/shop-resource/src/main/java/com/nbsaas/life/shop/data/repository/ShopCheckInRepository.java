package com.nbsaas.life.shop.data.repository;

import com.nbsaas.life.shop.data.entity.ShopCheckIn;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopCheckInRepository  extends  JpaRepositoryImplementation<ShopCheckIn, Serializable>{

}