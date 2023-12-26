package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.ShopStaffRole;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopStaffRoleRepository  extends  JpaRepositoryImplementation<ShopStaffRole, Serializable>{

}