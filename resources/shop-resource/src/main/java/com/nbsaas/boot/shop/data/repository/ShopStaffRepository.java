package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.ShopStaff;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopStaffRepository  extends  JpaRepositoryImplementation<ShopStaff, Serializable>{

}