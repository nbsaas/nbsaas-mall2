package com.nbsaas.life.shop.data.repository;

import com.nbsaas.life.shop.data.entity.ShopStaff;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopStaffRepository  extends  JpaRepositoryImplementation<ShopStaff, Serializable>{

}