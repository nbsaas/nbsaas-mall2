package com.nbsaas.life.system.data.repository;

import com.nbsaas.life.system.data.entity.Menu;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface MenuRepository  extends  JpaRepositoryImplementation<Menu, Serializable>{

}