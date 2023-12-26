package com.nbsaas.boot.shop.data.repository;

import com.nbsaas.boot.shop.data.entity.ShopRoleMenu;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ShopRoleMenuRepository  extends  JpaRepositoryImplementation<ShopRoleMenu, Serializable>{

}